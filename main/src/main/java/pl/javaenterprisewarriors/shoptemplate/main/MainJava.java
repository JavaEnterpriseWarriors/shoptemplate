package pl.javaenterprisewarriors.shoptemplate.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import pl.javaenterprisewarriors.shoptemplate.domain.Category;
import pl.javaenterprisewarriors.shoptemplate.domain.Product;
import pl.javaenterprisewarriors.shoptemplate.service.CategoryService;
import pl.javaenterprisewarriors.shoptemplate.service.ProductService;

@Component
public class MainJava {
	
	private static ProductService productService;
	private static CategoryService categoryService;

	public static void main(String args[]){
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml"); 
		
		
		Product product = new Product("wpierdol", 100);
		productService.addProduct(product);
		Product product2 = productService.getProduct(product.getId());
		if (product.getName().equals(product2.getName())) System.out.println("YYYYYEEEAAAAHHH!!!!");
		
		Category category = new Category("TestCategory",null);
		categoryService.addCategory(category);
		Category category2 = categoryService.getCategory(category.getId());
		if(category.getName().equals(category2.getName())) System.out.println("CTEGORY OK");
		
		Category category3 = new Category("test", category);
		categoryService.addCategory(category3);
		Category parentCategory = categoryService.getParentCategory(category3.getId());
		if(category3.getParentCategory().getName().equals(parentCategory.getName())) System.out.println("PARENT CATEGORY OK");
	}

	public ProductService getProductService() {
		return productService;
	}

	@Autowired
	public void setProductService(ProductService productService) {
		MainJava.productService = productService;
	}

	public CategoryService getCategoryService() {
		return categoryService;
	}

	@Autowired
	public void setCategoryService(CategoryService categoryService) {
		MainJava.categoryService = categoryService;
	}
}
