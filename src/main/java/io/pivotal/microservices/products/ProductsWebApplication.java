package io.pivotal.microservices.products;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

@SpringBootApplication
@EntityScan("io.pivotal.microservices.products")
@EnableJpaRepositories("io.pivotal.microservices.products")
@PropertySource("classpath:db-config.properties")
public class ProductsWebApplication {

	public static void main(String[] args){
		SpringApplication.run(ProductsWebApplication.class, args);
	}
	
	/**
	 * Creates an in-memory "rewards" database populated with test data for fast
	 * testing
	 *
	@Bean
	public DataSource dataSource() {

		// Create an in-memory H2 relational database containing some demo
		// accounts.
		DataSource dataSource = (new EmbeddedDatabaseBuilder())
				.addScript("classpath:testdb/schema_products.sql")
				.addScript("classpath:testdb/data_products.sql").build();


//		// Sanity check
//		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//		
//		List<Map<String, Object>> accounts = jdbcTemplate
//				.queryForList("SELECT number FROM T_ACCOUNT");
//
//		// Populate with random balances
//		Random rand = new Random();
//
//		for (Map<String, Object> item : accounts) {
//			String number = (String) item.get("number");
//			BigDecimal balance = new BigDecimal(rand.nextInt(10000000) / 100.0)
//					.setScale(2, BigDecimal.ROUND_HALF_UP);
//			jdbcTemplate.update(
//					"UPDATE T_ACCOUNT SET balance = ? WHERE number = ?",
//					balance, number);
//		}

		return dataSource;
	}*/
	
}
