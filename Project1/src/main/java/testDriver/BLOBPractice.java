package testDriver;

import static files.CloseStreams.*;

import files.ConnectionUtility;
import java.io.*;
import java.sql.*;

public class BLOBPractice 
{
	PreparedStatement statement = null;
	
	public Boolean insertReimbursement(Integer integerIn)
	{
		try(Connection connectionVariable = ConnectionUtility.getConnection())
		{
			statement = connectionVariable.prepareStatement("INSERT INTO ersReimbursement VALUES(null,12000.00,SYSDATE,null,?,?,?,null,?,?)");
			//statement.setInt(1, null);
			statement.setString(1, "Vacation");
			FileInputStream fileInputVariable = new FileInputStream("C:/Users/Ben/Desktop/190617jta/BenHuntWorkspace/PracticeProject/src/practiceProject/BenHunt/Metroid Fusion Map.gif");  
			statement.setBinaryStream(2, fileInputVariable, fileInputVariable.available());
			statement.setInt(3, integerIn);
			statement.setInt(4, 1);
			statement.setInt(5, 2);
              
			int numberOfRecords = statement.executeUpdate();  
			System.out.println(numberOfRecords + " records affected");    
			
		}
		catch(Exception caughtException)
		{
			System.out.println(caughtException.getMessage());
			return null;
		}
		finally
		{
			close(statement);
		}
		return true;
	}
	
	public Boolean retrieveReimbursements()
	{
		Blob receiptPicture = null;
		FileOutputStream fileOutput = null; 
		Integer reimbursementId;
		Double reimbursementAmount;
		String submissionDate = "";
		String resolutionDate = "";
		String reimbursementDescription = "";
		Integer reimbursementAuthor;
		Integer reimbursementResolver;
		Integer reimbursementStatusId;
		Integer reimbursementTypeId;
		
		try(Connection connectionVariable = ConnectionUtility.getConnection())
		{  
			statement = connectionVariable.prepareStatement("SELECT * FROM ersReimbursement");  
			ResultSet resultSet = statement.executeQuery();  
			while(resultSet.next())
			{
				reimbursementId = resultSet.getInt(1);
				reimbursementAmount = resultSet.getDouble(2);
				submissionDate = resultSet.getString(3);
				resolutionDate = resultSet.getString(4);
				reimbursementDescription = resultSet.getString(5);
//				receiptPicture = resultSet.getBlob(6);  
//				byte byteArray[] = receiptPicture.getBytes(1,(int)receiptPicture.length());
				reimbursementAuthor = resultSet.getInt(7);
				reimbursementResolver = resultSet.getInt(8);
				reimbursementStatusId = resultSet.getInt(9);
				reimbursementTypeId = resultSet.getInt(10);
							  
//				fileOutput = new FileOutputStream("C:\\Users\\Ben\\Desktop\\190617jta\\BenHuntWorkspace\\Project1\\src\\main\\java\\files\\receiptId" + 
//													reimbursementId);  
//				fileOutput.write(byteArray);  
				System.out.println(resultSet.toString());
			}  
		}
		catch (Exception caughtException) 
		{
			System.out.println("Picture not retrieved.");
			System.out.println(caughtException.getMessage());
			return null;  
		}
		finally
		{
			close(statement);
		}
		System.out.println("It is done!");
		return true;
	}
}