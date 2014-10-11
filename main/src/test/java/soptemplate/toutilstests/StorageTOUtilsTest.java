package soptemplate.toutilstests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.javaenterprisewarriors.shoptemplate.domain.Storage;
import pl.javaenterprisewarriors.shoptemplate.toUtils.StorageTOUtils;
import pl.javaenterprisewarriors.shoptemplate.tos.StorageTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/ApplicationContext.xml")
public class StorageTOUtilsTest {
	@Autowired
	private StorageTOUtils storageTOUtils;
	
	@Test
	public void createTOFromStorageTest()
	{
		Storage storage = new Storage("name", null);
		
		StorageTO storageTO = storageTOUtils.createTO(storage);
		assertEquals("TO.name do not match with Storage.name", storage.getName(), storageTO.getName());
	}
	
	@Test(expected = NullPointerException.class)
	public void createTOWithoutPrepareTest()
	{
		storageTOUtils.createTO();
	}
	
	@Test
	public void createTOWithSettersTest()
	{
		storageTOUtils.prepareTO();
		storageTOUtils.setName("TEST");
		
		StorageTO storageTO = storageTOUtils.createTO();
		
		assertEquals("TO.name do not match with Storage.name", "TEST", storageTO.getName());
	}
	
	@Test
	public void checkIfTosEqualsTest()
	{
		Storage storage1 = new Storage("1", null);
		Storage storage2 = new Storage("2", null);
		Storage storage3 = new Storage("1", null);
		
		StorageTO to1 = storageTOUtils.createTO(storage1);
		StorageTO to2 = storageTOUtils.createTO(storage2);
		StorageTO to3 = storageTOUtils.createTO(storage3);
		
		assertFalse("Storage with not mathing name should return false", storageTOUtils.areEquals(to1, to2));
		assertTrue("Storage with mathing name should return true", storageTOUtils.areEquals(to1, to3));
				
	}
	
	@Test
	public void maregTOsTest()
	{
		Storage storage1 = new Storage("1", null);
		Storage storage2 = new Storage("2", null);
		Storage storage3 = new Storage(null, null);
		
		StorageTO to1 = storageTOUtils.createTO(storage1);
		StorageTO to2 = storageTOUtils.createTO(storage2);
		StorageTO to3 = storageTOUtils.createTO(storage3);
		
		StorageTO margedTO1 = storageTOUtils.margeTO(to1, to2);
		StorageTO margedTO2 = storageTOUtils.margeTO(to1, to3);
		
		assertEquals("Marged TO name do not match", to2.getName(), margedTO1.getName());
		assertEquals("Marged TO name do not match", to1.getName(), margedTO2.getName());
	}
}
