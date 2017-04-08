package com.cxf.ws.service;

import java.util.List;

import com.cxf.ws.bean.Cat;
import com.cxf.ws.bean.User;

public interface UserService {
	public List<Cat> getCatsByUser(User user);
}
