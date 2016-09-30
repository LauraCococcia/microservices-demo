package io.pivotal.microservices.products;

import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.pivotal.microservices.categories.Category;

@RestController
public class ProductsController {
	
	protected Logger logger = Logger.getLogger(ProductsController.class.getName());

	protected ProductRepository productRepository;
	
	protected Random randomGenerator = new Random();

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
	
	@RequestMapping("/product/{category_id}")
	public List<Product> getMenProducts(@PathVariable(value="category_id") Long category_id) {

		List<Product> products = productRepository.findByCategory(category_id);

		if (products == null) {
			throw new ProductNonFoundException();
		} else {
			logger.info("products found");
		    return products;
		}
	}
	
	@RequestMapping("/product/init")
	public void initDB(){
		
		List<Category> categories = productRepository.getCategories();
		for(int i=0; i< 1000; i++){
			Product product = new Product();
			
			product.setCategoryId(categories.get(randomGenerator.nextInt(categories.size())));
			product.setName(RandomStringUtils.randomAlphanumeric(20));
			product.setDescription(RandomStringUtils.randomAlphanumeric(20));
			product.setImage("/images/home/product"+randomGenerator.nextInt(6)+".jpg");
			productRepository.save(product);
		}
		
	}

}
