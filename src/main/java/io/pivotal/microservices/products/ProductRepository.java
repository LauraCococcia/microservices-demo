package io.pivotal.microservices.products;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends Repository<Product, Long>{

	@Query("FROM Product")
	public List<Product> getProducts();

	@Query("FROM Product WHERE category_id= :category_id")
	public List<Product> findByCategory(@Param("category_id") Long category_id);
	
}
