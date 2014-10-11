package pl.javaenterprisewarriors.shoptemplate.toUtils;

import org.springframework.stereotype.Repository;

import pl.javaenterprisewarriors.shoptemplate.domain.Category;
import pl.javaenterprisewarriors.shoptemplate.tos.CategoryTO;

@Repository
public class CategoryTOUtilsImpl implements CategoryTOUtils {
	private CategoryTO categoryTO;
	
	public CategoryTO createCategoryTO(Category category) {
		CategoryTO tmpTO = new CategoryTO();
		tmpTO.setName(category.getName());
		
		CategoryTO lockedTO = new CategoryTO(tmpTO);
		return lockedTO;
	}

	public CategoryTO createCategoryTO() {
		if(categoryTO == null)
		{
			throw new NullPointerException();
		}
		
		CategoryTO lockedTO = new CategoryTO(categoryTO);
		categoryTO = null;
		return lockedTO;
	}

	public void prepareCategoryTO() {
		categoryTO = new CategoryTO();
	}
	
	public void setName(String name)
	{
		categoryTO.setName(name);
	}

	public boolean areEqual(CategoryTO category1, CategoryTO category2) {
		if(!category1.getName().equals(category2.getName()))
		{
			return false;
		}
		
		return true;
	}

	public CategoryTO margeTOs(CategoryTO categoryTO1, CategoryTO categoryTO2) {
		CategoryTO tmpTO = new CategoryTO();
		
		if(categoryTO2.getName()!=null)
		{
			tmpTO.setName(categoryTO2.getName());
		}
		else
		{
			tmpTO.setName(categoryTO1.getName());
		}
		
		CategoryTO lockedTO = new CategoryTO(tmpTO);
		return lockedTO;
	}

}
