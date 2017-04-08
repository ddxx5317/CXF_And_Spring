package com.ws.cxf.impl;

import java.util.Date;
import java.util.List;

import javax.jws.WebService;

import com.cxf.ws.bean.Cat;
import com.cxf.ws.bean.User;
import com.cxf.ws.service.UserService;
import com.ws.cxf.HelloWord;

@WebService(endpointInterface="com.ws.cxf.HelloWord",serviceName="HelloWordImpl")
public class HelloWordImpl implements HelloWord {

	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@Override
	public String sayHi(String name) {
		
		return name+",您好！"+","+"现在时间是："+new Date();
	}
	@Override
	public List<Cat> getCatsByUser(User user) {
		return userService.getCatsByUser(user);
	}
}
