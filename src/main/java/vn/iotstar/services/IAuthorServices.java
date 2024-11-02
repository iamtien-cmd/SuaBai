package vn.iotstar.services;

import java.util.List;
import java.util.Optional;
import vn.iotstar.entity.Author;
public interface IAuthorServices {
    void insert(Author author);
    void update(Author author);
    void delete(int id);
    Author findByCategoryname(String name);
    int count();
    List<Author> findAll(int page, int pagesize);
    List<Author> findAll();
	Author findById(int id);
 
}  
