package vn.iotstar.Services.impl;

import java.util.List;

import vn.iotstar.Services.IBookService;
import vn.iotstar.dao.IBookDao;
import vn.iotstar.dao.impl.BookDao;
import vn.iotstar.entity.Book;


public class BookService implements IBookService{
	private IBookDao bookdao= new BookDao();
	@Override
	public List<Book> findAll() {
		return bookdao.findAll();
	}

}
