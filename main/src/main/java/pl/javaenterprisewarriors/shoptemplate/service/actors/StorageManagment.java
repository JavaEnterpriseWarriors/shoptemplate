package pl.javaenterprisewarriors.shoptemplate.service.actors;

import org.springframework.beans.factory.annotation.Autowired;

import pl.javaenterprisewarriors.shoptemplate.service.DiscountService;
import pl.javaenterprisewarriors.shoptemplate.service.ProductService;
import pl.javaenterprisewarriors.shoptemplate.service.StorageService;

public class StorageManagment {
	private int virtualStorageId;
	private int physicalStorageId;
	
	@Autowired
	private StorageService storageService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private DiscountService discountService;
	
	public StorageManagment()
	{
		this.virtualStorageId = storageService.getStorageIdByName("virtualStorageId");
		this.physicalStorageId = storageService.getStorageIdByName("physicalStorageId");
	}
}
