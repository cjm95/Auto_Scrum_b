package com.bespin.auto;

import java.util.List;

import com.bespin.auto.User;

public interface UserDao {
	List<User> getDBAll();
	List<User> getDB(String id, int i);
	void insert(User user);
	
	int update(int num, User user);
	int delete(int bno);
	void delete_m(int num);

}
//곽미정 수정 이렇게하는거맞냐ㅠㅜㅠㅜㅠㅜㅠ