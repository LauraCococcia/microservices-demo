package io.pivotal.microservices.login;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

/**
 * Allow the controller to return a 404 if an account is not found by simply
 * throwing this exception. The @ResponseStatus causes Spring MVC to return a
 * 404 instead of the usual 500.
 * 
 * @author Paul Chapman
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class LoginAccountNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public LoginAccountNotFoundException(String accountNumber) {
		super("No such account: " + accountNumber);
	}
}
