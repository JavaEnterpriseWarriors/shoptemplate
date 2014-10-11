package soptemplate.toutilstests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.javaenterprisewarriors.shoptemplate.domain.Category;
import pl.javaenterprisewarriors.shoptemplate.toUtils.CategoryTOUtils;
import pl.javaenterprisewarriors.shoptemplate.tos.CategoryTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/ApplicationContext.xml")
public class CategoryTOUtilsTest {
	@Autowired
	private CategoryTOUtils categoryTOUtils;
	
	@Test
	public void creteTOFromCategoryTest()
	{
		Category category = new Category("category", null);
		
		CategoryTO categoryTO = categoryTOUtils.createCategoryTO(category);
		
		assertEquals("Category CategoryTO.name do not math Category.name", category.getName(), categoryTO.getName());
		
	}
	
	@Test(expected=NullPointerException.class)
	public void createTOWithOutPreparingTOTest()
	{
		categoryTOUtils.createCategoryTO();
	}
	
	@Test
	public void createCategoryTOWithSettersTest()
	{
		categoryTOUtils.prepareCategoryTO();
		categoryTOUtils.setName("test");
		
		CategoryTO categoryTO = categoryTOUtils.createCategoryTO();
		
		assertEquals("Category CategoryTO.name do not math Category.name", "test", categoryTO.getName());
	}
	
	@Test
	public void categoryTOEqualsTest()
	{
		Category category1 = new Category("1", null);
		Category category2 = new Category("1", null);
		Category category3 = new Category("2", null);
		
		CategoryTO categoryTO1 = categoryTOUtils.createCategoryTO(category1);
		CategoryTO categoryTO2 = categoryTOUtils.createCategoryTO(category2);
		CategoryTO categoryTO3 = categoryTOUtils.createCategoryTO(category3);
		
		assertTrue("Matching TOs should return true", categoryTOUtils.areEqual(categoryTO1, categoryTO2));
		assertFalse("Not matching TOs should return false", categoryTOUtils.areEqual(categoryTO1, categoryTO3));
	}
	
	@Test
	public void margeTOsTest()
	{
		Category category1 = new Category("1", null);
		Category category2 = new Category(null, null);
		Category category3 = new Category("2", null);
		
		CategoryTO categoryTO1 = categoryTOUtils.createCategoryTO(category1);
		CategoryTO categoryTO2 = categoryTOUtils.createCategoryTO(category2);
		CategoryTO categoryTO3 = categoryTOUtils.createCategoryTO(category3);
		
		CategoryTO margedTO1 = categoryTOUtils.margeTOs(categoryTO1, categoryTO2);
		CategoryTO margedTO2 = categoryTOUtils.margeTOs(categoryTO1, categoryTO3);
		
		assertEquals("Marget category tos name do not match", categoryTO1.getName(), margedTO1.getName());
		assertEquals("Marget category tos name do not match", categoryTO3.getName(), margedTO2.getName());
	}
}
