package vn.iotstar.DAO;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import org.hibernate.query.Page;


import vn.iotstar.entity.Author;


public interface IAuthorDAO{

	void delete(int id) throws Exception;
	void update(Author author);
	void insert(Author author);
	Author findByCategoryname(String name) throws Exception;
	Author findById(int cateid);
	List<Author> findAll();
	List<Author> searchByName(String catname);
	List<Author> findAll(int page, int pagesize);
	int count();	
}
