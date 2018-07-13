package com.ziya05.reservation.backend.service;

import java.util.List;

import com.ziya05.reservation.backend.vo.InformationItem;

public interface InformationService {
	List<InformationItem> getActivedInformation() throws InstantiationException, IllegalAccessException;
}
