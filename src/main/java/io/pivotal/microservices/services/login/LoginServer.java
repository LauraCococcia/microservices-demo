package io.pivotal.microservices.services.login;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

import io.pivotal.microservices.accounts.AccountsWebApplication;
import io.pivotal.microservices.login.LoginRepository;
import io.pivotal.microservices.login.LoginWebApplication;

/**
 * Run as a micro-service, registering with the Discovery Server (Eureka).
 * <p>
 * Note that the configuration for this application is imported from
 * {@link AccountsWebApplication}. This is a deliberate separation of concerns
 * and allows the application to run:
 * <ul>
 * <li>Standalone - by executing {@link AccountsWebApplication#main(String[])}
 * </li>
 * <li>As a microservice - by executing {@link LoginServer#main(String[])}</li>
 * </ul>
 * 
 * @author Paul Chapman
 */
@EnableAutoConfiguration
@EnableDiscoveryClient
@Import(LoginWebApplication.class)
public class LoginServer {

	@Autowired
	protected LoginRepository loginRepository;

	protected static Logger logger = Logger.getLogger(LoginServer.class.getName());

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
		System.setProperty("spring.config.name", "login-server");

		SpringApplication.run(LoginServer.class, args);
	}
}
