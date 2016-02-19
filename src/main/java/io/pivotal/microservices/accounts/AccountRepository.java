package io.pivotal.microservices.accounts;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

/**
 * Repository for Account data implemented using Spring Data JPA.
 * 
 * @author Paul Chapman
 */
public interface AccountRepository extends Repository<Account, Long> {
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
	
	@Query("FROM Account WHERE name = :user and number = :pwd")
	public Account login(@Param("user") String user, @Param("pwd") String pwd);
	
	public Account save(Account account);
}
