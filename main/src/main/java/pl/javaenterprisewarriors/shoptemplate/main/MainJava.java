package pl.javaenterprisewarriors.shoptemplate.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import pl.javaenterprisewarriors.shoptemplate.domain.Product;
import pl.javaenterprisewarriors.shoptemplate.service.ProductService;

@Component
public class MainJava {
	
	private static ProductService productService;

	public static void main(String args[]){
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml"); 
		Product product = new Product("wpierdol", 100);
		productService.addProduct(product);
		Product product2 = productService.getProduct(product.getId());
		if (product.getName().equals(product2.getName())) System.out.println("YYYYYEEEAAAAHHH!!!!");
	}

	public ProductService getProductService() {
		return productService;
	}

	@Autowired
	public void setProductService(ProductService productService) {
		MainJava.productService = productService;
	}
}
