package pl.javaenterprisewarriors.shoptemplate.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.javaenterprisewarriors.shoptemplate.dao.CategoryDAO;
import pl.javaenterprisewarriors.shoptemplate.domain.Category;

@Service
@Transactional
public class CategoryService {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Transactional
	public Category getCategory(int id)
	{
		return categoryDAO.getCategory(id);
	}
	
	@Transactional
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
