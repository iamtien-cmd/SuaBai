package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.entity.Book;

public interface IBookDao {
	 public List<Book> findAll();
}
