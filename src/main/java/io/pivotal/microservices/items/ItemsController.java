package io.pivotal.microservices.items;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.pivotal.microservices.products.Product;

@RestController
public class ItemsController {
	
	protected Logger logger = Logger.getLogger(ItemsController.class.getName());

	protected ItemRepository itemRepository;
	
	protected Random randomGenerator = new Random();

	@Autowired
	public ItemsController(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	@RequestMapping("/item")
	public List<Item> getItems() {
		List<Item> items = itemRepository.getItems();
		if (items == null) {
			throw new ItemNonFoundException();
		} else {
			logger.info("items found");
		    return items;
		}
	}
	
	@RequestMapping("/item/category/{category_id}")
	public List<Item> getItems(@PathVariable(value="category_id") String category_id) {
		
		List<Item> items = itemRepository.getByCategory((long)Integer.parseInt(category_id));
//		List<Item> items = itemRepository.getByCategory(category_id);
		if (items == null) {
			throw new ItemNonFoundException();
		} else {
			logger.info("items found");
		    return items;
		}
	}
	
	@RequestMapping(value="/item/home", method=RequestMethod.GET)
	public List<Item> findFirst9ByOrderByItemIdAsc() {
		List<Item> items = itemRepository.findFirst9ByOrderByItemIdAsc();
		if (items == null) {
			throw new ItemNonFoundException();
		} else {
			logger.info(Integer.toString(items.size()));
		    return items;
		}
	}
	
	@RequestMapping("/item/init")
	public void initDB(){
		
		List<Product> products = itemRepository.getProducts();
		logger.info(String.valueOf(products.size()));
		for(int i=0; i< 1000; i++){
			Item item = new Item();
			item.setProduct(products.get(randomGenerator.nextInt(products.size())));
			item.setUnitCost(new BigDecimal(Math.random()*100));
			item.setListPrice(new BigDecimal(Math.random()*100));
			itemRepository.save(item);
		}
		
	}
}
