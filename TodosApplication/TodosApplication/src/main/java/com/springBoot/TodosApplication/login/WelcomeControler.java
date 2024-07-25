package com.springBoot.TodosApplication.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeControler {
	/*
	 * private LoginAuthenticationService authenticateService = new
	 * LoginAuthenticationService();
	 * 
	 * public LoginControler(LoginAuthenticationService authenticateService) {
	 * super(); this.authenticateService = authenticateService; }
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String goToWelcomePage(ModelMap model)
	{
		model.put("name", "arjun");
		return "Welcome";
	}
	
	private String getLoggedInUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
		
	}

	/*
	 * @RequestMapping(value = "login", method = RequestMethod.POST) public String
	 * WelcomePage(@RequestParam String name, @RequestParam String password,
	 * ModelMap model) {
	 * 
	 * if (authenticateService.authenticate(name, password)) { model.put("name",
	 * name); model.put("password", password); return "Welcome"; }
	 * model.put("errorMessage", "Invalid Credentails!! please Try Again!"); return
	 * "Login"; }
	 */

}
