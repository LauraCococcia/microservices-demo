package io.pivotal.microservices.items;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemsController {
	
	protected Logger logger = Logger.getLogger(ItemsController.class.getName());

	protected ItemRepository itemRepository;

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
}
