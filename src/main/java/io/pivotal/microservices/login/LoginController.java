package io.pivotal.microservices.login;

import java.util.logging.Logger;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.pivotal.microservices.accounts.Account;

/**
 * 
 * @author Daniele Di Pompeo 
 * @email daniele.dipompeo@graduate.univaq.it
 * @github https://github.com/spe-peo/microservices-demo
 * 
 */

@RestController
public class LoginController {

	protected Logger logger = Logger.getLogger(LoginController.class
			.getName());
	protected LoginRepository loginRepository;

	/**
	 * Create an instance plugging in the respository of Accounts.
	 * 
	 * @param accountRepository
	 *            An account repository implementation.
	 */
	@Autowired
	public LoginController(LoginRepository loginRepository) {
		this.loginRepository = loginRepository;

//		logger.info("AccountRepository says system has "
//				+ accountRepository.countAccounts() + " accounts");
	}
	
	@RequestMapping(value="/signin/{user}/{pwd}", method=RequestMethod.GET)
	public Account login(@PathVariable("user") String user, @PathVariable("pwd") String pwd ) throws AccountNotFoundException{
		Account account = loginRepository.signin(user, pwd);
		if(account == null){
			throw new AccountNotFoundException(user); 
		}
		else{
			return account;
		}
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public Login save(@RequestBody Login login){
		return loginRepository.save(login);
	}
}
