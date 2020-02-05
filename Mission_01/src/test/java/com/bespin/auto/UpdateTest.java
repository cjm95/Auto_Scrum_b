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
public class UpdateTest {
	private static final Logger log =
			LoggerFactory.getLogger(UpdateTest.class);
	

	@Autowired private UserDao userDao;

	@Test
	public void doTest() {

		
//		selectAll();
//		selectOne();
//		create();
		update();
//		delete();
//		createReply();
//		readReplyByBno();
//		updateReply();
//		deleteReply();
//		updateReplyCnt();
	} // end doTest()
	

	private void update() {
		User user = new User();
		user.setNum(808);
//		board.setBno(100);
		user.setAge(28);
		user.setTeam("play");
		user.setName("jj");
		user.setCurnum(808);
		int result = userDao.update(user.getCurnum(),user);
		log.info("update 결과 = {}", result);
	}

} // end class DaoTest
