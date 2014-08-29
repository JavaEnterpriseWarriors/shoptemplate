package pl.javaenterprisewarriors.shoptemplate.domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "STORAGE")
public class Storage {

	@Id
	@GeneratedValue
	@Column(name = "STORAGE_ID")
	private int id;
	
	@OneToMany
	@JoinColumn(name = "PRODUCT_ID")
	private Collection<Product> products = new ArrayList<Product>();
	
	public Storage(){}
	
	public Storage(Collection<Product> products)
	{
		this.products = products;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Collection<Product> getProducts() {
		return products;
	}

	public void setProducts(Collection<Product> products) {
		this.products = products;
	}
}
