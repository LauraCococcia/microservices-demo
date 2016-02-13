package io.pivotal.microservices.products;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.pivotal.microservices.products.ProductNonFoundException;

@RestController
public class ProductsController {
	
	protected Logger logger = Logger.getLogger(ProductsController.class.getName());

	protected ProductRepository productRepository;

	@Autowired
	public ProductsController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@RequestMapping("/shop")
	public List<Product> getProducts() {

		List<Product> products = productRepository.getProducts();

		if (products == null) {
			throw new ProductNonFoundException();
		} else {
			logger.info("products found");
		    return products;
		}
	}

}
