package pl.javaenterprisewarriors.shoptemplate.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import pl.javaenterprisewarriors.shoptemplate.annotations.NotForTO;


@Entity
@Table(name="CATEGORIES")
public class Category {

	@Id
	@GeneratedValue
	@Column(name="CATEGORY_ID")
	@NotForTO
	private int id;
	
	@Column(name="NAME")
	private String name;
	
	@ManyToOne(targetEntity = Category.class)
	@JoinColumn(referencedColumnName="CATEGORY_ID", nullable=true)
	@NotForTO
	private Category parentCategory;
	
	public Category(){}
	public Category(String name, Category parentCategory)
	{
		this.name = name;
		this.parentCategory = parentCategory;
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
	public Category getParentCategory() {
		return parentCategory;
	}
	public void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}
}
