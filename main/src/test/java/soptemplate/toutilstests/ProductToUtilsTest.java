package soptemplate.toutilstests;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.javaenterprisewarriors.shoptemplate.domain.Product;
import pl.javaenterprisewarriors.shoptemplate.toUtils.ProductTOUtils;
import pl.javaenterprisewarriors.shoptemplate.tos.ProductTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/ApplicationContext.xml")
public class ProductToUtilsTest {
	@Autowired
	private ProductTOUtils productTOUtils;
	
	@Test
	public void createTOFromProductTest()
	{
		Product product = new Product("name", 1.0);
		ProductTO productTO = productTOUtils.createProductTO(product);
		
		assertNotNull("ProductTO was not created", productTO);
		
		assertEquals("productTO.name do not match with product.name", product.getName(), productTO.getName());
		assertEquals("productTO.price do not match with product.price", BigDecimal.valueOf(product.getPrice()), BigDecimal.valueOf(productTO.getPrice()));
	}
	
	@Test(expected=NullPointerException.class)
	public void createTOWithOutPrepreingTOTest()
	{
		productTOUtils.createProductTO();
	}
	
	@Test
	public void createTOWithSettersTest()
	{
		productTOUtils.prepareProductTO();
		productTOUtils.setProductName("Test");
		productTOUtils.setProductPrice(5.0);
		
		ProductTO productTO = productTOUtils.createProductTO();
		
		assertNotNull("ProductTO was not created", productTO);
		
		assertEquals("productTO.name do not match", "Test", productTO.getName());
		assertEquals("productTO.price do not match", BigDecimal.valueOf(5.0), BigDecimal.valueOf(productTO.getPrice()));
	}
	
	@Test
	public void checkIfTosEqualTest()
	{
		Product product1 = new Product("Test1", 5.0);
		Product product2 = new Product("Test2", 6.0);
		ProductTO productTO1 = productTOUtils.createProductTO(product1);
		ProductTO productTO2 = productTOUtils.createProductTO(product2);
		ProductTO productTO3 = productTOUtils.createProductTO(product1);
		
		assertTrue("ProjectTos form the same project do not math", productTOUtils.areEquals(productTO1, productTO3));
		assertFalse("ProjectTos form the difrente project do not math", productTOUtils.areEquals(productTO1, productTO2));
	}
	
	@Test
	public void margeTosTest()
	{
		Product product1 = new Product("Test1", 5.0);
		productTOUtils.prepareProductTO();
		productTOUtils.setProductName("Test2");
		productTOUtils.setProductPrice(null);
		
		ProductTO productTO1 = productTOUtils.createProductTO();
		ProductTO productTO2 = productTOUtils.createProductTO(product1);
		
		ProductTO productTO3 = productTOUtils.marge(productTO1, productTO2);
		
		assertEquals("Marge data do not math", "Test1", productTO3.getName());
		assertEquals("Marge data do not math", BigDecimal.valueOf(5.0), BigDecimal.valueOf(productTO3.getPrice()));
	}
}
