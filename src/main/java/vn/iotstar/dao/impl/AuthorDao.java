package vn.iotstar.dao.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import vn.iotstar.configs.JpaConfig;
import vn.iotstar.dao.IAuthorDao;
import vn.iotstar.entity.Author;


public class AuthorDao implements IAuthorDao{
	@Override
	public void insert(Author Author) {
		EntityManager enma = JpaConfig.getEntityManager();
		 EntityTransaction trans = enma.getTransaction();
		 try {
		 trans.begin();
		 enma.persist(Author);
		 trans.commit();
		 } catch (Exception e) {
		 e.printStackTrace();
		 trans.rollback();
		 throw e;
		 }finally {
		 enma.close();
		 }
	}
	@Override
	public void update(Author Author) {
		EntityManager enma = JpaConfig.getEntityManager();
		 EntityTransaction trans = enma.getTransaction();
		 try {
		 trans.begin();
		 enma.merge(Author); // update vào bảng
		 trans.commit();
		 } catch (Exception e) {
		 e.printStackTrace();
		 trans.rollback();
		 throw e;
		 }finally {
		 enma.close();
		 }
	}
	@Override
	 public void delete(int cateid) throws Exception {
		EntityManager enma = JpaConfig.getEntityManager();
		 EntityTransaction trans = enma.getTransaction();
		 try {
		 trans.begin();
		 Author Author = enma.find(Author.class,cateid);
		 if(Author != null) {
		 enma.remove(Author);
		 }else {
		 throw new Exception("Không tìm thấy");
		 }
		 trans.commit();
		 } catch (Exception e) {
		 e.printStackTrace();
		 trans.rollback();
		 throw e;
		 }finally {
		 enma.close();
		 }
	}
	
	@Override
	 public Author findById(int cateid) {
	 EntityManager enma = JpaConfig.getEntityManager();
	 Author Author = enma.find(Author.class,cateid);
	 return Author;
	 }
	@Override
	 public Author findByName(String name) throws Exception {
	 EntityManager enma = JpaConfig.getEntityManager();
	 String jpql = "SELECT c FROM Author c WHERE c.author_name =:name";
	 try {
	 TypedQuery<Author> query= enma.createQuery(jpql, Author.class);
	 query.setParameter("name", name);
	 Author Author= query.getSingleResult();
	 if(Author==null) {
	 throw new Exception("Author Name đã tồn tại");
	 }
	 return Author;
	 } finally {
	 enma.close();
	 } 
	 }
	@Override
	 public List<Author> findAll() {
	 EntityManager enma = JpaConfig.getEntityManager();
	 TypedQuery<Author> query= enma.createNamedQuery("Author.findAll", Author.class);
	 return query.getResultList();
	 }
	@Override
	 public List<Author> searchByName(String name) {
	 EntityManager enma = JpaConfig.getEntityManager();
	 String jpql = "SELECT c FROM Author c WHERE c.author_name like :name";
	 TypedQuery<Author> query= enma.createQuery(jpql, Author.class);
	 query.setParameter("name", "%" + name + "%");
	 return query.getResultList();
	 }
	@Override
	 public List<Author> findAll(int page, int pagesize) {
	 EntityManager enma = JpaConfig.getEntityManager();
	 TypedQuery<Author> query= enma.createNamedQuery("Author.findAll", Author.class);
	 query.setFirstResult(page*pagesize);
	 query.setMaxResults(pagesize);
	 return query.getResultList();
	 }
	@Override
	 public long count() {
	 EntityManager enma = JpaConfig.getEntityManager();
	 String jpql = "SELECT count(c) FROM Author c";
	 Query query = enma.createQuery(jpql);
	 return ((Long) query.getSingleResult()).intValue();
	 }
	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public <S extends Author> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <S extends Author> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void deleteAllInBatch(Iterable<Author> entities) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Author getOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Author getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Author getReferenceById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <S extends Author> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <S extends Author> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <S extends Author> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Author> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <S extends Author> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Optional<Author> findById(Integer id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}
	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(Author entity) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteAll(Iterable<? extends Author> entities) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Author> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Page<Author> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <S extends Author> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}
	@Override
	public <S extends Author> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <S extends Author> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public <S extends Author> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public <S extends Author, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Page<Author> findByNameContaining(String name, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
	

	
}
