package io.pivotal.microservices.accounts;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.pivotal.microservices.login.Login;
import io.pivotal.microservices.login.LoginRepository;

/**
 * A RESTFul controller for accessing account information.
 * 
 * @author Paul Chapman
 */
@RestController
public class AccountsController {

	protected Logger logger = Logger.getLogger(AccountsController.class
			.getName());
	protected AccountRepository accountRepository;
	protected LoginRepository loginRepository;

	/**
	 * Create an instance plugging in the respository of Accounts.
	 * 
	 * @param accountRepository
	 *            An account repository implementation.
	 */
	@Autowired
	public AccountsController(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;

//		logger.info("AccountRepository says system has "
//				+ accountRepository.countAccounts() + " accounts");
	}
	
//	@RequestMapping("/login/{user}/{pwd}")
//	public Account login(@PathVariable("user") String user, @PathVariable("pwd") String pwd ){
//		Account account = accountRepository.login(user, pwd);
//		return account;
//	}
	
	@RequestMapping(value="/signup", method = RequestMethod.POST)
	public Account signup(@RequestBody Account account){
		logger.info("user-> "+ account.getUsername());
		logger.info("email-> "+ account.getEmail());
		
		Account accountResult = accountRepository.save(account);
		return accountResult;

//		Login loginAccount = new Login();
//		loginAccount.setUser(accountResult);
//		loginAccount.setPassword(pwd);
//		loginRepository.save(loginAccount);
	}
}
