package vn.iotstar.services;
import java.util.List;
import vn.iotstar.DAO.AuthorDAOimpl;
import vn.iotstar.DAO.IAuthorDAO;
import vn.iotstar.entity.Author;

public class AuthorServicesImpl implements IAuthorServices {
	public IAuthorDAO authorDao = new AuthorDAOimpl();
	@Override
	public void insert(Author author) {
		Author cate = this.findByCategoryname(author.getAuthor_name());
		 if(cate==null) {
		 authorDao.insert(author);
		 }
	}
	 @Override
	 public int count() {
	 return authorDao.count();
	 }
	@Override
	public void update(Author author) {
		 authorDao.update(author); 
	}

	@Override
	public void delete(int id) {
		try {
			 authorDao.delete(id);
			 } catch (Exception e) {
			 e.printStackTrace();
			 }
		
	}
	 @Override
	 public Author findByCategoryname(String name) {
	 try {
	 return authorDao.findByCategoryname(name);
	 } catch (Exception e) {
	 e.printStackTrace();
	 }
	 return null;
	 }
	@Override
	public List<Author> findAll(int page, int pagesize) {
		 return  authorDao.findAll(page, pagesize);
	}
	@Override
	public List<Author> findAll() {
		return authorDao.findAll();
	}
	@Override
	public Author findById(int id) {
		 return authorDao.findById(id);
	}
	

}
