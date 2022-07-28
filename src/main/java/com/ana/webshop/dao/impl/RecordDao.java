package com.ana.webshop.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ana.webshop.entity.Record;
import com.ana.webshop.dao.BaseDao;
import com.ana.webshop.entity.Item;
import com.ana.webshop.entity.Page;

public class RecordDao implements BaseDao<Record> {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}

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

	/**
	 * Query cart and history
	 * 
	 * @param key
	 *            user id
	 * @param isPaid
	 *            Whether it has been paid (0: unpaid, query shopping cart; 1: paid, query history)
	 * @return
	 * @throws NumberFormatException
	 * @throws ParseException
	 */
	public Page<Item> findInfoByKey(int pageNo, long key, String isPaid) throws NumberFormatException, ParseException {
		String hql = "select r.userId, r.bookId, b.title, b.price, b.numberOfPages, b.publishingDate, b.image, r.time, r.id "
				+ "from Book as b, Record as r "
				+ "where r.bookId = b.id and r.isPaid = :isPaid and r.userId = ?1 order by r.time desc";
		Query querySize = getCurrentSession().createQuery(hql).setParameter(0, isPaid).setParameter(1, key);
		Query query = getCurrentSession().createQuery(hql).setParameter(0, isPaid).setParameter(1, key)
				.setFirstResult((pageNo - 1) * Page.pageSize).setMaxResults(Page.pageSize);
		List queryResult = query.list();
		List sizeList = querySize.list();
		int total = 0;
		if (sizeList != null) {
			total = sizeList.size();
		}
		List<Item> list = new ArrayList<>();
		if (queryResult != null) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			for (int i = 0; i < queryResult.size(); i++) {
				Object[] object = (Object[]) queryResult.get(i);
				long uid = Long.parseLong(object[0].toString());
				long bid = Long.parseLong(object[1].toString());
				String title = object[2].toString();
				String date = object[5].toString();
				String numOfPages = object[4].toString();
				double price = Double.parseDouble(object[3].toString());
				String image = object[6].toString();
				String time = new SimpleDateFormat("yyyy-MM-dd hh:mm")
						.format(new Date(Long.parseLong(object[7].toString())));
				long rid = Long.parseLong(object[8].toString());
				Item info = new Item(uid, bid, title, date, numOfPages, price, image, time, rid);
				list.add(info);
			}
		}
		Page<Item> page = new Page<>(total, pageNo, list);
		if (total % Page.pageSize != 0) {
			page.setTotalPages((total / Page.pageSize) + 1);
		} else {
			page.setTotalPages(total / Page.pageSize);
		}
		return page;
	}

	/** 
	 * Save record for adding to cart.
	 */
	@Override
	public void save(Record record) {
		getCurrentSession().save(record);
	}

	/** 
	 * Update record, which is used to set the payment flag to 1, indicating payment.
	 */
	@Override
	public void update(Record record) {
		String hql = "update Record r set r.isPaid = '1',r.time= :time where uid = :uid";
		Query query = getCurrentSession().createQuery(hql).setParameter(0, new Date().getTime()).setParameter(1,
				record.getUserId());
		query.executeUpdate();
	}

	/**  
	 * Delete action history to remove books from shopping cart.
	 */
	@Override
	public void deleteById(long id) {
		Record record = new Record();
		record.setId(id);
		getCurrentSession().delete(record);
	}

}
