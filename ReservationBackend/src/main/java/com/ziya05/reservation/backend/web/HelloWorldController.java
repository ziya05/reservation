package com.ziya05.reservation.backend.web;

import java.util.List;

import org.n3r.idworker.Sid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.ziya05.reservation.backend.mapper.UserMapper;
//import com.ziya05.reservation.backend.pojo.User;

@RestController
public class HelloWorldController {
	private static final Logger log = LoggerFactory.getLogger(HelloWorldController.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	Sid sid;
	
//	@Autowired
//	UserMapper mapper;
//	
	@RequestMapping("/")
	public String sayHello() {
		return "Hello, World!";
	}
	
	@RequestMapping("/user")
	public String queryUser() {
			
		String sql = "select name from mytest where id = 1";
		List<String> lst = jdbcTemplate.queryForList(sql, String.class);
		
		return lst.isEmpty() ? null : lst.get(0);
	}
	
//	@RequestMapping("/insert")
//	public String insertUser() {
//
//		User user1 = new User();
//		user1.setName("阿花");
//		user1.setAge(22.5);
//		user1.setGender(false);
//		user1.setDesc("我是谁？我从哪来？");
//		user1.setUserId(sid.nextShort());
//		
//		mapper.insert(user1);
//		
//		User user2 = new User();
//		
//		BeanUtils.copyProperties(user1, user2);
//		
//		List<User> lst = mapper.select(user2);
//		
//		return lst.isEmpty() ? null : lst.get(0).getId().toString();
//	}

	@RequestMapping("/log")
	public String log() {
		log.info("这是info类型的log");
		log.debug("这是debug类型的log");
		log.error("这是error类型的log");
		log.trace("这是trace类型的log");
		log.warn("这是warn类型的log");
		
		return "日志打印结束";
	}
}
