package pl.javaenterprisewarriors.shoptemplate.domain;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CATEGORYS")
public class Category {

	@Id
	@GeneratedValue
	@Column(name="CATEGORY_ID")
	private int id;
	
	@Column(name="NAME")
	private String name;
	
	@OneToMany(mappedBy="id")
	private Collection<Category> subCategorys;
	
	public Category(){}
	public Category(String name, Collection<Category> subCategorys)
	{
		this.name = name;
		this.subCategorys = subCategorys;
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
	public Collection<Category> getSubCategorys() {
		return subCategorys;
	}
	public void setSubCategorys(Collection<Category> subCategorys) {
		this.subCategorys = subCategorys;
	}
}
