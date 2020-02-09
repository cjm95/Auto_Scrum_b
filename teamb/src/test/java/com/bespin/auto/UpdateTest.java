package com.bespin.auto;

import java.sql.Connection;
import java.util.List;

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
public class UpdateTest {
	//@Inject
	@Autowired
	private UserDao userdao;
	
	
	@Test
	public void updateTest() {
		User user = new User();
		user.setNum(808);
		user.setAge(28);
		user.setTeam("play");
		user.setName("jj");
		user.setCurnum(808);
		int result = userdao.update(user.getCurnum(),user);
		System.out.println("update 결과 = "+result);
	}
}

