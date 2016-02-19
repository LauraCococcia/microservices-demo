package io.pivotal.microservices.services.web;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.pivotal.microservices.accounts.Account;

@Controller
public class WebLoginController {

	@Autowired
	protected WebLoginService loginService;
	
	protected Logger logger = Logger.getLogger(WebLoginService.class
			.getName());
	
	public WebLoginController(WebLoginService loginService) {
		this.loginService = loginService;
	}
	
	@RequestMapping(value="/signin", method=RequestMethod.POST)
	public String doSignin(@Param("user") String user, @Param("pwd") String pwd ){
		
//		Account respAccount = loginService.signin(user, pwd);
		loginService.signin(user, pwd);
		//logger.info("LOGGED USER: "+ respAccount.getUsername());
		return "redirect:/";
	}
}
