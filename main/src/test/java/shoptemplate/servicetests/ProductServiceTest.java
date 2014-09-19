package shoptemplate.servicetests;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.javaenterprisewarriors.shoptemplate.domain.Product;
import pl.javaenterprisewarriors.shoptemplate.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/ApplicationContext.xml")
public class ProductServiceTest {
	@Autowired
	private ProductService productService;
	private Product product1;
	private Product product2;
	
	@Before
	public void beforeTest()
	{
		product1 = null;
		product2 = null;
	}
	
	@After
	public void afterTest()
	{
		if(product1!=null && productService.getProduct(product1.getId())!=null)
			productService.removeProduct(product1);
		
		if(product2!=null && productService.getProduct(product2.getId())!=null)
			productService.removeProduct(product2);
	}
	
	@Test
	public void simpleAddTest()
	{
		product1 = new Product("Product1", 2);
		productService.addProduct(product1);
		
		product2 = productService.getProduct(product1.getId());
		
		assertEquals("Product name do not match",product1.getName(),product2.getName());
		assertEquals("Product name do not match",BigDecimal.valueOf(product1.getPrice()),BigDecimal.valueOf(product2.getPrice()));
	}
	
	@Test
	public void simpleRemoveTest()
	{
		product1 = new Product("Product1", 2);
		productService.addProduct(product1);
		productService.removeProduct(product1);
		
		assertNull(productService.getProduct(product1.getId()));
	}
	
	@Test
	public void simpleUpdateTest()
	{
		product1 = new Product("Product1", 1);
		productService.addProduct(product1);
		
		product1.setName("ChangedName");
		productService.updateProduct(product1);
		product2 = productService.getProduct(product1.getId());
		
		assertEquals("Product name was not updated", product1.getName(), product2.getName());
	}
}
