//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//	Project:			Project 0
//	File Name:			ConnectionUtility.java
//	Description:		The Class ConnectionUtility for the Project 0 application
//	Author:				Ben Hunt, bigben37037@gmail.com
//	Created:			6-28-2019
//	Copyright:			Ben Hunt, 2019
//
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package files;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtility 
{
	//Variable for instantiating new local Connection variable 
	private static Connection connectionVariable = null;
	
	//Method for retrieving connection parameters for connection to database
	public static Connection getConnection()
	{
		//String array for storing database environment variables
		String[] credentials = System.getenv("DatabaseProperties").split(";");
		//Attempt to retrieve system environment variables for database connection, if exception occurs, handle 
		//gracefully
		try
		{
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
			}
			catch(Exception caughtException)
			{
				caughtException.printStackTrace();
			}
			
			//Using values stored in system environment variables, establish connection to database
			connectionVariable = DriverManager.getConnection(credentials[0], credentials[1], credentials[2]);
			//Return database connection
			return connectionVariable;
		}
		//If connection attmept was not successful, print stackTrace
		catch(SQLException caughtException)
		{
			caughtException.printStackTrace();
		}
		//Upon successful connection, return database connection
		return connectionVariable;
	}
}
