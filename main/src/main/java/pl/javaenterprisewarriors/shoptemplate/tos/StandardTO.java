package pl.javaenterprisewarriors.shoptemplate.tos;

import pl.javaenterprisewarriors.shoptemplate.annotations.NotForTO;

public class StandardTO {
	@NotForTO
	protected final boolean locked;
	
	public StandardTO()
	{
		locked = false;
	}
	
	public StandardTO(StandardTO to)
	{
		locked = true;
	}
	
	protected <T> T setInNotLocked(T source)
	{
		if(locked)
		{
			throw new IllegalStateException("Object locked");
		}
		return source;
	}
}
