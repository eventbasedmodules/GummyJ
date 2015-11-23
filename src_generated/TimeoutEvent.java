package org.gummymodules.generated;

import org.gummymodules.core.types.EventType;
import org.gummymodules.core.helpers.GummyException;

public class TimeoutEvent extends org.gummymodules.core.types.EventType {
	private String fileID;
	private String userID;
	private int opentime;
	
	public TimeoutEvent() 	{
		super();
		this.add("fileID", null);
		this.add("userID", null);
		this.add("opentime", null);
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
	
	public int getOpentime() 	{
		return this.opentime;
	}
	
	public void setOpentime(int opentime) throws org.gummymodules.core.helpers.GummyException 	{
		this.opentime = opentime;
		this.set("opentime", opentime);
	}
	
}

