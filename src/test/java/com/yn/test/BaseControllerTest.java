package com.yn.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.yn.controllers.SimpleController;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value="src/main/resources")
@ContextConfiguration(locations = {"classpath:*.xml"})
public class BaseControllerTest {
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(new SimpleController()).build();
	}
	
	@Test
	public void test() {
		try {
			MvcResult r = mockMvc.perform(MockMvcRequestBuilders.get("/simple/t.htm")).andReturn();
			System.out.println(r.getResponse().getContentAsString() +",dww");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
