package com.ziya05.reservation.backend.vo;

public class WxCodeForLogin {
	
	private String appId;
	
	private String secret;
	
	private String jsCode;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appid) {
		this.appId = appid;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getJsCode() {
		return jsCode;
	}

	public void setJsCode(String jsCode) {
		this.jsCode = jsCode;
	}

}
