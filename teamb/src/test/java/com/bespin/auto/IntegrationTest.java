package com.bespin.auto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import com.bespin.auto.domain.User;
import com.bespin.auto.persistence.UserDao;
import com.bespin.auto.service.UserService;


@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class IntegrationTest {

	private MockMvc mockMvc;
	private final Logger logger = LoggerFactory.getLogger(IntegrationTest.class);
	User user;
	
	@Mock
	private UserService userService;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
  	private SqlSession sqlSession;

	@InjectMocks
	private HomeController objectUnderTest;
	
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(objectUnderTest).build();
	    user = new User(808,"jj","Auto",26);
	    sqlSession.insert("bespin.spring.mappers.UserMapper.insert", user);
	}
	
	@Test
	public void getAllMemberTest() throws Exception {
		when(userService.getDBAll()).thenReturn((java.util.List<User>)new ArrayList<User>());
		
		mockMvc.perform(get("/members"))
		.andDo(print())
		.andExpect(status().is2xxSuccessful());
		
        List<User> users = userDao.getDBAll();
        logger.info("users : {}", users);
	}
	
    @Test     
    public void getMemberTest() throws Exception {         
   	 mockMvc.perform(get("/member").param("action", "808").param("selectAttr", "num")
   			.accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
			.andDo(print())
			.andExpect(status().is2xxSuccessful());
   	 
     List<User> users = userDao.getDB("808",0);
     logger.info("users : {}", users);
   	 } 
	
	@Test
	public void postMember() throws Exception {
		
		mockMvc.perform(post("/registration")
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
   			 .param("num","111")
		    	 .param("name","jj")
				.param("team","team")
				.param("age","20"))
		.andDo(print())
		.andExpect(status().is2xxSuccessful());
	}
	
	@Test
	public void updatePutMember() throws Exception {
		
		mockMvc.perform(put("/modification/808")
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
   			 .param("usernum","808")
		    	 .param("username","jd")
				.param("department","team")
				.param("age","20"))
		.andDo(print())
		.andExpect(redirectedUrl("/members"));
		
		user.setName("jd");
		user.setCurnum(808);
	     int users = userDao.update(808,user);
	     logger.info("count : {}", users);
	}
	
	@Test
	public void deleteMember() throws Exception {
		
		mockMvc.perform(delete("/removal/242"))
		.andDo(print())
		.andExpect(redirectedUrl("http://ec2-13-125-253-208.ap-northeast-2.compute.amazonaws.com:8088/auto/members"));
		
		user.setNum(808);
	     int users = userDao.delete(808);
	     logger.info("count : {}", users);
	}
	

} // end class IntegrationTest
