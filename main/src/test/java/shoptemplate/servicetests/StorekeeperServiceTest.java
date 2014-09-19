package shoptemplate.servicetests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.javaenterprisewarriors.shoptemplate.domain.Storekeeper;
import pl.javaenterprisewarriors.shoptemplate.service.StorekeeperService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/ApplicationContext.xml")
public class StorekeeperServiceTest {
	@Autowired
	private StorekeeperService storekeeperService;
	private Storekeeper storekeeper1;
	private Storekeeper storekeeper2;
	
	@Before
	public void beforeTest()
	{
		storekeeper1 = null;
		storekeeper2 = null;
	}
	
	@After
	public void afterTest()
	{
		if(storekeeper1!=null && storekeeperService.getStorekeeper(storekeeper1.getId())!=null)
			storekeeperService.deleteStorekeeper(storekeeper1.getId());
		
		if(storekeeper2!=null && storekeeperService.getStorekeeper(storekeeper2.getId())!=null)
			storekeeperService.deleteStorekeeper(storekeeper2.getId());
	}
	
	@Test
	public void addSimpleStorekeeperTest()
	{
		storekeeper1 = new Storekeeper("storekeeper", "1");
		storekeeperService.addStorekeeper(storekeeper1);
		
		storekeeper2 = storekeeperService.getStorekeeper(storekeeper1.getId());
		
		assertEquals("storkeeper name don't match", storekeeper1.getName(), storekeeper2.getName());
		assertEquals("storkeeper last name don't match", storekeeper1.getLastName(), storekeeper2.getLastName());
	}
	
	@Test
	public void updateSimpleStorekeeper()
	{
		storekeeper1 = new Storekeeper("storekeeper", "1");
		storekeeperService.addStorekeeper(storekeeper1);
		
		storekeeper1.setName("updated");
		storekeeperService.updateStorekeeper(storekeeper1);
		
		storekeeper2 = storekeeperService.getStorekeeper(storekeeper1.getId());
		assertEquals("storkeeper name don't match", storekeeper1.getName(), storekeeper2.getName());
	}
	
	@Test
	public void deleteSimpleStorekeeper()
	{
		storekeeper1 = new Storekeeper("storekeeper", "1");
		storekeeperService.addStorekeeper(storekeeper1);
		
		storekeeperService.deleteStorekeeper(storekeeper1.getId());
		
		assertNull(storekeeperService.getStorekeeper(storekeeper1.getId()));
	}
	
}
