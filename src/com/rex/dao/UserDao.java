package com.rex.dao;

import com.rex.domain.User;

public interface UserDao {

	void add(User user);

	User find(String username, String password);

	boolean find(String username);

}