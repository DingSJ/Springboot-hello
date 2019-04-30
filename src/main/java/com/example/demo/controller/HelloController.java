package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.bean.User;

/**
 * @author dingsj
 * */
@Controller
public class HelloController {

	@Value("${test.prop.id}")
	private String id;
	@Value("${test.prop.name}")
	private String name;
	@Value("${test.prop.addr}")
	private String addr;
	
	Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	@RequestMapping("hello")
	public String hello(Model model) {
		logger.info("Hello Controller run ....");
		User user = new User("U10000001","Test","北京市丰台区科技园");
		
		User user2 = new User(id,name,addr);
		logger.info("User : " + user2.toString());
		model.addAttribute("user", user);              //  传给页面
		return "index";
	}
}
