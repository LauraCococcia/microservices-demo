package io.pivotal.microservices.categories;

import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoriesController {

	protected CategoryRepository categoryRepository;
	private Random randomGenerator = new Random();

	@Autowired
	public CategoriesController(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	@RequestMapping("/category")
	public List<Category> getCategory(){
		List<Category> categories = categoryRepository.findAll();
		
		if(categories == null){
			throw new CategoryNonFoundException();
		}else{
			return categories;
		}
	}
	
	@RequestMapping("/category/init")
	public void initDB(){
		
		for(int i=0; i< 10; i++){
			Category category = new Category();
			category.setName(RandomStringUtils.randomAlphanumeric(20));
			category.setDescription(RandomStringUtils.randomAlphanumeric(20));
			categoryRepository.save(category);
		}
		
	}
}
