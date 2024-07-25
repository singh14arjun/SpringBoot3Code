package com.springBoot.TodosApplication.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	@RequestMapping(value = "hello" ,method = RequestMethod.GET)
	@ResponseBody
	public String sayHello() {
		return "Hello !how are you ?";
	}
	
	
	@RequestMapping(value = "hellojsp" ,method = RequestMethod.GET)
	public String sayHelloJSP() {
		return "sayHello";
	}
	
	
}
