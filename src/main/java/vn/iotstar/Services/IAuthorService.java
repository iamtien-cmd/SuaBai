package vn.iotstar.Services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import java.util.List;

import vn.iotstar.entity.Author;
import vn.iotstar.entity.Author;

public interface IAuthorService{

	long count();
	List<Author > findByName(String keyword) throws Exception;

	Author findById(int id);

	List<Author > findAll();

	Author get(int id);

	void delete(int id) throws Exception;

	void update(Author  newAuthor);

	void insert(Author  Author);

	Page<Author> findByNameContaining(String name, Pageable page);

	Page<Author> findAll(Pageable pageable);
	       
	
	
}
