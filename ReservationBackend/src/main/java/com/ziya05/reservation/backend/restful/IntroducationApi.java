package com.ziya05.reservation.backend.restful;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ziya05.reservation.backend.pojo.Introducation;
import com.ziya05.reservation.backend.service.IntroducationService;
import com.ziya05.reservation.backend.vo.JSONResult;

@RestController
@RequestMapping("/intro")
public class IntroducationApi {
	
	@Autowired
	private IntroducationService introducationService;
	
	@RequestMapping("/all")
	public JSONResult getAllIntroducation() {
		
		List<Introducation> lst = introducationService.getAllIntroducation();
		
		return JSONResult.ok(lst);
	}
}
