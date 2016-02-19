package io.pivotal.microservices.categories;

public class CategoryNonFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CategoryNonFoundException(){
		super("No Categories");
	}

}
