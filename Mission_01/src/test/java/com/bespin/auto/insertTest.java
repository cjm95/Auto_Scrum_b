package com.bespin.auto;
import java.sql.Connection;
import javax.activation.DataSource;
import javax.inject.Inject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.bespin.auto.domain.User;
import com.bespin.auto.persistence.UserDao;
import com.bespin.auto.persistence.UserDaoImple;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
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