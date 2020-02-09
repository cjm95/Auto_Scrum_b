package com.bespin.auto;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.bespin.auto.domain.User;
import com.bespin.auto.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class IntegrationTest {

	private ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
	private MockMvc mockMvc;
	
	@Mock
	private UserService userService;
	
	@InjectMocks
	private HomeController objectUnderTest;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(objectUnderTest).build();
	}
	
	@Test
	public void getAllMemberTest() throws Exception {
		when(userService.getDBAll()).thenReturn((java.util.List<User>)new ArrayList<User>());
		
		mockMvc.perform(get("/members").accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
		.andDo(print())
		.andExpect(status().is2xxSuccessful());
	}
	
    @Test     
    public void getMemberTest() throws Exception {         
   	 mockMvc.perform(get("/member").param("action", "808").param("selectAttr", "num")
   			.accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
			.andDo(print())
			.andExpect(status().is2xxSuccessful());
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
		
		mockMvc.perform(put("/modification/242")
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
   			 .param("usernum","111")
		    	 .param("username","jd")
				.param("department","team")
				.param("age","20"))
		.andDo(print())
		.andExpect(redirectedUrl("/members"));
		
	}
	
	@Test
	public void deleteMember() throws Exception {
		
		mockMvc.perform(delete("/removal/242"))
		.andDo(print())
		.andExpect(redirectedUrl("http://ec2-13-125-253-208.ap-northeast-2.compute.amazonaws.com:8088/auto/members"));
		
	}
	

} // end class IntegrationTest
