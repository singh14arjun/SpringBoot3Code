package com.example.SpringBoot1;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyController 
{
	@Autowired(required = true)
	private CurrencyServiceConfiguration cofig;
	
	@GetMapping("/currency-config")
	public CurrencyServiceConfiguration getAllCourses()
	{
		return cofig;
	}

}
