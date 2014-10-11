package shoptemplate.totests;

import org.junit.Test;

import pl.javaenterprisewarriors.shoptemplate.domain.Storage;
import pl.javaenterprisewarriors.shoptemplate.tos.StorageTO;

public class StorageTOTest {
	@Test
	public void checkIfAllFieldsAddedToTOTest()
	{
		TOTestGeneralHelper.testIfAllFieldsPresentAndProperType(Storage.class, StorageTO.class);
	}
	
	@Test
	public void checkIfAllFieldsArePrivate()
	{
		TOTestGeneralHelper.testIfAllFieldsArePrivate(StorageTO.class);
	}
	
	@Test
	public void checkIfClassHaveProperExtend()
	{
		TOTestGeneralHelper.checkIfTOCalssExtendsStandardTO(StorageTO.class);
	}
	
	@Test
	public void checkIfAllFiledsHaveProperAccessMethods()
	{
		TOTestGeneralHelper.checkIfAllPrivateFieldsProperHaveAccessorMethods(StorageTO.class);
	}
	
	@Test
	public void checkIfClassContainsTwoConstructors()
	{
		TOTestGeneralHelper.checkIfClassContainsTwoConstructors(StorageTO.class);
	}
}
