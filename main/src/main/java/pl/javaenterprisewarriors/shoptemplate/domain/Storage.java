package pl.javaenterprisewarriors.shoptemplate.domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "STORAGES")
public class Storage {

	@Id
	@GeneratedValue
	@Column(name = "STORAGE_ID")
	private int id;
	
	@ManyToMany(cascade = CascadeType.ALL)
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
