package vn.iotstar.Services;

import java.util.List;

import vn.iotstar.entity.User;

public interface IUserService {
	User login(String username, String password) ;

	User findByEmail(String name);

	List<User> findAll(int page, int pagesize);

	int count();

	void delete(int id);

	void update(User user);

	List<User> searchByName(String keyword);

	User findById(int id);

	List<User> findAll();

	

}
