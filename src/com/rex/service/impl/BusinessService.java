package com.rex.service.impl;

import static org.hamcrest.CoreMatchers.nullValue;

import javax.enterprise.inject.New;

import com.rex.dao.UserDao;
import com.rex.dao.impl.UserDaoImpl;
import com.rex.domain.User;
import com.rex.exception.UserExistException;
import com.rex.utils.ServiceUtils;

public class BusinessService {
	
	// factory mode or spring to improve this question
	private UserDao dao = new UserDaoImpl();
	//support register service to web
	public void register(User user) throws UserExistException{
		
		boolean b = dao.find(user.getUsername());
		if(b){
			throw new UserExistException(); // if user exist,throw a exception to notice web
		}else{
			// password need encrypt to store
			user.setPassword(ServiceUtils.md5(user.getPassword()));
			dao.add(user);
		}
	}
	
	//support login service to web
	public User login(String username,String password){
		
		password = ServiceUtils.md5(password);
		return dao.find(username, password);
	}

}
