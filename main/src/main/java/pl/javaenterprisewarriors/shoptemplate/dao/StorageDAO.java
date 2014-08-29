package pl.javaenterprisewarriors.shoptemplate.dao;

import java.util.Collection;

import pl.javaenterprisewarriors.shoptemplate.domain.Product;
import pl.javaenterprisewarriors.shoptemplate.domain.Storage;

public interface StorageDAO {
	public void addStorage(Storage storage);
	
	public Storage getStorage(int id);
	
	public Collection<Product> getAllProductInStorage(int id);
}
