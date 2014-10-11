package shoptemplate.totests;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

import pl.javaenterprisewarriors.shoptemplate.domain.Product;
import pl.javaenterprisewarriors.shoptemplate.tos.ProductTO;

public class ProductTOTest {

	@Test
	public void checkIfAllFieldsAddedToTOTest()
	{
		TOTestGeneralHelper.testIfAllFieldsPresentAndProperType(Product.class, ProductTO.class);
	}
	
	@Test
	public void checkIfAllFieldsArePrivate()
	{
		TOTestGeneralHelper.testIfAllFieldsArePrivate(ProductTO.class);
	}
	
	@Test
	public void checkIfClassHaveProperExtend()
	{
		TOTestGeneralHelper.checkIfTOCalssExtendsStandardTO(ProductTO.class);
	}
	
	@Test
	public void checkIfAllFiledsHaveProperAccessMethods()
	{
		TOTestGeneralHelper.checkIfAllPrivateFieldsProperHaveAccessorMethods(ProductTO.class);
	}
	
	@Test
	public void checkIfClassContainsTwoConstructors()
	{
		TOTestGeneralHelper.checkIfClassContainsTwoConstructors(ProductTO.class);
	}
	
	@Test
	public void checkIfLocketSetterMethodsThrowExeptions() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException
	{
		TOTestGeneralHelper.checkIfAllSettersThrowthrowExeptionsAfterUse(ProductTO.class);
	}
}
