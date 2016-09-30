package io.pivotal.microservices.services.categories;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

import io.pivotal.microservices.accounts.AccountsWebApplication;
import io.pivotal.microservices.categories.CategoriesWebApplication;
import io.pivotal.microservices.categories.CategoryRepository;
import io.pivotal.microservices.services.products.ProductsServer;

/**
 * Run as a micro-service, registering with the Discovery Server (Eureka).
 * <p>
 * Note that the configuration for this application is imported from
 * {@link AccountsWebApplication}. This is a deliberate separation of concerns
 * and allows the application to run:
 * <ul>
 * <li>Standalone - by executing {@link AccountsWebApplication#main(String[])}</li>
 * <li>As a microservice - by executing {@link ProductsServer#main(String[])}</li>
 * </ul>
 * 
 * @author Paul Chapman
 */
@EnableAutoConfiguration
@EnableDiscoveryClient
@Import(CategoriesWebApplication.class)
public class CategoriesServer{

	@Autowired
	protected CategoryRepository categoryRepository;

	protected Logger logger = Logger.getLogger(CategoriesServer.class.getName());

	/**
	 * Run the application using Spring Boot and an embedded servlet engine.
	 * 
	 * @param args
	 *            Program arguments - ignored.
	 */
	public static void main(String[] args) {
		// Tell server to look for accounts-server.properties or
		// accounts-server.yml
		System.setProperty("spring.config.name", "categories-server");

		SpringApplication.run(CategoriesServer.class, args);
	}
}
