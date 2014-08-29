package pl.javaenterprisewarriors.shoptemplate.dao;

import pl.javaenterprisewarriors.shoptemplate.domain.Category;

public interface CategoryDAO {
	public void addCategory(Category category);
	
	public Category getCategory(int id);
	
	public void upadteCategory(Category category);
}
