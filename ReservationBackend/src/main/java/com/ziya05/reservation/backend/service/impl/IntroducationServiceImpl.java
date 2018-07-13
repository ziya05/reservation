package com.ziya05.reservation.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ziya05.reservation.backend.mapper.IntroducationMapper;
import com.ziya05.reservation.backend.pojo.Introducation;
import com.ziya05.reservation.backend.service.IntroducationService;

import tk.mybatis.mapper.entity.Example;

@Service
public class IntroducationServiceImpl implements IntroducationService {

	@Autowired
	private IntroducationMapper introducationMapper;
	
	@Override
	public List<Introducation> getAllIntroducation() {
		
		Example example = new Example(Introducation.class);
		example.setOrderByClause("weight desc");
	
		return introducationMapper.selectByExample(example);
	}

}
