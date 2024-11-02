package vn.iotstar.DAO;
import java.util.List;
import java.util.Optional;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import vn.iotstar.configs.JpaConfig;
import vn.iotstar.entity.Author;

public class AuthorDAOimpl implements IAuthorDAO {
	@Override
	public void insert(Author author) {
		EntityManager enma = JpaConfig.getEntityManager();
		 EntityTransaction trans = enma.getTransaction();
		 try {
		 trans.begin();
		 enma.persist(author);
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
	public void update(Author author) {
		EntityManager enma = JpaConfig.getEntityManager();
		 EntityTransaction trans = enma.getTransaction();
		 try {
		 trans.begin();
		 enma.merge(author); // update vào bảng
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
	 public void delete(int id) throws Exception {
		EntityManager enma = JpaConfig.getEntityManager();
		 EntityTransaction trans = enma.getTransaction();
		 try {
		 trans.begin();
		 Author author = enma.find(Author.class,id);
		 if(author != null) {
		 enma.remove(author);
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
	public Author findByCategoryname(String name) throws Exception {
		 EntityManager enma = JpaConfig.getEntityManager();
		 String jpql = "SELECT c FROM author c WHERE c.author_name =:author_name";
		 try {
		 TypedQuery<Author> query= enma.createQuery(jpql, Author.class);
		 query.setParameter("author_name", name);
		 Author author= query.getSingleResult();
		 if(author==null) {
		 throw new Exception("Tên tác giả đã tồn tại");
		 }
		 return author;
		 } finally {
		 enma.close();
		 } 
	}
	@Override
	public int count() {
		 EntityManager enma = JpaConfig.getEntityManager();
		 String jpql = "SELECT count(c) FROM Author c";
		 Query query = enma.createQuery(jpql);
		 return ((Long)query.getSingleResult()).intValue();
	}
	@Override
	public Author findById(int id) {
		 EntityManager enma = JpaConfig.getEntityManager();
		 Author author = enma.find(Author.class,id);
		 return author;
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
		 String jpql = "SELECT c FROM Author c WHERE c.catename like :author_name";
		 TypedQuery<Author> query= enma.createQuery(jpql, Author.class);
		 query.setParameter("author_name", "%" + name + "%");
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
}
