package io.pivotal.microservices.services.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import io.pivotal.microservices.categories.Category;
import io.pivotal.microservices.items.Item;

@Controller
public class WebItemsController {

	@Autowired
	protected WebItemsService itemsService;
	
	@Autowired
	protected WebCategoriesService categoriesService;


	public WebItemsController(WebItemsService itemsService) {
		this.itemsService = itemsService;
	}
	
	@RequestMapping(value = "/item")
	public String getItem(Model model) {
		//logger.info("web-service search() invoked: " + criteria);

		List<Item> items = itemsService.findAll();
		model.addAttribute("items_collection", items);
		
		List<Category> categories = categoriesService.findAll();
		model.addAttribute("categories", categories);
		//ritorna il template
		return "shop";
	}
	
	@RequestMapping(value = "/item/category/{category_id}")
	public String getCategory(@PathVariable(value="category_id") String category_id, Model model) {
		//logger.info("web-service search() invoked: " + criteria);

		List<Item> items = itemsService.findItemByCategory(category_id);
		model.addAttribute("items_collection", items);
		
		List<Category> categories = categoriesService.findAll();
		model.addAttribute("categories", categories);
		
		//ritorna il template
		return "shop";
	}
}
