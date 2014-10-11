package pl.javaenterprisewarriors.shoptemplate.toUtils;

import pl.javaenterprisewarriors.shoptemplate.domain.Category;
import pl.javaenterprisewarriors.shoptemplate.tos.CategoryTO;

public interface CategoryTOUtils {

	public CategoryTO createCategoryTO(Category category);

	public CategoryTO createCategoryTO();

	public void prepareCategoryTO();
	
	public void setName(String name);

	public boolean areEqual(CategoryTO category1, CategoryTO category2);

	public CategoryTO margeTOs(CategoryTO categoryTO1, CategoryTO categoryTO2);

}
