package com.ziya05.reservation.backend.service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ziya05.reservation.backend.bo.DayDetail;
import com.ziya05.reservation.backend.mapper.ConsultantMapper;
import com.ziya05.reservation.backend.mapper.InformationMapper;
import com.ziya05.reservation.backend.pojo.Consultant;
import com.ziya05.reservation.backend.pojo.Information;
import com.ziya05.reservation.backend.service.ConsultantService;
import com.ziya05.reservation.backend.utils.ProjectUtils;
import com.ziya05.reservation.backend.vo.ConsultantPersonal;
import com.ziya05.reservation.backend.vo.SimpleConsultant;
import com.ziya05.reservation.backend.vo.SimpleInformation;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service
public class ConsultantServiceImpl implements ConsultantService {

	// 显示擅长的最大个数
	private final int SHOW_GOODAT_LEN = 3; 
	
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
	public List<SimpleConsultant> getAllSimpleConsultant() {
		List<Consultant> consultantLst = consultantMapper.selectAll();

		List<SimpleConsultant> lst = new ArrayList<SimpleConsultant>();
		for(Consultant consultant : consultantLst) {
			SimpleConsultant simple = new SimpleConsultant();
			BeanUtils.copyProperties(consultant, simple);

			List<String> goodAtLst = this.getGoodAtLst(consultant.getGoodAt(), true);
			simple.setGoodAt(goodAtLst);
			
			int age = this.getAge(consultant.getBirthday());
			simple.setAge(age);
			
			int booked = age % 4; // 需修改， 临时测试
			simple.setBooked(booked);
			
			lst.add(simple);
		}
		
		return lst;
	}

	@Override
	public ConsultantPersonal getConsultantPersonal(String id) throws InstantiationException, IllegalAccessException, ParseException {
		Consultant consultant = consultantMapper.selectByPrimaryKey(id);
		
		ConsultantPersonal consultantPersonal = new ConsultantPersonal();
		BeanUtils.copyProperties(consultant, consultantPersonal);
		
		List<String> goodAtLst = this.getGoodAtLst(consultant.getGoodAt(), true);
		consultantPersonal.setGoodAt(goodAtLst);
		
		int age = this.getAge(consultant.getBirthday());
		consultantPersonal.setAge(age);
		
		Example example = new Example(Information.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("consultantId", id);
		criteria.andEqualTo("deleted", INFORMATION_NO_DELETED);
		criteria.andNotEqualTo("status", INFORMATION_CLOSED);
		
		String laterSimpleDate = ProjectUtils.getLaterSimpleDate(SHOW_INFORMATION_DAY_COUNT - 1);
		System.out.println(laterSimpleDate);
		criteria.andBetween("openingDate", 
				ProjectUtils.getSimpleDate(),
				laterSimpleDate);
		
		example.setOrderByClause("opening_date");
		List<Information> informationLst = informationMapper.selectByExample(example);

		List<DayDetail> dayDetailLst = ProjectUtils.getDayDetailList(ProjectUtils.getToday(), 
				ProjectUtils.getLaterDate(SHOW_INFORMATION_DAY_COUNT));
		
		int lastWeek = -1;
		List<SimpleInformation> simpleInformationLst = new ArrayList<SimpleInformation>();
		consultantPersonal.setInfoItems(simpleInformationLst);
		SimpleInformation simpleInformation = null;
		List<SimpleInformation.DayInformation> dayInformationLst = null;
		for(DayDetail detail : dayDetailLst) {
			if (lastWeek != detail.getWeekOfYear()) {
				simpleInformation = new SimpleInformation();
				simpleInformation.setWeekOfYear(detail.getWeekOfYear());
				simpleInformationLst.add(simpleInformation);
				dayInformationLst = new ArrayList<SimpleInformation.DayInformation>();
				simpleInformation.setItems(dayInformationLst);
				
				lastWeek = detail.getWeekOfYear();
			}
			
			SimpleInformation.DayInformation dayInformation = 
					simpleInformation.new DayInformation();
			dayInformationLst.add(dayInformation);
			
			dayInformation.setDay(detail.getDay());
			dayInformation.setDayOfWeek(detail.getDayOfWeek());
			
			dayInformation.setStatus(detail.getStatus());
			
			if (detail.getStatus() == 1) {
				int dayStatus = 2; //未开放
				
				List<SimpleInformation.DurationInformation> durationInformationLst = 
					new ArrayList<SimpleInformation.DurationInformation>();
				
				int count = informationLst.size();
				for (int i = count - 1; i >= 0; i--) {
					Information information = informationLst.get(i);
					
					Date openingDate = information.getOpeningDate();
					Date detailDate = detail.getDate();

					if (ProjectUtils.dateEquals(openingDate, detailDate)) {

						SimpleInformation.DurationInformation durationInformation =
								simpleInformation.new DurationInformation();
						
						durationInformation.setId(information.getId());
						durationInformation.setBeginTime(
								ProjectUtils.getSimpleTime(information.getBeginTime()));
						durationInformation.setEndTime(
								ProjectUtils.getSimpleTime(information.getEndTime()));
						
						int status = information.getStatus();
						if (status == 0) {  
							durationInformationLst.add(durationInformation);
							dayStatus = 1;  // 可预约
						} else if ((status == 1 || status == 2) && dayStatus != 1) {
							dayStatus = 3;  //约满
						}
						
						informationLst.remove(information);
					}
				}
				
				dayInformation.setStatus(dayStatus);
				Collections.sort(durationInformationLst);
				dayInformation.setItems(durationInformationLst);
			}
		}
		
		return consultantPersonal;
	}
	
	private int getAge(Date birthday) {
		Calendar cal=Calendar.getInstance();   
		int year = cal.get(Calendar.YEAR);   
		
		cal.setTime(birthday);
		return year - cal.get(Calendar.YEAR);
	}
	
	private List<String> getGoodAtLst(String goodAt, Boolean lengthLimited) {
		List<String> goodAtLst = new ArrayList<String>();
		
		if (!StringUtils.isAllBlank(goodAt)) {
			String[] arr = goodAt.split(",");
			
			int l = arr.length;
			
			if (lengthLimited 
					&& arr.length > SHOW_GOODAT_LEN) { 
				l = SHOW_GOODAT_LEN;
			}
			
			for (int i = 0; i < l; i++) {
				goodAtLst.add(arr[i]);
			}
		}
		
		return goodAtLst;
	}

}
