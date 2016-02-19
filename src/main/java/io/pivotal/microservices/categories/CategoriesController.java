package io.pivotal.microservices.categories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoriesController {

	protected CategoryRepository categoryRepository;

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
}
