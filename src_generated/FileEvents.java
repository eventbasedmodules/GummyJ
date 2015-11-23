package org.gummymodules.generated;

import org.gummymodules.core.types.EventType;
import org.gummymodules.core.helpers.GummyException;

public class FileEvents extends org.gummymodules.core.types.EventType {
	private String fileID;
	private String userrole;
	
	public FileEvents() 	{
		super();
		this.add("fileID", null);
		this.add("userrole", null);
	}
	
	public String getFileID() 	{
		return this.fileID;
	}
	
	public void setFileID(String fileID) throws org.gummymodules.core.helpers.GummyException 	{
		this.fileID = fileID;
		this.set("fileID", fileID);
	}
	
	public String getUserrole() 	{
		return this.userrole;
	}
	
	public void setUserrole(String userrole) throws org.gummymodules.core.helpers.GummyException 	{
		this.userrole = userrole;
		this.set("userrole", userrole);
	}
	
}

