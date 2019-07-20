//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//	Project:			Project 0
//	File Name:			CloseStream.java
//	Description:		The Class CloseStreams for the Project 0 application
//	Author:				Ben Hunt, bigben37037@gmail.com
//	Created:			6-28-2019
//	Copyright:			Ben Hunt, 2019
//
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package files;

import java.sql.*;
import java.io.*;

//The class that is used to closed all streams, readers, and other input objects used by Project 0
public class CloseStreams 
{
	public static void close(Statement resource)
	{
		if(resource != null)
		{
			try
			{
				resource.close();
			}
			catch(Exception caughtException)
			{
				caughtException.printStackTrace();
			}
		}
	}
	
	public static void close(ResultSet resource)
	{
		if(resource != null)
		{
			try
			{
				resource.close();
			}
			catch(Exception caughtException)
			{
				caughtException.printStackTrace();
			}
		}
	}
	
	public static void close(FileInputStream resource)
	{
		if(resource != null)
		{
			try
			{
				resource.close();
			}
			catch(Exception caughtException)
			{
				caughtException.printStackTrace();
			}
		}
	}
	
	public static void close(Connection resource)
	{
		if(resource != null)
		{
			try
			{
				resource.close();
			}
			catch(Exception caughtException)
			{
				caughtException.printStackTrace();
			}
		}
	}
}
