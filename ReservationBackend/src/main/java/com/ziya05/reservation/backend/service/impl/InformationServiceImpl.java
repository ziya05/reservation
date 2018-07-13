package com.ziya05.reservation.backend.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ziya05.reservation.backend.mapper.ConsultantMapper;
import com.ziya05.reservation.backend.mapper.InformationMapper;
import com.ziya05.reservation.backend.pojo.Consultant;
import com.ziya05.reservation.backend.pojo.Information;
import com.ziya05.reservation.backend.service.InformationService;
import com.ziya05.reservation.backend.utils.ProjectUtils;
import com.ziya05.reservation.backend.vo.InformationItem;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service
public class InformationServiceImpl implements InformationService {
	
	// 获取预约开放信息的天数
	private final int SHOW_INFORMATION_DAY_COUNT = 28;
	
	// 未删除
	private final int INFORMATION_NO_DELETED = 0;
	
	// 已关闭
	private final int INFORMATION_CLOSED = 3;
	
	@Autowired
	private ConsultantMapper consultantMapper;
	
	@Autowired
	private InformationMapper informationMapper;
	
	@Override
	public List<InformationItem> getActivedInformation() throws InstantiationException, IllegalAccessException {

		List<InformationItem> items = new ArrayList<InformationItem>();
		
		Example example = new Example(Information.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("deleted", INFORMATION_NO_DELETED);
		criteria.andNotEqualTo("status", INFORMATION_CLOSED);
		
		String laterSimpleDate = ProjectUtils.getLaterSimpleDate(SHOW_INFORMATION_DAY_COUNT - 1);
		System.out.println(laterSimpleDate);
		criteria.andBetween("openingDate", 
				ProjectUtils.getSimpleDate(),
				laterSimpleDate);
		
		example.setOrderByClause("opening_date, week_of_year, day_of_week");
		List<Information> informationLst = informationMapper.selectByExample(example);
		
		List<Consultant> consultantLst = consultantMapper.selectAll();
		
		for(Information information : informationLst) {
			InformationItem item = new InformationItem();
			BeanUtils.copyProperties(information, item);
			
			item.setDate(ProjectUtils.getSimpleDate(information.getOpeningDate(), "MM-dd"));
			item.setBeginTime(ProjectUtils.getSimpleTime(information.getBeginTime()));
			item.setEndTime(ProjectUtils.getSimpleTime(information.getEndTime()));
			
			for(Consultant consultant : consultantLst) {
				if (information.getConsultantId().equals(consultant.getId())) {
					item.setProfile(consultant.getProfile());
					item.setName(consultant.getName());
					
					break;
				}
			}
			
			items.add(item);
		}
		
		return items;
	}
}
