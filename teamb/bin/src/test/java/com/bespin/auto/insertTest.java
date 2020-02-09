package com.bespin.auto;

import java.sql.Connection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;
import com.bespin.auto.domain.User;
import com.bespin.auto.persistence.UserDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class insertTest {
	//@Inject
	@Autowired
	private UserDao userdoa;
	
	
	@Test
	public void insertTest() {
		User user =new User();
		user.setName("테스트다");
		user.setNum(819);
		user.setAge(26);
		user.setTeam("CMS Automation!");
		userdoa.insert(user);
	}
}