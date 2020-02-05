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
public class DeleteTest {
	private static final Logger log =
			LoggerFactory.getLogger(DeleteTest.class);
	

	@Autowired private UserDao userDao;

	@Test
	public void doTest() {


//		selectOne();
//		create();
//		update();
		delete();
//		createReply();
//		readReplyByBno();
//		updateReply();
//		deleteReply();
//		updateReplyCnt();
	} // end doTest()
	
	private void delete() {
		int result = userDao.delete(7);
		log.info("delete 결과 = {}", result);
	}
}
