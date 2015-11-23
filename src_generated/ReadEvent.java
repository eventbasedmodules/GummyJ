package org.gummymodules.generated;

import org.gummymodules.core.types.EventType;
import org.gummymodules.core.helpers.GummyException;

public class ReadEvent extends FileEvents {
	private String content;
	
	public ReadEvent() 	{
		super();
		this.add("content", null);
	}
	
	public String getContent() 	{
		return this.content;
	}
	
	public void setContent(String content) throws org.gummymodules.core.helpers.GummyException 	{
		this.content = content;
		this.set("content", content);
	}
	
}

