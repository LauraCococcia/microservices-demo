package io.pivotal.microservices.accounts;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ACCOUNT")
public class Account implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String username;
	private String password;
	private String email;
	private String firstName;
	private String lastName;
	private String status;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String zip;
	private String country;
	private String phone;
	private String favouriteCategoryId;
	private String languagePreference;
	private String bannerName;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFavouriteCategoryId() {
		return favouriteCategoryId;
	}
	public void setFavouriteCategoryId(String favouriteCategoryId) {
		this.favouriteCategoryId = favouriteCategoryId;
	}
	public String getLanguagePreference() {
		return languagePreference;
	}
	public void setLanguagePreference(String languagePreference) {
		this.languagePreference = languagePreference;
	}
	public String getBannerName() {
		return bannerName;
	}
	public void setBannerName(String bannerName) {
		this.bannerName = bannerName;
	}
}

/*
 * package io.pivotal.microservices.accounts;
 * 
 * import java.io.Serializable; import java.math.BigDecimal;
 * 
 * import javax.persistence.Column; import javax.persistence.Entity; import
 * javax.persistence.Id; import javax.persistence.Table;
 * 
 *//**
	 * Persistent account entity with JPA markup. Accounts are stored in an H2
	 * relational database.
	 * 
	 * @author Paul Chapman
	 */
/*
 * @Entity
 * 
 * @Table(name = "T_ACCOUNT") public class Account implements Serializable {
 * 
 * private static final long serialVersionUID = 1L;
 * 
 * public static Long nextId = 0L;
 * 
 * @Id protected Long id;
 * 
 * protected String number;
 * 
 * @Column(name = "name") protected String owner;
 * 
 * protected BigDecimal balance;
 * 
 * protected static Long getNextId() { synchronized (nextId) { return nextId++;
 * } }
 * 
 *//**
	 * Default constructor for JPA only.
	 */
/*
 * protected Account() { balance = BigDecimal.ZERO; }
 * 
 * public Account(String number, String owner) { id = getNextId(); this.number =
 * number; this.owner = owner; balance = BigDecimal.ZERO; }
 * 
 * public long getId() { return id; }
 * 
 *//**
	 * Set JPA id - for testing and JPA only. Not intended for normal use.
	 * 
	 * @param id
	 *            The new id.
	 *//*
	 * protected void setId(long id) { this.id = id; }
	 * 
	 * public String getNumber() { return number; }
	 * 
	 * protected void setNumber(String accountNumber) { this.number =
	 * accountNumber; }
	 * 
	 * public String getOwner() { return owner; }
	 * 
	 * protected void setOwner(String owner) { this.owner = owner; }
	 * 
	 * public BigDecimal getBalance() { return balance.setScale(2,
	 * BigDecimal.ROUND_HALF_EVEN); }
	 * 
	 * public void withdraw(BigDecimal amount) { balance.subtract(amount); }
	 * 
	 * public void deposit(BigDecimal amount) { balance.add(amount); }
	 * 
	 * @Override public String toString() { return number + " [" + owner +
	 * "]: $" + balance; }
	 * 
	 * }
	 */