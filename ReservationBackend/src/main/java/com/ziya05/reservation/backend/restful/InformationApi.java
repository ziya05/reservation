package com.ziya05.reservation.backend.restful;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ziya05.reservation.backend.service.InformationService;
import com.ziya05.reservation.backend.vo.InformationItem;
import com.ziya05.reservation.backend.vo.JSONResult;

@RestController
@RequestMapping("/infor")
public class InformationApi {
	
	@Autowired
	private InformationService informationService;

	@RequestMapping("/actived")
	public JSONResult getActivedInformation() throws InstantiationException, IllegalAccessException {
		List<InformationItem> items = informationService.getActivedInformation();
		return JSONResult.ok(items);
	}
}
