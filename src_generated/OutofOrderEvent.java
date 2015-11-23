package org.gummymodules.generated;

import org.gummymodules.core.types.EventType;
import org.gummymodules.core.helpers.GummyException;

public class OutofOrderEvent extends org.gummymodules.core.types.EventType {
	private String fileID;
	private String userID;
	
	public OutofOrderEvent() 	{
		super();
		this.add("fileID", null);
		this.add("userID", null);
	}
	
	public String getFileID() 	{
		return this.fileID;
	}
	
	public void setFileID(String fileID) throws org.gummymodules.core.helpers.GummyException 	{
		this.fileID = fileID;
		this.set("fileID", fileID);
	}
	
	public String getUserID() 	{
		return this.userID;
	}
	
	public void setUserID(String userID) throws org.gummymodules.core.helpers.GummyException 	{
		this.userID = userID;
		this.set("userID", userID);
	}
	
}

