package com.bespin.auto.persistence;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bespin.auto.domain.User;
import com.ibatis.common.resources.Resources;

//Spring 프레임워크에게 영속 계층 콤포넌트(DAO)임을 알려주는 어노테이션
@Repository
public class UserDaoImple implements UserDao {
	// Board 테이블에 대한 SQL 문장들을 찾기 위한 이름 공간(namespace) - mapper.xml
	private static final String NAMESPACE = 
			"bespin.spring.mappers.UserMapper";
	private static final Logger log =
			LoggerFactory.getLogger(UserDaoImple.class);

	@Autowired SqlSession sqlSession;
	@Override
	public List<User> getDBAll() {
		log.info("read() 호출");
		
		List<User> vo = sqlSession.selectList(NAMESPACE + ".searchAll");
		
		return vo;
	}

	@Override
	public List<User> getDB(String id, int i) {
		log.info("read(bno={})", id);
		
		List<User> vo = sqlSession.selectList(NAMESPACE + ".searchname", id);
		if(i==0) vo = sqlSession.selectList(NAMESPACE + ".searchnum", id);
		else if(i==1) vo = sqlSession.selectList(NAMESPACE + ".searchname", id);
		else if(i==2) vo = sqlSession.selectList(NAMESPACE + ".searchteam", id);
		
		return vo;
	}

	@Override
	public void insert(User user) {
		log.info("create({})", user);
		
		sqlSession.insert(NAMESPACE + ".insert", user);
	}

	@Override
	public int update(int num,User user) {
		log.info("update({})", user);
		
		return sqlSession.update(NAMESPACE + ".update", user);
	}
	
	@Override
	public int delete(int bno) {
		log.info("delete(bno={})", bno);
		
		return sqlSession.delete(NAMESPACE + ".delete", bno);
	}
	
	@Override
	public void delete_m(int num){
		log.info("delete_m(bno={})", num);
		sqlSession.delete(NAMESPACE + ".delete_m", num);
	}


}
