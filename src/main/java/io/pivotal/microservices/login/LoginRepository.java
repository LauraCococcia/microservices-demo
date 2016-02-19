package io.pivotal.microservices.login;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import io.pivotal.microservices.accounts.Account;

/**
 * Repository for Account data implemented using Spring Data JPA.
 * 
 * @author Paul Chapman
 */
public interface LoginRepository extends Repository<Login, Long> {
	/**
	 * Find an account with the specified account number.
	 *
	 * @param accountNumber
	 * @return The account if found, null otherwise.
	 */
	//public Account findByNumber(String accountNumber);

	/**
	 * Find accounts whose owner name contains the specified string
	 * 
	 * @param partialName
	 *            Any alphabetic string.
	 * @return The list of matching accounts - always non-null, but may be
	 *         empty.
	 */
	//public List<Account> findByOwnerContainingIgnoreCase(String partialName);

	/**
	 * Fetch the number of accounts known to the system.
	 * 
	 * @return The number of accounts.
	 */
//	@Query("SELECT count(*) from Account")
//	public int countAccounts();
	
	//public Account findByOwner(String accountName);
	
	@Query("SELECT acnt FROM Login login LEFT JOIN login.user acnt WHERE login.user.username = :user and login.password = :pwd")
	public Account signin(@Param("user") String user, @Param("pwd") String pwd);

	public Login save(Login loginAccount);
}
