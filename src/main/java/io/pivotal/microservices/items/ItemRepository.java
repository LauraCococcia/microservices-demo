package io.pivotal.microservices.items;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import io.pivotal.microservices.products.Product;

public interface ItemRepository extends Repository<Item, Long>{

	@Query("FROM Item")
	public List<Item> getItems();

	//Select o from Operation o join o.process p join p.events e where e.datetime = o.datetime
	@Query("SELECT itm FROM Item itm LEFT JOIN itm.product prod LEFT JOIN prod.category cat WHERE cat.categoryId = :category_id")
	public List<Item> getByCategory(@Param("category_id") Long category_id);
//	public List<Item> getByCategory(@Param("category_id") Long category_id);

	public List<Item> findFirst9ByOrderByItemIdAsc();

	@Query("From Product")
	public List<Product> getProducts();

	public Item save(Item item);
	
}
