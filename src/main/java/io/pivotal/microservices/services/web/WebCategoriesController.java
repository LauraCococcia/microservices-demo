package io.pivotal.microservices.services.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import io.pivotal.microservices.categories.Category;
import io.pivotal.microservices.products.Product;

@Controller
public class WebCategoriesController {

	@Autowired
	protected WebCategoriesService categoriesService;
	
	@Autowired
	protected WebProductsService productsService;


	public WebCategoriesController(WebCategoriesService categoriesService) {
		this.categoriesService = categoriesService;
	}
	
	@RequestMapping(value = "/category")
	public String getCategory(Model model) {
		//logger.info("web-service search() invoked: " + criteria);

		List<Category> categories = categoriesService.findAll();
		model.addAttribute("categories", categories);
		//ritorna il template
		return "category";
	}
}
