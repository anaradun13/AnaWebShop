package com.ana.webshop.controller;

import java.text.ParseException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ana.webshop.entity.Item;
import com.ana.webshop.entity.Page;
import com.ana.webshop.entity.Record;
import com.ana.webshop.entity.User;
import com.ana.webshop.service.impl.RecordService;
import com.ana.webshop.service.impl.UserService;

public class RecordController {

	@Autowired
	private RecordService recordService;
	@Autowired
	private UserService userService;

	/**
	 * Add to cart
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "addCart", method = RequestMethod.GET)
	public ModelAndView addCart(HttpServletRequest request) {
		String preUrl = request.getHeader("Referer");
		long userId = Long.parseLong(request.getSession().getAttribute("userId").toString());
		long bookId = Long.parseLong(request.getParameter("bookId"));
		Record cart = new Record(userId, bookId, "0", new Date().getTime());
		recordService.save(cart);
		return new ModelAndView("redirect:" + preUrl.substring(preUrl.lastIndexOf("/"), preUrl.length()));
	}

	/**
	 * Remove from cart
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "remove", method = RequestMethod.GET)
	public ModelAndView remove(HttpServletRequest request) {
		String preUrl = request.getHeader("Referer");
		long id = Long.parseLong(request.getParameter("rid"));
		System.out.println(id);
		recordService.deleteById(id);
		return new ModelAndView("redirect:" + preUrl.substring(preUrl.lastIndexOf("/"), preUrl.length()));
	}

	/**
	 * paid
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "paid", method = RequestMethod.GET)
	public ModelAndView paid(HttpServletRequest request) {
		long userId = Long.parseLong(request.getSession().getAttribute("userId").toString());
		Record record = new Record();
		record.setUserId(userId);
		recordService.update(record);
		return new ModelAndView("redirect:record?type=0&status=0");
	}

	/**
	 * Query records, distinguish shopping cart and historical records according to
	 * parameter type.
	 * 
	 * @param request
	 * @return
	 * @throws ParseException
	 * @throws NumberFormatException
	 */
	@RequestMapping(value = "record", method = RequestMethod.GET)
	public ModelAndView getRecord(HttpServletRequest request) throws NumberFormatException, ParseException {
		ModelAndView mv = new ModelAndView();
		String username = (String) request.getSession().getAttribute("username");
		String type = request.getParameter("type");
		String pageNoStr = request.getParameter("pageNo");
		int pageNo = pageNoStr == null || pageNoStr.equals("") ? 1 : Integer.parseInt(pageNoStr);
		User user = userService.findByKey(username);
		Page<Item> page = recordService.findInfoByKey(pageNo, user.getId(), type); // Query the user's shopping cart
		mv.addObject("page", page);
		if (type.equals("0")) {
			String status = request.getParameter("status");
			if (status != null && status.equals("0")) {
				mv.addObject("message", "Checkout success");
			} // shopping cart
			mv.setViewName("cart");// historical record
		} else if (type.equals("1")) {
			mv.setViewName("history");
		} else {
			mv.setViewName("index");
		}
		return mv;
	}

}