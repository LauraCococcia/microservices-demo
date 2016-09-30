package io.pivotal.microservices.services.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import io.pivotal.microservices.categories.Category;
import io.pivotal.microservices.items.Item;

/**
 * Home page controller.
 * 
 * @author 
 */
@Controller
public class HomeController {

	@Autowired
	protected WebCategoriesService categoriesService;
	
	@Autowired
	protected WebItemsService itemsService;
	
	@RequestMapping("/")
	public String home(Model model) {
		List<Category> categories = categoriesService.findAll();
		model.addAttribute("categories", categories);
		
		List<Item> items = itemsService.findFirst9ByOrderByItemIdAsc();
		model.addAttribute("items", items);
		
		return "index";
	}

}
