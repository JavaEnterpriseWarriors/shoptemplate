package pl.javaenterprisewarriors.shoptemplate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
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
	public void addCategory(Category category)
	{
		categoryDAO.addCategory(category);
	}
	
	@Transactional
	public Category getParentCategory(int id)
	{
		Category category = getCategory(id);
		return category.getParentCategory();
	}

	
	public void deleteCategory(int id)
	{
		Category category = getCategory(id);
		deleteCategory(category);
	}
		
	@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.SERIALIZABLE)
	public void deleteCategory(Category category)
	{
		deleteReferencesInAllSubCategories(category);
		categoryDAO.deleteCategory(category);
	}
	
	@Transactional(isolation = Isolation.SERIALIZABLE)
	public void deleteReferencesInAllSubCategories(Category category)
	{
		List<Category> subCategories = categoryDAO.getAllSubCategories(category.getId());
		for(Category subCategory:subCategories)
		{
			subCategory.setParentCategory(null);
			categoryDAO.upadteCategory(subCategory);
		}
	}
	
	@Transactional
	public List<Category> getAllCategory()
	{
		return categoryDAO.getAllCategories();
	}
	
	public CategoryDAO getCategoryDAO() {
		return categoryDAO;
	}

	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}
}
