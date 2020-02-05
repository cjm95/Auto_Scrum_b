package com.bespin.auto.persistence;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bespin.auto.domain.User;

@Repository
public interface UserDao {
	List<User> getDBAll();
	List<User> getDB(String id, int i);
	void insert(User user);
	
	int update(int num, User user);
	int delete(int bno);
	void delete_m(int num);

}
