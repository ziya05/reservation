package com.ziya05.reservation.backend.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport{

	private static final Logger log = LoggerFactory.getLogger(WebMvcConfig.class);
	
	@Value("${my.image.path}")
	private String imgPath;
	
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		log.info("注册新路径");
		
		log.info("图片路径为：" + imgPath);
		
		registry.addResourceHandler("/**")
				.addResourceLocations("file:" + imgPath);
	}
	
}
