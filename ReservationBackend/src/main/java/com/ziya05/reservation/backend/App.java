package com.ziya05.reservation.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.ziya05.reservation.backend.mapper")
@ComponentScan(basePackages = {"com.ziya05.reservation.backend", "org.n3r.idworker"})
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
