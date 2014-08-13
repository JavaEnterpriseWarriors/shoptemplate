package pl.javaenterprisewarriors.shoptemplate.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
public class Product {
	
	@Id
	@GeneratedValue
	@Column(name = "PRODUCT_ID")
	private int product_id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "PRICE")
	private int price;
	
	public Product(){}
	
	public Product(String name, int price)
	{
		this.name = name;
		this.price = price;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
