package io.pivotal.microservices.products;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.pivotal.microservices.categories.Category;

@Entity
@Table(name = "PRODUCT")
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Long productId;
	
	@ManyToOne
	@JoinColumn(name="categoryId")
	private Category category;
	
	private String name;
	private String description;
	private String image;
	
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Category getCategoryId() {
		return category;
	}
	public void setCategoryId(Category category) {
		this.category = category;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

}

/*
 * package io.pivotal.microservices.products;
 * 
 * import java.io.Serializable;
 * 
 * import javax.persistence.Column; import javax.persistence.Entity; import
 * javax.persistence.Id; import javax.persistence.Table;
 * 
 * @Entity
 * 
 * @Table(name="T_PRODUCT") public class Product implements Serializable {
 * 
 *//**
	* 
	*//*
	 * private static final long serialVersionUID = 1L;
	 * 
	 * @Id private Long id;
	 * 
	 * @Column(name = "name") private String name;
	 * 
	 * @Column(name="webid") private long webId;
	 * 
	 * @Column(name="image") private String image;
	 * 
	 * @Column(name="price") private int price;
	 * 
	 * @Column(name="quantity") private int quantity;
	 * 
	 * public Long getId() { return id; }
	 * 
	 * public void setId(Long id) { this.id = id; }
	 * 
	 * public String getName() { return name; }
	 * 
	 * public void setName(String name) { this.name = name; }
	 * 
	 * public long getWebId() { return webId; }
	 * 
	 * public void setWebId(long webId) { this.webId = webId; }
	 * 
	 * public String getImage() { return image; }
	 * 
	 * public void setImage(String image) { this.image = image; }
	 * 
	 * public int getPrice() { return price; }
	 * 
	 * public void setPrice(int price) { this.price = price; }
	 * 
	 * public int getQuantity() { return quantity; }
	 * 
	 * public void setQuantity(int quantity) { this.quantity = quantity; }
	 * 
	 * }
	 */