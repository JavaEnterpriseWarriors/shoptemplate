package pl.javaenterprisewarriors.shoptemplate.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import pl.javaenterprisewarriors.shoptemplate.annotations.NotForTO;

@Entity
@Table(name = "PRODUCTS")
public class Product {
	
	@NotForTO
	@Id
	@GeneratedValue
	@Column(name = "PRODUCT_ID")
	private int id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "PRICE")
	private Double price;
	
	public Product(){}
	
	public Product(String name, double price)
	{
		this.name = name;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
