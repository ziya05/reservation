package com.ziya05.reservation.backend.service.impl;

import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alibaba.druid.util.StringUtils;
import com.ziya05.reservation.backend.bo.WxLoginData;
import com.ziya05.reservation.backend.converter.WxMappingJackson2HttpMessageConverter;
import com.ziya05.reservation.backend.mapper.PatientMapper;
import com.ziya05.reservation.backend.pojo.Patient;
import com.ziya05.reservation.backend.service.WxMiniProgramService;
import com.ziya05.reservation.backend.utils.WXCore;
import com.ziya05.reservation.backend.vo.WxCodeForLogin;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service
public class WxMiniProgramServiceImpl implements WxMiniProgramService {

	@Autowired
    private RestTemplateBuilder restTemplateBuilder;
	
	@Autowired
	private PatientMapper patientMapper;
	
	@Autowired
	private  StringRedisTemplate redisTemplate;
	
	@Override
	public String login(WxCodeForLogin codeData) {
		if (codeData == null) {
			throw new IllegalArgumentException("codeData 不能为空！");
		}
		
		if (StringUtils.isEmpty(codeData.getAppId())) {
			throw new IllegalArgumentException("appid 不能为空！");
		}
		
		if (StringUtils.isEmpty(codeData.getSecret())) {
			throw new IllegalArgumentException("secret 不能为空！");
		}
		
		if (StringUtils.isEmpty(codeData.getJsCode())) {
			throw new IllegalArgumentException("jscode 不能为空！");
		}
		
		
		String address = String.format("https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code",
				codeData.getAppId(), 
				codeData.getSecret(), 
				codeData.getJsCode());
		
		RestTemplate restTemplate = restTemplateBuilder.build();
		restTemplate.getMessageConverters().add(new WxMappingJackson2HttpMessageConverter());
		
		WxLoginData data = restTemplate.getForObject(address, WxLoginData.class);
				
		if (!StringUtils.isEmpty(data.getErrmsg())) {
			throw new IllegalArgumentException(data.getErrmsg());
		} 

		Example example = new Example(Patient.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("openId", data.getOpenId());
		
		Patient patient = patientMapper.selectOneByExample(example);
		if (patient == null) {
			Sid sid = new Sid();
			patient = new Patient();
			
			patient.setId(sid.nextShort());
			patient.setOpenId(data.getOpenId());
			patientMapper.insert(patient);
		}
		
		redisTemplate.opsForValue().set(patient.getId(), 
				data.getOpenId() + "," + data.getSessionKey() + "," + codeData.getAppId());
		
		return patient.getId();	
	}
	
	public String parse(String id, String encryptedData, String iv) {
		String value = redisTemplate.opsForValue().get(id);
		if(StringUtils.isEmpty(value)) {
			throw new IllegalArgumentException("该用户未登录或者登录已失效！");
		}
		
		String[] vals = value.split(",");
		if (vals.length < 3) {
			throw new ArrayIndexOutOfBoundsException("登录数据错误！");
		}
		
		String sessionKey = vals[1];
		String appId = vals[2];
		
		return WXCore.decrypt(appId, encryptedData, sessionKey, iv);
 	}
}
