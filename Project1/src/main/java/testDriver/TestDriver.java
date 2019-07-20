package testDriver;

import static files.CloseStreams.close;
import project1.dao.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import org.apache.log4j.Logger;
import files.ConnectionUtility;
import testDriver.BLOBPractice;
import project1.beans.*;

//This class is STRICTLY for testing database connectivity and passing data back and forth from the database
public class TestDriver 
{

	public static void main(String[] args) 
	{
		Logger logger = Logger.getLogger(TestDriver.class);
		logger.info(new BLOBPractice().retrieveReimbursements());
		Integer counter = 21;
		for(int i = 0; i < 300; i++)
		{
			new BLOBPractice().insertReimbursement(counter);
			logger.info("Reimbusement inserted!");
		}
//		Project1EmployeeDAOImplementation empDao = new Project1EmployeeDAOImplementation();
//		Project1ReimbursementDAOImplementation reimDao = new Project1ReimbursementDAOImplementation();
//		Employee tempEmp;
//		
//		for(Integer i = 0; i < 20; i++)
//		{
//			tempEmp = new Employee("Ben" + i.toString(), "benny", "BennyBooBoo", "Hunt", "asdf@asdf" + i.toString(), 1);
//			
//			empDao.addUser(tempEmp);
//		}
//		
//		List<Employee> empList = empDao.retrieveAllEmployees();
//		
//		tempEmp = empList.get(0);
//		tempEmp.setUserEmail("shit");
//		
//		empDao.updateEmployee(tempEmp);
//		
//		empList = empDao.retrieveAllEmployees();
//				
//		for(Employee empIn: empList)
//		{
//			System.out.println(empIn);
//		}
//			
//		for(Integer i = 0; i < 20; i++)
//		{
//			Reimbursements tempReimb = new Reimbursements(null, 1240.49, "SYSDATE", null, "Just Because!" + i.toString(), null, 1, 1, 1, 4);
//			
//			reimDao.addReimbursement(tempReimb);
//		}
//		
//		List<Reimbursements> reimList = reimDao.retrieveAllReimbursements();
//				
//		for(Reimbursements reimb: reimList)
//		{
//			if((reimList.indexOf(reimb) % 2) == 0)
//			{
//				reimDao.updateReimbursementStatusById(reimb.getReimbursementId(), 3);
//			}
//			System.out.println(reimb);
//		}
//		
//		PreparedStatement statement = null;
//		Statement statement1 = null;
//		ResultSet resultSet = null;
//		String matcherVariable = new String();
//		String stringCompare = new String();
//		String passwordText = "";
//		Scanner scannerVariable = new Scanner(System.in);
//		System.out.println("Please enter a password: ");
//		passwordText = scannerVariable.nextLine();
//		passwordText = hashThePassword(passwordText.toCharArray());
//		
//		try(Connection connectionVariable = ConnectionUtility.getConnection())
//		{
//			statement = connectionVariable.prepareStatement("INSERT INTO blah VALUES(?)");
//			statement.setString(1, passwordText);
//			statement.execute();
//			statement = connectionVariable.prepareStatement("COMMIT");
//			statement.execute();
//			
//			statement1 = connectionVariable.createStatement();
//			resultSet = statement1.executeQuery("SELECT * FROM blah");
//			while(resultSet.next())
//			{
//				matcherVariable = resultSet.getString(1);
//			}
//			
//			
//		}
//		catch(Exception caughtException)
//		{
//			
//		}
//		finally
//		{
//			close(statement);
//		}
//		
//		try(Connection connectionVariable = ConnectionUtility.getConnection())
//		{
//			statement = connectionVariable.prepareStatement("INSERT INTO blah VALUES(?)");
//			statement.setString(1, passwordText);
//			statement.execute();
//			statement = connectionVariable.prepareStatement("COMMIT");
//			statement.execute();
//			
//			statement1 = connectionVariable.createStatement();
//			resultSet = statement1.executeQuery("SELECT * FROM blah");
//			while(resultSet.next())
//			{
//				matcherVariable = resultSet.getString(1);
//			}
//			
//			
//		}
//		catch(Exception caughtException)
//		{
//			
//		}
//		finally
//		{
//			close(statement);
//		}
//		
//		System.out.println("Please enter the password again: ");
//		stringCompare = scannerVariable.nextLine();
//		stringCompare = hashThePassword(stringCompare.toCharArray());
//		
//		System.out.println("Strings match: " + stringCompare.equals(matcherVariable));
//	}
//	
//	public static String hashThePassword(char[] passIn)
//	{
//		String returnVariable = "";
//		for(char i: passIn)
//		{
//			returnVariable += (7 * 31 + i);
//		}
//		return returnVariable;
	}

}
