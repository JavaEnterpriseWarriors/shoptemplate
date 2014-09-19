package pl.javaenterprisewarriors.shoptemplate.dao;

import java.util.Collection;

import pl.javaenterprisewarriors.shoptemplate.domain.Product;
import pl.javaenterprisewarriors.shoptemplate.domain.Storage;

public interface StorageDAO {
	public void addStorage(Storage storage);
	
	public Storage getStorage(int id);
	
	public int getStorageIdByName(String name);
	
	public void delateStorage(int id);
	
	public Collection<Product> getAllProductInStorage(int id);
	
	public void updateStorage(Storage storage);
}
