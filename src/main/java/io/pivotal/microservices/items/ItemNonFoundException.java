package io.pivotal.microservices.items;

public class ItemNonFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ItemNonFoundException(){
		super("No products");
	}
	
}
