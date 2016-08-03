package com.yn.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.yn.controllers.SimpleController;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:*.xml"})
public class BaseControllerTest {
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext wac;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(new SimpleController()).build();
	}
	
	@Test
	public void test() {
		try {
			MvcResult r = mockMvc.perform(MockMvcRequestBuilders.get("/simple/t.htm?param=1133331").param("param1", "23132")).andReturn();
			System.out.println(r.getResponse().getContentAsString() +",dww");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
