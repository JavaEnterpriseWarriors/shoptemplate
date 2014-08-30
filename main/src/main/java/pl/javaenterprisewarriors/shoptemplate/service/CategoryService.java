package pl.javaenterprisewarriors.shoptemplate.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import pl.javaenterprisewarriors.shoptemplate.dao.CategoryDAO;
import pl.javaenterprisewarriors.shoptemplate.domain.Category;

public class CategoryService {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	public Category getCategory(int id)
	{
		return categoryDAO.getCategory(id);
	}
	
	public Collection<Category> getSubCategorys(int id)
	{
		Category category = getCategory(id);
		return category.getSubCategorys();
	}

	public CategoryDAO getCategoryDAO() {
		return categoryDAO;
	}

	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}
}
