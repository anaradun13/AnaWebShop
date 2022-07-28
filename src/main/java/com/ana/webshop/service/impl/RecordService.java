package com.ana.webshop.service.impl;


import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ana.webshop.entity.Record;
import com.ana.webshop.service.ServiceBase;
import com.ana.webshop.dao.impl.RecordDao;
import com.ana.webshop.entity.Item;
import com.ana.webshop.entity.Page;

@Service
@Transactional
public class RecordService implements ServiceBase<Record> {
	
	@Autowired
	private RecordDao recordDao;

	@Override
	public List<Record> findAll() {

		return null;
	}

	@Override
	public List<Record> findListByKey(String key) {

		return null;
	}

	@Override
	public Record findById(long id) {

		return null;
	}

	@Override
	public Record findByKey(String key) {
		return null;
	}

	public Page<Item> findInfoByKey(int pageNo, long key, String isPaid) throws NumberFormatException, ParseException {
		return recordDao.findInfoByKey(pageNo, key, isPaid);
	}

	@Override
	public void save(Record record) {
		recordDao.save(record);
	}

	@Override
	public void update(Record record) {
		recordDao.update(record);
	}

	@Override
	public void deleteById(long id) {
		recordDao.deleteById(id);
	}

}
