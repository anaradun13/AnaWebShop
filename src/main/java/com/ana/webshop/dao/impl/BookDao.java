package com.ana.webshop.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ana.webshop.dao.BaseDao;
import com.ana.webshop.entity.Book;

@Repository
public class BookDao implements BaseDao<Book> {
	
	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}

    
    private Session getSession() {
        try {
            return sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            return sessionFactory.openSession();
        }
    }

	@Override
	public List<Book> findAll() {
        return getSession().createQuery("from Book").list();
	}

	@Override
	public Book findById(long id) {

		return null;
	}

	/*
	 * TODO implement methods which return null
	 * Find a book by key.
	 * key: {0: science; 1: fantasy; 2: other}
	 */
	@Override
	public Book findByKey(String key) {
		return null;
	}

	@Override
	public void save(Book t) {
		getCurrentSession().save(t);
	}


	@Override
	public List<Book> findListByKey(String key) {
		List<Book> list = getSession().createQuery("from Book where type= :type order by id desc")
        		.setParameter(0, Integer.parseInt(key))
        		.list();
		
		return list;
	}

	@Override
	public void update(Book t) {

	}

	@Override
	public void deleteById(long id) {

	}
}
