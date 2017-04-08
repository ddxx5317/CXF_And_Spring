package com.cxf.ws.service.impl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cxf.ws.bean.Cat;
import com.cxf.ws.bean.User;
import com.cxf.ws.service.UserService;

public class UserServiceImpl implements UserService {

	
	static Map<User,List<Cat>> catDb = new HashMap<User,List<Cat>>();
	static{
		List<Cat> catList1 = new ArrayList<Cat>();
		catList1.add(new Cat(1,"加菲猫","黑色"));
		catList1.add(new Cat(2,"机器猫","黄色"));
		catDb.put(new User(1,"A","123","幽灵城堡"), catList1);
		
		List<Cat> catList2 = new ArrayList<Cat>();
		catList2.add(new Cat(3,"泰迪","黑色"));
		catList2.add(new Cat(4,"花猫","棕色"));
		catDb.put(new User(2,"B","456","海盗船"), catList2);
	}
	@Override
	public List<Cat> getCatsByUser(User user) {
		return catDb.get(user);
	}

}
