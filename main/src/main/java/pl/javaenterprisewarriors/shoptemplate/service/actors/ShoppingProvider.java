package pl.javaenterprisewarriors.shoptemplate.service.actors;

public class ShoppingProvider {
	private SessionManager sessionManager;
	private StorageManagment storageManagment;
	
	public ShoppingProvider(int userId)
	{
		this.sessionManager =  new SessionManager(userId);
		this.storageManagment = new StorageManagment();
	}

}
