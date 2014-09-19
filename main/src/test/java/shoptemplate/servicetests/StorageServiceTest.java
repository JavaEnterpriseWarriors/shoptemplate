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
		product1 = new Product("product1", 1);
		product2 = new Product("product2", 2);
		productService.addProduct(product1);
		productService.addProduct(product2);
	}

	@AfterClass
	public static void deleteProducts() {
		productService.removeProduct(product1);
		productService.removeProduct(product2);
	}

	@Before
	public void beforeTest() {
		storage1 = null;
		storage2 = null;
	}

	@After
	public void afterTest() {
		if (storage1 != null
				&& storageService.getStorage(storage1.getId()) != null)
			storageService.deleteStorage(storage1.getId());

		if (storage2 != null
				&& storageService.getStorage(storage2.getId()) != null)
			storageService.deleteStorage(storage2.getId());
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

	public ProductService getProductService() {
		return productService;
	}

	@Autowired
	public void setProductService(ProductService productService) {
		StorageServiceTest.productService = productService;
	}
}
