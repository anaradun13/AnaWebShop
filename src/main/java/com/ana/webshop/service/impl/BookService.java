package com.ana.webshop.service.impl;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ana.webshop.dao.impl.BookDao;
import com.ana.webshop.entity.Book;
import com.ana.webshop.service.ServiceBase;

@Service
@Transactional
public class BookService implements ServiceBase<Book> {
	@Autowired
	private BookDao bookDao;

	@Override
	public List<Book> findAll() {

    	return bookDao.findAll();
    	
	}

	@Override
	public List<Book> findListByKey(String key) {
		return bookDao.findListByKey(key);
	}

	@Override
	public Book findById(long id) {

		return null;
	}

	@Override
	public Book findByKey(String key) {

		return null;
	}

	@Override
	public void save(Book t) {
		bookDao.save(t);
	}

	@Override
	public void update(Book t) {
		
	}

	@Override
	public void deleteById(long id) {
		
	}

}
