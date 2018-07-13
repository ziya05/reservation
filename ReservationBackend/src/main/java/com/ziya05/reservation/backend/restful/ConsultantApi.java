package com.ziya05.reservation.backend.restful;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ziya05.reservation.backend.service.ConsultantService;
import com.ziya05.reservation.backend.vo.ConsultantPersonal;
import com.ziya05.reservation.backend.vo.JSONResult;
import com.ziya05.reservation.backend.vo.SimpleConsultant;

@RestController
@RequestMapping("/consultant")
public class ConsultantApi {

	@Autowired
	private ConsultantService consultantService;
	
	@RequestMapping("/all")
	public JSONResult getAllConsultant() {
		
		List<SimpleConsultant> lst = consultantService.getAllSimpleConsultant();
		return JSONResult.ok(lst);
	}
	
	@RequestMapping("/get/{id}")
	public JSONResult getConsultant(@PathVariable("id") String id) throws InstantiationException, IllegalAccessException, ParseException {
		ConsultantPersonal consultantPersonal = consultantService.getConsultantPersonal(id);
		return JSONResult.ok(consultantPersonal);
	}

}
