package shoptemplate.servicetests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.javaenterprisewarriors.shoptemplate.domain.Category;
import pl.javaenterprisewarriors.shoptemplate.service.CategoryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/ApplicationContext.xml")
public class CategoryServiceTest {
	@Autowired
	private CategoryService categoryService;
	private Category category1;
	private Category category2;
	private Category category3;

	@Before
	public void beforeTests() {
		category1 = null;
		category2 = null;
		category3 = null;
	}

	@After
	public void afterTests() {
		if (category1 != null
				&& categoryService.getCategory(category1.getId()) != null) {
			categoryService.deleteReferencesInAllSubCategories(category1);
			categoryService.deleteCategory(category1);
		}

		if (category2 != null
				&& categoryService.getCategory(category2.getId()) != null)
		{
			categoryService.deleteReferencesInAllSubCategories(category2);
			categoryService.deleteCategory(category2);
		}

		if (category3 != null
				&& categoryService.getCategory(category2.getId()) != null)
		{
			categoryService.deleteReferencesInAllSubCategories(category2);
			categoryService.deleteCategory(category3);
		}
	}

	@Test
	public void addingSimpleCategoryAndReadingTest() {
		category1 = new Category("category1", null);
		categoryService.addCategory(category1);
		category2 = categoryService.getCategory(category1.getId());

		assertEquals("Added Category name don't match readed one.",
				category1.getName(), category2.getName());
		assertEquals("Added Category parent category don't match readed one.",
				category1.getParentCategory(), category2.getParentCategory());
	}

	@Test
	public void addingAndReadingSimpleCategoryWithParent() {
		category1 = new Category("category1", null);
		categoryService.addCategory(category1);

		category2 = new Category("category2", category1);
		categoryService.addCategory(category2);

		category3 = categoryService.getCategory(category2.getId());

		assertEquals("Parent parent category don't match.", category2
				.getParentCategory().getName(), category3.getParentCategory()
				.getName());
	}

	@Test
	public void deleteCategoryTest() {
		category1 = new Category("category1", null);
		categoryService.addCategory(category1);
		categoryService.deleteCategory(category1);

		assertTrue("Deleted category still in database.",
				categoryService.getCategory(category1.getId()) == null);
	}

	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

}
