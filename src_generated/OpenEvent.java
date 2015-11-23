package org.gummymodules.generated;

import org.gummymodules.core.types.EventType;
import org.gummymodules.core.helpers.GummyException;

public class OpenEvent extends FileEvents {
	private String mode;
	
	public OpenEvent() 	{
		super();
		this.add("mode", null);
	}
	
	public String getMode() 	{
		return this.mode;
	}
	
	public void setMode(String mode) throws org.gummymodules.core.helpers.GummyException 	{
		this.mode = mode;
		this.set("mode", mode);
	}
	
}

