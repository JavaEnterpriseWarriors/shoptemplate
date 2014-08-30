package pl.javaenterprisewarriors.shoptemplate.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import pl.javaenterprisewarriors.shoptemplate.dao.StorageDAO;
import pl.javaenterprisewarriors.shoptemplate.domain.Product;
import pl.javaenterprisewarriors.shoptemplate.domain.Storage;

public class StorageService {
	@Autowired
	private StorageDAO storageDAO;

	public Collection<Product> getProducts(int id)
	{
		return storageDAO.getAllProductInStorage(id);
	}
	
	public void addAllProducts(int id, Product product)
	{
		Storage storage = storageDAO.getStorage(id);
		storage.getProducts().add(product);
		storageDAO.updateStorage(storage);
	}
	
	public void removeProduct(int id, Product product)
	{
		Storage storage = storageDAO.getStorage(id);
		storage.getProducts().remove(product);
		storageDAO.updateStorage(storage);
	}
	
	public Product getProduct(int storageId, int productId)
	{
		Storage storage = storageDAO.getStorage(storageId);
		Product result=null;
		for(Product product:storage.getProducts())
		{
			if(product.getProduct_id()==productId)
			{
				result = product;
				break;
			}
		}
		
		return result;
	}
	
	public StorageDAO getStorageDAO() {
		return storageDAO;
	}

	public void setStorageDAO(StorageDAO storageDAO) {
		this.storageDAO = storageDAO;
	}
}
