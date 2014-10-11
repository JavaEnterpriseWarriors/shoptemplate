package pl.javaenterprisewarriors.shoptemplate.toUtils;

import pl.javaenterprisewarriors.shoptemplate.domain.Storage;
import pl.javaenterprisewarriors.shoptemplate.tos.StorageTO;

public interface StorageTOUtils {
	public StorageTO createTO(Storage storage);
	
	public StorageTO createTO();
	
	public void prepareTO();
	
	public void setName(String name);
	
	public boolean areEquals(StorageTO to1, StorageTO to2);
	
	public StorageTO margeTO(StorageTO to1, StorageTO to2);
}
