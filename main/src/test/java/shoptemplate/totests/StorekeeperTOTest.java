package shoptemplate.totests;

import org.junit.Test;

import pl.javaenterprisewarriors.shoptemplate.domain.Storekeeper;
import pl.javaenterprisewarriors.shoptemplate.tos.StorekeeperTO;

public class StorekeeperTOTest {
	@Test
	public void checkIfAllFieldsAddedToTOTest()
	{
		TOTestGeneralHelper.testIfAllFieldsPresentAndProperType(Storekeeper.class, StorekeeperTO.class);
	}
	
	@Test
	public void checkIfAllFieldsArePrivate()
	{
		TOTestGeneralHelper.testIfAllFieldsArePrivate(StorekeeperTO.class);
	}
	
	@Test
	public void checkIfClassHaveProperExtend()
	{
		TOTestGeneralHelper.checkIfTOCalssExtendsStandardTO(StorekeeperTO.class);
	}
	
	@Test
	public void checkIfAllFiledsHaveProperAccessMethods()
	{
		TOTestGeneralHelper.checkIfAllPrivateFieldsProperHaveAccessorMethods(StorekeeperTO.class);
	}
	
	@Test
	public void checkIfClassContainsTwoConstructors()
	{
		TOTestGeneralHelper.checkIfClassContainsTwoConstructors(StorekeeperTO.class);
	}
}
