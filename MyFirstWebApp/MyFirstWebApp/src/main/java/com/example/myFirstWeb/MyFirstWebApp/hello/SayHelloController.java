package com.example.myFirstWeb.MyFirstWebApp.hello;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController 
{
	
	@GetMapping("/say-hello")
	@ResponseBody
	public String sayHello() {
		return "Hello! What are you doing";
	}
	
	@GetMapping("/say-hellojsp")
	public String sayHelloJSP() {
		return "hello";
	}
	
}
