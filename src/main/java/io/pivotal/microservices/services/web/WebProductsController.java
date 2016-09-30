package io.pivotal.microservices.services.web;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import io.pivotal.microservices.products.Product;

/**
 * Client controller, fetches Account info from the microservice via
 * {@link WebProductsService}.
 * 
 * @author Daniele Di Pompeo
 */
@Controller
public class WebProductsController {

	@Autowired
	protected WebProductsService productsService;

	protected Logger logger = Logger.getLogger(WebProductsController.class.getName());

	public WebProductsController(WebProductsService productsService) {
		this.productsService = productsService;
	}

	// @InitBinder
	// public void initBinder(WebDataBinder binder) {
	// binder.setAllowedFields("accountNumber", "searchText");
	// }

	@RequestMapping(value = "/shop")
	public String getShop(Model model) {
		//logger.info("web-service search() invoked: " + criteria);

		List<Product> products = productsService.findAll();
		model.addAttribute("products", products);
		return "shop";
	}
	
	@RequestMapping(value = "/product/{category_id}")
	public String getCategory(@PathVariable(value="category_id") Long category_id, Model model) {
		//logger.info("web-service search() invoked: " + criteria);

		List<Product> products = productsService.findProductByCategory(category_id);
		model.addAttribute("products", products);
		//ritorna il template
		return "shop";
	}
}
