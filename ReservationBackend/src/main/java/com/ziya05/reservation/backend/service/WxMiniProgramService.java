package com.ziya05.reservation.backend.service;

import com.ziya05.reservation.backend.bo.WxLoginData;
import com.ziya05.reservation.backend.vo.WxCodeForLogin;

public interface WxMiniProgramService {
	String login(WxCodeForLogin codeData);
	
	String parse(String id, String encryptedData, String iv);
}
