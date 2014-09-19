package pl.javaenterprisewarriors.shoptemplate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.javaenterprisewarriors.shoptemplate.dao.StorekeeperDAO;
import pl.javaenterprisewarriors.shoptemplate.domain.Storekeeper;

@Service
@Transactional
public class StorekeeperService {
	@Autowired
	private StorekeeperDAO storekeeperDAO;
	
	@Transactional
	public void addStorekeeper(Storekeeper storekeeper)
	{
		storekeeperDAO.addStorekeepr(storekeeper);
	}
	
	@Transactional
	public Storekeeper getStorekeeper(int id)
	{
		return storekeeperDAO.getStorekeeper(id);
	}
	
	@Transactional
	public void updateStorekeeper(Storekeeper storekeeper)
	{
		storekeeperDAO.updateStorekeeper(storekeeper);
	}
	
	@Transactional
	public void deleteStorekeeper(int id)
	{
		Storekeeper storekeeper = storekeeperDAO.getStorekeeper(id);
		storekeeperDAO.deleteStorekeeper(storekeeper);
	}

	public StorekeeperDAO getStorekeeperDAO() {
		return storekeeperDAO;
	}

	public void setStorekeeperDAO(StorekeeperDAO storekeeperDAO) {
		this.storekeeperDAO = storekeeperDAO;
	}
}
