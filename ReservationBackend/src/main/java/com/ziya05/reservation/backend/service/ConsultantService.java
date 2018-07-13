package com.ziya05.reservation.backend.service;

import java.text.ParseException;
import java.util.List;

import com.ziya05.reservation.backend.vo.ConsultantPersonal;
import com.ziya05.reservation.backend.vo.SimpleConsultant;

public interface ConsultantService {
	List<SimpleConsultant> getAllSimpleConsultant();
	
	ConsultantPersonal getConsultantPersonal(String id) throws InstantiationException, IllegalAccessException, ParseException;

}
