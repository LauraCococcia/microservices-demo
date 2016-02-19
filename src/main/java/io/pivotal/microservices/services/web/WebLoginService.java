package io.pivotal.microservices.services.web;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import io.pivotal.microservices.accounts.Account;
import io.pivotal.microservices.login.Login;

public class WebLoginService {

	@Autowired
	protected RestTemplate restTemplate;

	protected String serviceUrl;

	protected Logger logger = Logger.getLogger(WebLoginService.class
			.getName());

	public WebLoginService(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
				: "http://" + serviceUrl;
	}

	/**
	 * The RestTemplate works because it uses a custom request-factory that uses
	 * Ribbon to look-up the service to use. This method simply exists to show
	 * this.
	 */
//	@PostConstruct
//	public void demoOnly() {
//		// Can't do this in the constructor because the RestTemplate injection
//		// happens afterwards.
//		logger.warning("The RestTemplate request factory is "
//				+ restTemplate.getRequestFactory());
//	}
	
	@SuppressWarnings("unused")
	public void signin(String user, String pwd){
		logger.info(user + " -> "+ pwd);
		Account account = restTemplate.getForObject(serviceUrl + "/signin/"+user+"/"+pwd, Account.class);
		//return account;
	}

	public Login save(Login login) {
		Login respLogin = null;
		
		respLogin = restTemplate.postForObject(serviceUrl + "/save", login, Login.class);
		
		return respLogin;
	}
}
