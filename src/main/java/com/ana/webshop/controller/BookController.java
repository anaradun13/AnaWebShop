package com.ana.webshop.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ana.webshop.entity.Book;
import com.ana.webshop.service.impl.BookService;

/*
* @author ana.radun
*/
@Controller
public class BookController {

	@Autowired
	private BookService bookService;

	/**
	 * Query books by category (0: science; 1: fantasy; 2: other)
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "books", method = RequestMethod.GET)
	public ModelAndView getBooks(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		int type = Integer.parseInt(request.getParameter("type"));
		// type could be enum
		switch (type) {
		case 0:
			mv.addObject("typeStr", "science");
			break;
		case 1:
			mv.addObject("typeStr", "fantasy");
			break;
		case 2:
			mv.addObject("typeStr", "other");
			break;
		default:
			break;
		}
		List<Book> books = bookService.findListByKey(String.valueOf(type));
		mv.addObject("books", books);
		mv.setViewName("books");
		return mv;
	}

	// TODO - create method to populate database with records
	// This method would take images from disc to write BLOB or image path 
	// either through some class dedicated only to populate those objects or running SQL script right after the startup
	@RequestMapping(value = "preAddBook")
	public ModelAndView preAddBook() {
		return new ModelAndView("addBook");
	}

	@RequestMapping(value = "addBook")
	public ModelAndView addBook(HttpServletRequest request) throws ParseException {
		Book book = new Book();
		book.setType(Integer.parseInt(request.getParameter("type")));
		book.setTitle(request.getParameter("title"));
		book.setPrice(Double.parseDouble(request.getParameter("price")));
		book.setLevel("silverUser"); // enum actually
		book.setTags(request.getParameter("tags"));
		book.setNumberOfPages(Integer.parseInt(request.getParameter("numberOfPages")));
		book.setPublishingDate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date")));
		book.setIntroduction(request.getParameter("introduction"));
		book.setAutors(request.getParameter("autors"));
		book.setImage(request.getParameter("image"));
		bookService.save(book);
		return new ModelAndView("redirect:books?type=" + request.getParameter("type"));
	}

    
    @RequestMapping(value = "/getAllBooks", method = RequestMethod.GET)
    @ResponseBody
    public List<Book> getAllBooks() {
        try {
            return bookService.findAll();
        } catch (Exception e) {
            return null;
        }
    }
    
    // We can return object we are interested into if we want to use ViewModel as above and servlet
    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    @ResponseBody
    public boolean createBook(@RequestParam("type") int type, 
        @RequestParam("title") String title, @RequestParam("price") double price, @RequestParam("level") String level, 
        @RequestParam("tags") String tags, @RequestParam("numberOfPages") Integer numberOfPages, @RequestParam("publishingDate") String publishingDate, 
        @RequestParam("introduction") String introduction, @RequestParam("autors") String autors, @RequestParam("image") String image) throws ParseException {
			Book book = new Book();
			book.setType(type);
			book.setTitle(title);
			book.setPrice(price);
			book.setLevel(level);
			book.setTags(tags);
			book.setNumberOfPages(numberOfPages);
    		book.setPublishingDate(new SimpleDateFormat("yyyy-MM-dd").parse(publishingDate));
    		book.setIntroduction(introduction);
    		book.setAutors(autors);
    		book.setImage(image); // "default_book.jpg"
    		boolean isBookSaved = false;
	        try {
	        	// assign result of save operation or query for the same book to confirm it's there
	        	// resolve concurrency control in database (add locks for CRUD to preserve data integrity)
	            bookService.save(book);
	            isBookSaved = true;
	        } catch(Exception ex) {
	        	// TODO Even better is to log in Errors Log file
	            System.out.println(ex.getMessage());
	        }
	        return isBookSaved;
    }
    
}
