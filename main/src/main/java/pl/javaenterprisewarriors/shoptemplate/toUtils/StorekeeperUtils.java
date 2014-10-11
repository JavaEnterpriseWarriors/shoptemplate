package pl.javaenterprisewarriors.shoptemplate.toUtils;

import pl.javaenterprisewarriors.shoptemplate.domain.Storekeeper;
import pl.javaenterprisewarriors.shoptemplate.tos.StorekeeperTO;

public interface StorekeeperUtils {

	public StorekeeperTO create(Storekeeper storekeeper);
	public StorekeeperTO create();
	public void prepare();
	public void setName(String name);
	public void setLastName(String lastName);
}
