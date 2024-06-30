package com.example.myFirstWeb.MyFirstWebApp.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {

	private AuthenticationService autho;

	public LoginController(AuthenticationService autho) {
		super();
		this.autho = autho;
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String Login() {
		return "login";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String gotoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {

		if (autho.authenticate(name, password)) {

			model.put("name", name);
			model.put("password", password);
			return "Welcome";
		}
		model.put("error", "Invalid userName and password please try again!!");
		return "login";
	}

}
