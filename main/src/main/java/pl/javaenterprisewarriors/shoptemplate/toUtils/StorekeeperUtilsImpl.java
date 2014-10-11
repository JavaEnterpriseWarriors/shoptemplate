package pl.javaenterprisewarriors.shoptemplate.toUtils;

import org.springframework.stereotype.Repository;

import pl.javaenterprisewarriors.shoptemplate.domain.Storekeeper;
import pl.javaenterprisewarriors.shoptemplate.tos.StorekeeperTO;

@Repository
public class StorekeeperUtilsImpl implements StorekeeperUtils {
	private StorekeeperTO storekeeperTO;
	
	public StorekeeperTO create(Storekeeper storekeeper) {
		StorekeeperTO tmpTO = new StorekeeperTO();
		tmpTO.setName(storekeeper.getName());
		tmpTO.setLastName(storekeeper.getLastName());
		
		return new StorekeeperTO(tmpTO);
	}

	public StorekeeperTO create() {
		if(storekeeperTO == null)
		{
			throw new NullPointerException("StorekeeperTo must be prepared first");
		}
		StorekeeperTO lockedTO = new StorekeeperTO(storekeeperTO);
		storekeeperTO = null;
		return lockedTO;
	}

	public void prepare() {
		storekeeperTO = new StorekeeperTO();
	}

	public void setName(String name) {
		storekeeperTO.setName(name);
	}

	public void setLastName(String lastName) {
		storekeeperTO.setLastName(lastName);
	}

}
