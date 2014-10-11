package shoptemplate.totests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Set;

import com.google.common.collect.Sets;

import pl.javaenterprisewarriors.shoptemplate.annotations.NotForTO;
import pl.javaenterprisewarriors.shoptemplate.tos.StandardTO;

public class TOTestGeneralHelper {

	public static void testIfAllFieldsPresentAndProperType(
			Class<?> domainClass, Class<?> toClass) {
		Field[] domainClassFields = domainClass.getDeclaredFields();
		Field[] toClassFields = toClass.getDeclaredFields();

		for (Field domainField : domainClassFields) {
			boolean fieldWasFound = false;
			Type fieldType = domainField.getType();
			if (!domainField.isAnnotationPresent(NotForTO.class)) {
				for (Field toField : toClassFields) {
					if (domainField.getName().equals(toField.getName())) {

						if (fieldType.equals(toField.getType())) {
							fieldWasFound = true;
							break;
						} else {
							fail("Field :" + toField.getName()
									+ " have wrong type");
						}
					}
				}
				assertTrue(
						"Field :" + domainField.getName() + " was not found",
						fieldWasFound);
			}
		}
	}

	public static void checkIfTOCalssExtendsStandardTO(Class<?> toClass) {
		assertTrue("TO class must extend StandartTO class",
				toClass.getSuperclass() == StandardTO.class);
	}

	public static void testIfAllFieldsArePrivate(Class<?> toClass)
	{
		Field[] toFields = toClass.getDeclaredFields();
		
		for(Field field : toFields)
		{
			if(!field.isAnnotationPresent(NotForTO.class))
			{
				assertTrue("Field :"+field.getName()+" is not private", Modifier.isPrivate(field.getModifiers()));
			}
		}
	}
	
	public static void checkIfAllPrivateFieldsProperHaveAccessorMethods(Class<?> toClass)
	{
		Method[] toMethods = toClass.getMethods();
		Field[] toFields = toClass.getDeclaredFields();
		
		Set<String> toMenthodsNameSet = Sets.newHashSet();
		
		for(Method method : toMethods)
		{
			toMenthodsNameSet.add(method.getName());
		}
		
		for(Field field : toFields)
		{
			if(!field.isAnnotationPresent(NotForTO.class))
			{
				char firstCharOfFiledName = Character.toUpperCase(field.getName().charAt(0));
				String getMethodName = "get" + firstCharOfFiledName + field.getName().substring(1);
				String setMethodName = "set" + firstCharOfFiledName + field.getName().substring(1);
				
				assertTrue("Get metod missing for field :"+field.getName(), toMenthodsNameSet.contains(getMethodName));
				assertTrue("Set metod missing for field :"+field.getName(), toMenthodsNameSet.contains(setMethodName));
			}
		}
 	}
	
	public static void checkIfClassContainsTwoConstructors(Class<?> toClass)
	{		
		Constructor<?>[] toConstructors = toClass.getConstructors();
		
		boolean constructorWithArgumentsFound = false;
		boolean constructorWithoutArgumentsFound = false;
		
		for(Constructor<?> constructor : toConstructors)
		{
			Type[] parameterTypes = constructor.getGenericParameterTypes();
			if(parameterTypes.length==0)
			{
				constructorWithoutArgumentsFound = true;
			}
			
			if(parameterTypes.length==1 && parameterTypes[0].equals(toClass))
			{
				constructorWithArgumentsFound = true;
			}
		}
		
		assertTrue("No Constructor without arguments found", constructorWithoutArgumentsFound);
		assertTrue("No Constructor witht arguments found", constructorWithArgumentsFound);
	}
	
	public static void checkIfAllSettersThrowthrowExeptionsAfterUse(Class<?> toClass) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException
	{
		Method[] toMethods = toClass.getMethods();
		Field[] toFields = toClass.getDeclaredFields();
		
		Constructor<?> toClassConstructorWithArguments = toClass.getConstructor(toClass);
		Constructor<?> toClassConstructorWithoutArguments = toClass.getConstructor(toClass);
		
		Object unLockedToObject = toClassConstructorWithoutArguments.newInstance();
		Object lockedToObject = toClassConstructorWithArguments.newInstance(unLockedToObject);
		
		for(Field field : toFields)
		{
			if(!field.isAnnotationPresent(NotForTO.class))
			{
				char firstCharOfFiledName = Character.toUpperCase(field.getName().charAt(0));
				String setMethodName = "set" + firstCharOfFiledName + field.getName().substring(1);
				
				for(Method method : toMethods)
				{
					if(method.getName().equals(setMethodName))
					{
						boolean exeptionWasThrown = false;
						
						Constructor<?> agumentConstructor = method.getParameterTypes()[0].getConstructor(); 
						Object argument = agumentConstructor.newInstance();
						
						try
						{
							method.invoke(lockedToObject, argument);
						}
						catch(InvocationTargetException ite)
						{
							exeptionWasThrown = true;
							assertTrue("Illegal state exeption should be thrown", ite.getCause() instanceof IllegalStateException);
						} catch (IllegalAccessException e) {
							e.printStackTrace();
						} catch (IllegalArgumentException e) {
							e.printStackTrace();
						}
						
						assertTrue("Exception shuld be thrown", exeptionWasThrown);
					}
				}
			}
		}
	}
}
