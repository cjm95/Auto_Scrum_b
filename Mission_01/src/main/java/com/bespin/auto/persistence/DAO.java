package com.bespin.auto.persistence;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bespin.auto.domain.User;
import com.ibatis.common.resources.Resources;

public class DAO {
	 public List<User> getDB(String id, int i) throws IOException {
		  SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		  SqlSessionFactory factory = builder.build(Resources.getResourceAsReader("com/bespin/auto/mappers/configuration.xml"));
		  SqlSession ss = factory.openSession(true);
		  List<User> vo = ss.selectList("searchname", id);
		  
		  if(i==0) vo = ss.selectList("searchnum", id);
		  else if(i==1) vo = ss.selectList("searchname", id);
		  else if(i==2) vo = ss.selectList("searchteam", id);
		  
		  return vo;
	}
	 
	 public List<User> getDBAll() throws IOException {
		  SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		  SqlSessionFactory factory = builder.build(Resources.getResourceAsReader("com/bespin/auto/mappers/configuration.xml"));
		  SqlSession ss = factory.openSession(true);

		  List<User> vo = ss.selectList("searchAll");
		  
		  return vo;
	}
	 
	    public User updatelist(String str) throws IOException{
			  SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			  SqlSessionFactory factory = builder.build(Resources.getResourceAsReader("com/bespin/auto/mappers/configuration.xml"));
			  SqlSession ss = factory.openSession(true);
			  
			  List<User> vo = ss.selectList("searchnum", str);
			  User use = new User();

			  use.setNum(vo.get(0).getNum());
			  use.setName(vo.get(0).getName());
			  use.setTeam(vo.get(0).getTeam());
			  use.setAge(vo.get(0).getAge());
			  return use;

	    }
}