package pl.javaenterprisewarriors.shoptemplate.dao;

import pl.javaenterprisewarriors.shoptemplate.domain.Storekeeper;

public interface StorekeeperDAO {
	public void addStorekeepr(Storekeeper storekeeper);
	
	public void updateStorekeeper(Storekeeper storekeeper);
	
	public Storekeeper getStorekeeper(int id);
	
	public void deleteStorekeeper(Storekeeper storekeeper);
}
