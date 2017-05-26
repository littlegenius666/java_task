package model.dao;

import java.util.List;
import java.util.Optional;

public interface GenericDao <E>{
	   Optional<E> find(String id);
	   List<E> findAll();
	   void create(E e);
	   void update(E e);
	   void delete(String id);
}
