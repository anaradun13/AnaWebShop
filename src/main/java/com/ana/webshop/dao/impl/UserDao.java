package com.ana.webshop.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ana.webshop.dao.BaseDao;
import com.ana.webshop.entity.User;

public class UserDao implements BaseDao<User> {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<User> findAll() {

		return null;
	}

	@Override
	public User findById(long id) {

		return null;
	}

	/**
	 * Save user for registration.
	 */
	@Override
	public void save(User user) {
		getCurrentSession().save(user);
	}

	/**
	 * Query users based on their login names for login and user information query.
	 */
	@Override
	public User findByKey(String key) {
		String hql = "from User where username= :username";
		Query query = getCurrentSession().createQuery(hql).setParameter(0, key);
		User user = (User) query.uniqueResult();
		return user;
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
