package vn.iotstar.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import vn.iotstar.entity.Author;

public interface IAuthorDao extends JpaRepository<Author, Integer> {
	void delete(int cateid) throws Exception;
	void update(Author Author);
	void insert(Author Author);
	Author findByName(String name) throws Exception;
	Author findById(int cateid);
	List<Author> findAll();
	List<Author> searchByName(String catname);
	List<Author> findAll(int page, int pagesize);
	Page<Author> findAll(Pageable pageable);
    Page<Author> findByNameContaining(String name, Pageable pageable);
    long count();


}
