package io.pivotal.microservices.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("io.pivotal.microservices.products")
@EnableJpaRepositories("io.pivotal.microservices.products")
@PropertySource("classpath:db-config.properties")
public class ProductsWebApplication {

	public static void main(String[] args){
		SpringApplication.run(ProductsWebApplication.class, args);
	}
}
