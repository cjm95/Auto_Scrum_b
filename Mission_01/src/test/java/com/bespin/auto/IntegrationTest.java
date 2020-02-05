package com.bespin.auto;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


import javax.inject.Inject;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.bespin.auto.domain.User;

//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" }
		)
@WebAppConfiguration
@RunWith(SpringRunner.class)
public class IntegrationTest {

	
	@Autowired 
	private User user;
	
	private static final ObjectMapper om = new ObjectMapper();
	
	@Inject
	protected WebApplicationContext ctx;
	private MockMvc mockMvc;

	 @org.junit.Before     
	 public void setUp() {
		 mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
		 } 
	 
     @Test     
     public void testInsert() throws Exception {
    	 user = new User(808,"jj","Auto",26);
    	 String userInJson = om.writeValueAsString(user);

    	 mockMvc.perform(post("/registration")
    			 .param("num","808")
		    	 .param("name","jj")
				.param("team","Auto")
				.param("age","26"))
//    	 .andDo(print())
    		      .andExpect(status().isOk());
    	 } 
	 
     @Test     
     public void testSelect() throws Exception {         
    	 mockMvc.perform(get("/member").param("action", "851").param("selectAttr", "num"))
    	 .andExpect(status().isOk())                 
    	 .andExpect(view().name("memberlist"))
    	 .andExpect(model().attributeExists("listAll"));
    	 } 
     
     @Test     
     public void testUpdate() throws Exception {  
    	 String userInJson ="{\"num\":\" 808\", \"name\":\"ju\",\"team\":\"Auto\",\"age\":\"\"}";
    	 
    	 mockMvc.perform(put("/modification/808")
    			 .param("usernum","808")
		    	 .param("username","jd")
				.param("department","Auto")
				.param("age","26"))

    	 .andExpect(redirectedUrl("/searchall"));
    	 } 
     
     @Test     
     public void testZDelete() throws Exception {  
    	 mockMvc.perform(delete("/removal/808"))
    			 .andExpect(redirectedUrl("http://localhost:8080/auto/members"));
    	 } 

} // end class IntegrationTest
