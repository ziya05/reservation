package com.ziya05.reservation.backend.vo;

import java.util.List;

public class ConsultantPersonal extends SimpleConsultant {
	
	/**
     * 个人介绍
     */
    private String introducation;
    
    /**
     * 预约开放信息
     */
    private List<SimpleInformation> infoItems;

	public String getIntroducation() {
		return introducation;
	}

	public void setIntroducation(String introducation) {
		this.introducation = introducation;
	}

	public List<SimpleInformation> getInfoItems() {
		return infoItems;
	}

	public void setInfoItems(List<SimpleInformation> infoItems) {
		this.infoItems = infoItems;
	}

}
