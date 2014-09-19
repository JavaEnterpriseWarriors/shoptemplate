package pl.javaenterprisewarriors.shoptemplate.dao;

import java.util.List;

import pl.javaenterprisewarriors.shoptemplate.domain.Category;

public interface CategoryDAO {
	public void addCategory(Category category);
	
	public Category getCategory(int id);
	
	public void upadteCategory(Category category);
	
	public void deleteCategory(Category category);
	
	public List<Category> getAllSubCategories(int id);
	
	public List<Category> getAllCategories();
}
