package io.pivotal.microservices.products;

public class ProductNonFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ProductNonFoundException(){
		super("No products");
	}
	
}
