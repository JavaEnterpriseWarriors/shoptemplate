package pl.javaenterprisewarriors.shoptemplate.toUtils;

import org.springframework.stereotype.Repository;

import pl.javaenterprisewarriors.shoptemplate.domain.Storage;
import pl.javaenterprisewarriors.shoptemplate.tos.StorageTO;

@Repository
public class StorageTOUtilsImpl implements StorageTOUtils {
	private StorageTO storageTO;
	
	public StorageTO createTO(Storage storage) {
		StorageTO tmpTO = new StorageTO();
		tmpTO.setName(storage.getName());
		
		return new StorageTO(tmpTO);
	}

	public StorageTO createTO() {
		if(storageTO == null)
		{
			throw new NullPointerException("Storag TO must be created first");
		}
		
		StorageTO lockedTO = new StorageTO(storageTO);
		storageTO = null;
		
		return lockedTO;
	}

	public void prepareTO() {
		storageTO = new StorageTO();
	}

	public void setName(String name) {
		storageTO.setName(name);
	}

	public boolean areEquals(StorageTO to1, StorageTO to2) {
		if(!to1.getName().equals(to2.getName()))
		{
			return false;
		}
		return true;
	}

	public StorageTO margeTO(StorageTO to1, StorageTO to2) {
		StorageTO tmpTO = new StorageTO();
		
		if(to2.getName()==null)
		{
			tmpTO.setName(to1.getName());
		}
		else
		{
			tmpTO.setName(to2.getName());
		}
		
		return new StorageTO(tmpTO);
	}

}
