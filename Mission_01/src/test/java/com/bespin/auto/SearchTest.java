package com.bespin.auto;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bespin.auto.domain.User;
import com.bespin.auto.persistence.UserDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" }
		)

public class SearchTest {
	private static final Logger log =
			LoggerFactory.getLogger(DaoTest.class);
	

	@Autowired private UserDao userDao;

	@Test
	public void doTest() {

		
		selectAll();
		selectOne();
//		create();
//		update();
//		delete();
//		createReply();
//		readReplyByBno();
//		updateReply();
//		deleteReply();
//		updateReplyCnt();
	} // end doTest()
	
	private void selectAll() {
		List result = userDao.getDBAll();
		
		log.info("update 결과 = {}", result);
	}
	
	private void selectOne() {
		User user = new User();
		user.setNum(808);
		user.setAge(28);
		user.setTeam("play");
		user.setName("테스트다");
		user.setCurnum(808);
		
		List result = userDao.getDB(user.getName(), 1);
		
		log.info("update 결과 = {}", result);
	}

} // end class DaoTest
