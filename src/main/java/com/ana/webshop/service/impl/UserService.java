package com.ana.webshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ana.webshop.dao.impl.UserDao;
import com.ana.webshop.entity.User;
import com.ana.webshop.service.ServiceBase;

public class UserService  implements ServiceBase<User> {
	@Autowired
	private UserDao userDao;

	@Override
	public List<User> findAll() {

		return null;
	}

	@Override
	public User findById(long id) {

		return null;
	}

	@Override
	public User findByKey(String key) {
		return userDao.findByKey(key);
	}

	@Override
	public void save(User user) {
		userDao.save(user);

	}

	@Override
	public List<User> findListByKey(String key) {

		return null;
	}

	@Override
	public void update(User t) {
		
	}

	@Override
	public void deleteById(long id) {
		
	}

}
