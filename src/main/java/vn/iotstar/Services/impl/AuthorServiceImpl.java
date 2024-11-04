package vn.iotstar.Services.impl;
import java.io.File;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import vn.iotstar.entity.Author ;
import vn.iotstar.Services.IAuthorService;
import vn.iotstar.dao.IAuthorDao;
import vn.iotstar.dao.impl.AuthorDao;

public class AuthorServiceImpl implements IAuthorService {
	IAuthorDao AuthorDao = new AuthorDao();

	@Override
	public void insert(Author  Author) {
		// TODO Auto-generated method stub
		AuthorDao.insert(Author);
	}

	@Override
	public void update(Author  newAuthor) {
		Author  oldAuthor = AuthorDao.findById(newAuthor.getAuthor_id());
		 oldAuthor.setAuthor_name(newAuthor.getAuthor_name());
	
		 AuthorDao.update(oldAuthor);
	}

	@Override
	public void delete(int id) throws Exception {
		Author  cate = new Author ();
		cate = AuthorDao.findById(id);
		if (cate != null) {
			AuthorDao.delete(id);
		}
	}

	@Override
	public Author  get(int id) {
		return AuthorDao.findById(id);
	}

	
	@Override
	public List<Author > findAll() {
		// TODO Auto-generated method stub
		return AuthorDao.findAll();
	}

	@Override
	public Author  findById(int id) {
		// TODO Auto-generated method stub
		return AuthorDao.findById(id);
	}

	@Override
	public List<Author > findByName(String keyword) throws Exception {
		 return AuthorDao.searchByName(keyword);
}

	 @Override
	 public Page<Author> findByNameContaining(String name, Pageable pageable) {
	        return AuthorDao.findByNameContaining(name, pageable);
	    }

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return AuthorDao.count();
	}
	 public Page<Author> findAll(Pageable pageable) {
	        return AuthorDao.findAll(pageable);
	 }

	

}
