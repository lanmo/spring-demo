package com.yn.controllers;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yn.annotation.DefaultVal;
import com.yn.annotation.Param;

@Controller
@RequestMapping("/simple/*")
public class SimpleController {
	
	@RequestMapping(value="t.htm",method= {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public String hello(@Param(value="param1") String param,  @Param("a") @DefaultVal(value="default") String a) throws IOException {
		return String.format("Hello %s,%s", param,a);
	}
}
