package com.ziya05.reservation.backend.restful;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ziya05.reservation.backend.bo.WxLoginData;
import com.ziya05.reservation.backend.service.WxMiniProgramService;
import com.ziya05.reservation.backend.vo.JSONResult;
import com.ziya05.reservation.backend.vo.WxCodeForLogin;
import com.ziya05.reservation.backend.vo.WxEncryptedData;

@RestController
@RequestMapping("/wx-app")
public class WxMiniProgramApi {
	
	@Autowired
	private WxMiniProgramService wxMiniProgramService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public JSONResult Login(@RequestBody WxCodeForLogin codeData) {

		String data = wxMiniProgramService.login(codeData);
		return JSONResult.ok(data);
	}
	
	@RequestMapping(value = "/parse", method = RequestMethod.POST)
	public JSONResult Parse(@RequestBody WxEncryptedData wxEncryptedData) {
		String data = wxMiniProgramService.parse(
				wxEncryptedData.getId(), 
				wxEncryptedData.getEncryptedData(), 
				wxEncryptedData.getIv());
		
		return JSONResult.ok(data);
	}
}
