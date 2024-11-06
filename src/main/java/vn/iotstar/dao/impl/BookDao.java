package vn.iotstar.dao.impl;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import vn.iotstar.configs.JpaConfig;
import vn.iotstar.dao.IBookDao;
import vn.iotstar.entity.Book;

public class BookDao implements IBookDao{
	 public List<Book> findAll() {
		 EntityManager enma = JpaConfig.getEntityManager();
		 TypedQuery<Book> query= enma.createNamedQuery("Book.findAll", Book.class);
		 return query.getResultList();
		 }
}
