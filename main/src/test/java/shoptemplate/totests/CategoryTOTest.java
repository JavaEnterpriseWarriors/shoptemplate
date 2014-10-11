package shoptemplate.totests;

import org.junit.Test;

import pl.javaenterprisewarriors.shoptemplate.domain.Category;
import pl.javaenterprisewarriors.shoptemplate.tos.CategoryTO;

public class CategoryTOTest {

	@Test
	public void checkIfCategoryToCoversCategory()
	{
		TOTestGeneralHelper.testIfAllFieldsPresentAndProperType(Category.class, CategoryTO.class);
	}
}
