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
public class DeleteTest {
	//@Inject
	@Autowired
	private UserDao userdao;
	
	
	@Test
	public void deleteTest() {
		int result = userdao.delete(7);
		System.out.println("delete 결과 = "+result);
	}
}
