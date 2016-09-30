package io.pivotal.microservices.categories;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("io.pivotal.microservices")
@EnableJpaRepositories("io.pivotal.microservices.categories")
@PropertySource("classpath:db-config.properties")
public class CategoriesWebApplication {

	public static void main(String[] args){
		SpringApplication.run(CategoriesWebApplication.class, args);
	}
}
