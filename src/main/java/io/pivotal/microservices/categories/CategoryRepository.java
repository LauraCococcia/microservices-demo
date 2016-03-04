package io.pivotal.microservices.categories;

import java.util.List;

import org.springframework.data.repository.Repository;


public interface CategoryRepository extends Repository<Category, Long>{

	/**
	 * Metodi di query
	 */
	public List<Category> findAll();
	
	public Category save(Category cat);
}
