package io.pivotal.microservices.services.accounts;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

import io.pivotal.microservices.accounts.AccountRepository;
import io.pivotal.microservices.accounts.AccountsWebApplication;

/**
 * Run as a micro-service, registering with the Discovery Server (Eureka).
 * <p>
 * Note that the configuration for this application is imported from
 * {@link AccountsWebApplication}. This is a deliberate separation of concerns
 * and allows the application to run:
 * <ul>
 * <li>Standalone - by executing {@link AccountsWebApplication#main(String[])}</li>
 * <li>As a microservice - by executing {@link AccountsServer#main(String[])}</li>
 * </ul>
 * 
 * @author Paul Chapman
 */
@EnableAutoConfiguration
@EnableDiscoveryClient
@Import(AccountsWebApplication.class)
public class AccountsServer{

	@Autowired
	protected AccountRepository accountRepository;

	protected static Logger logger = Logger.getLogger(AccountsServer.class.getName());

	/**
	 * Run the application using Spring Boot and an embedded servlet engine.
	 * 
	 * @param args
	 *            Program arguments - ignored.
	 * @throws SocketException 
	 */
	public static void main(String[] args) throws SocketException {
		// Tell server to look for accounts-server.properties or
		// accounts-server.yml
		System.out.println("##############");
		System.out.println(System.getProperty("server.tomcat.max-threads"));
		System.out.println("##############");
		
		System.setProperty("spring.config.name", "accounts-server");
		
		SpringApplication.run(AccountsServer.class, args);
	}
}
