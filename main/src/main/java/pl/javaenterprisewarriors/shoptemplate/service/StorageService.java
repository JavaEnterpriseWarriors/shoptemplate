package pl.javaenterprisewarriors.shoptemplate.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.javaenterprisewarriors.shoptemplate.dao.StorageDAO;
import pl.javaenterprisewarriors.shoptemplate.domain.Product;
import pl.javaenterprisewarriors.shoptemplate.domain.Storage;

@Service
@Transactional
public class StorageService {
	@Autowired
	private StorageDAO storageDAO;

	@Transactional
	public Collection<Product> getProducts(int id)
	{
		return storageDAO.getAllProductInStorage(id);
	}
	
	@Transactional
	public void addProduct(int id, Product product)
	{
		Storage storage = storageDAO.getStorage(id);
		storage.getProducts().add(product);
		storageDAO.updateStorage(storage);
	}
	
	@Transactional
	public void removeProduct(int id, Product product)
	{
		Storage storage = storageDAO.getStorage(id);
		storage.getProducts().remove(product);
		storageDAO.updateStorage(storage);
	}
	
	@Transactional
	public Product getProduct(int storageId, int productId)
	{
		Storage storage = storageDAO.getStorage(storageId);
		Product result=null;
		for(Product product:storage.getProducts())
		{
			if(product.getId()==productId)
			{
				result = product;
				break;
			}
		}
		
		return result;
	}
	
	@Transactional
	public void addStorage(Storage storage)
	{
		storageDAO.addStorage(storage);
	}
	
	@Transactional
	public Storage getStorage(int id)
	{
		return storageDAO.getStorage(id);
	}
	
	@Transactional
	public int getStorageIdByName(String name)
	{
		return storageDAO.getStorageIdByName(name);
	}
	
	@Transactional
	public void deleteStorage(int id)
	{
		storageDAO.delateStorage(id);
	}
	
	public StorageDAO getStorageDAO() {
		return storageDAO;
	}

	public void setStorageDAO(StorageDAO storageDAO) {
		this.storageDAO = storageDAO;
	}
}
