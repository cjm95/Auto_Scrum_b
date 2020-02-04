package com.bespin.auto;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bespin.auto.User;
import com.bespin.auto.UserDao;

//Spring 프레임워크에게 서비스(비즈니스) 계층의 콤포넌트임을 설정
//root-context.xml 파일에서 <context:component-scan>의 대상이 됨.
@Service
public class UserServiceImple implements UserService {

	private static final Logger log =
			(Logger) LoggerFactory.getLogger(UserServiceImple.class);
	
	// Spring 프레임워크에서 bean으로 관리하고 있는 객체를 주입(inject)받음
	@Autowired private UserDao userDao;
	// UserMapper 인터페이스를 구현한 객체를 주입

	@Override
	public List<User> getDBAll() {
		log.info("read()");

		return userDao.getDBAll();
	}

	@Override
	public List<User> getDB(String id, int i) {
		log.info("read(bno={})", id);
		
		return userDao.getDB(id, i);
	}

	@Override
	public void insert(User user) {
		log.info("insert({})", user);
		// DB의 boards 테이블에 새 글 내용을 insert
		userDao.insert(user);
	}

	@Override
	public int update(int num, User user) {
		log.info("update({})", user);
		
		return userDao.update(num, user);
	}
	
	@Override
	public int delete(int bno) {
//		log.info("delete(bno={})", bno);
		
		return userDao.delete(bno);
	}
	
	@Override
	public void delete_m(int num) {
		userDao.delete(num);
	}

}
