package com.ws.cxf;

import java.util.List;

import javax.jws.WebService;

import com.cxf.ws.bean.Cat;
import com.cxf.ws.bean.User;

@WebService
public interface HelloWord {

	public String sayHi(String name);
	
	public List<Cat> getCatsByUser(User user);
}
