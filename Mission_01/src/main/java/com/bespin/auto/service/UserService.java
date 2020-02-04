package com.bespin.auto.service;

import java.util.List;

import com.bespin.auto.domain.User;

public interface UserService {
	List<User> getDBAll();
	List<User> getDB(String id, int i);
	void insert(User user); //등록기능 
	int update(int num,User user);
	int delete(int bno);
	public void delete_m(int num);

}
//곽미정 서비스 수정