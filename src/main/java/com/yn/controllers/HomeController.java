package com.yn.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/home/*")
public class HomeController {
	
	@RequestMapping(value="t.htm",method= {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public String hello(HttpServletRequest request) throws IOException {
		System.out.println("ddddddddddd");
		return "Test";
	}
}
