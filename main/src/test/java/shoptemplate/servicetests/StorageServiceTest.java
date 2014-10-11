package shoptemplate.servicetests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.javaenterprisewarriors.shoptemplate.domain.Product;
import pl.javaenterprisewarriors.shoptemplate.domain.Storage;
import pl.javaenterprisewarriors.shoptemplate.service.ProductService;
import pl.javaenterprisewarriors.shoptemplate.service.StorageService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/ApplicationContext.xml")
public class StorageServiceTest {
	@Autowired
	private StorageService storageService;
	private static ProductService productService;
	private Storage storage1;
	private Storage storage2;
	private static Product product1;
	private static Product product2;
	
	@BeforeClass
	public static void prepareProducts() {
		//Przenieœæ tworzenoie produktów
	}

	@AfterClass
	public static void deleteProducts() {
		//Przenieœæ usuwanie produktów
	}

	@Before
	public void beforeTest() {
		storage1 = null;
		storage2 = null;
		product1 = new Product("product1", 1);
		product2 = new Product("product2", 2);
		productService.addProduct(product1);
		productService.addProduct(product2);
	}

	@After
	public void afterTest() {
		if (storage1 != null
				&& storageService.getStorage(storage1.getId()) != null)
		{
			storageService.deleteProductsFromStorage(storage1.getId());
			storageService.deleteStorage(storage1.getId());
		}

		if (storage2 != null
				&& storageService.getStorage(storage2.getId()) != null)
		{
			storageService.deleteProductsFromStorage(storage2.getId());
			storageService.deleteStorage(storage2.getId());
		}

		productService.removeProduct(product1);
		productService.removeProduct(product2);
	}

	@Test
	public void addSimpleStorageTest() {
		storage1 = new Storage("Storage1", null);
		storageService.addStorage(storage1);

		storage2 = storageService.getStorage(storage1.getId());

		assertEquals("Storage name do not mach", storage1.getName(),
				storage2.getName());
	}

	@Test
	public void delateSimpleStorage() {
		storage1 = new Storage("Storage1", null);
		storageService.addStorage(storage1);
		storageService.deleteStorage(storage1.getId());

		assertNull(storageService.getStorage(storage1.getId()));
	}
	
	@Test
	public void addGetProductTest()
	{
		storage1 =  new Storage("Storage1", null);
		storageService.addStorage(storage1);
		
		storageService.addProduct(storage1.getId(), product1);
		
		assertNotNull("Product not availabie in storage", storageService.getProduct(storage1.getId(), product1.getId()));
	}
	
	@Test
	public void removeProductTest()
	{
		storage1 =  new Storage("Storage1", null);
		storageService.addStorage(storage1);
		
		storageService.addProduct(storage1.getId(), product1);
		
		storageService.removeProduct(storage1.getId(), product1);
		assertNull("Product shuld not be available in storage", storageService.getProduct(storage1.getId(), product1.getId()));
	}

	public ProductService getProductService() {
		return productService;
	}

	@Autowired
	public void setProductService(ProductService productService) {
		StorageServiceTest.productService = productService;
	}
}
