package project1.dao;

import static files.CloseStreams.*;

import files.ConnectionUtility;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import project1.beans.Employee;

public class Project1EmployeeDAOImplementation implements Project1EmployeeDAO
{
	PreparedStatement statement = null;
	
	public Employee selectEmployeeById(Integer idIn)
	{
		Statement statement = null;
		ResultSet resultSet = null;
		Employee tempEmployee = null;
		try(Connection connectionVariable = ConnectionUtility.getConnection())
		{
			statement = connectionVariable.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM ersUsers WHERE ersUserId=" + (idIn));
			while(resultSet.next())
			{
				tempEmployee = new Employee(resultSet.getInt(1), 
											resultSet.getString(2), 
											resultSet.getString(3),
											resultSet.getString(4),
											resultSet.getString(5), 
											resultSet.getString(6),
											resultSet.getInt(7));
			}
		}
		catch(Exception caughtException)
		{
			caughtException.printStackTrace();
		}
		finally
		{
			close(resultSet);
			close(statement);
		}
		return tempEmployee;
	}
	public Employee selectEmployeeByUsername(String usernameIn)
	{
		Statement statement = null;
		ResultSet resultSet = null;
		Employee tempEmployee = null;
		try(Connection connectionVariable = ConnectionUtility.getConnection())
		{
			statement = connectionVariable.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM ersUsers WHERE ersUsername ='" + usernameIn + "'");
			while(resultSet.next())
			{
				tempEmployee = new Employee(resultSet.getInt(1), 
											resultSet.getString(2), 
											resultSet.getString(3),
											resultSet.getString(4),
											resultSet.getString(5), 
											resultSet.getString(6),
											resultSet.getInt(7));
			}
		}
		catch(Exception caughtException)
		{
			caughtException.printStackTrace();
		}
		finally
		{
			close(resultSet);
			close(statement);
		}
		return tempEmployee;
	}
	
	public Employee selectEmployeeByEmail(String emailIn)
	{
		Statement statement = null;
		ResultSet resultSet = null;
		Employee tempEmployee = null;
		try(Connection connectionVariable = ConnectionUtility.getConnection())
		{
			statement = connectionVariable.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM ersUsers WHERE userEmail ='" + emailIn + "'");
			while(resultSet.next())
			{
				tempEmployee = new Employee(resultSet.getInt(1), 
											resultSet.getString(2), 
											resultSet.getString(3),
											resultSet.getString(4),
											resultSet.getString(5), 
											resultSet.getString(6),
											resultSet.getInt(7));
			}
		}
		catch(Exception caughtException)
		{
			caughtException.printStackTrace();
		}
		finally
		{
			close(resultSet);
			close(statement);
		}
		return tempEmployee;
	}
	
	public Boolean addUser(Employee employeeIn)
	{
		try(Connection connectionVariable = ConnectionUtility.getConnection())
		{
			List<Employee> employeeList = retrieveAllEmployees();
			for(Employee tempEmp: employeeList)
			{
				if(employeeIn.getUserUsername().equals(tempEmp.getUserUsername()) | employeeIn.getUserEmail().equals(tempEmp.getUserEmail()))
				{
					return false;
				}
			}
			
			System.out.println("The value of employee is: " + employeeIn.toString());
			
			statement = connectionVariable.prepareStatement("INSERT INTO ersUsers VALUES(null,?,?,?,?,?,?)");
			statement.setString(1, employeeIn.getUserUsername());
			statement.setString(2, employeeIn.getUserPassword());
			statement.setString(3, employeeIn.getUserFirstName());
			statement.setString(4, employeeIn.getUserLastName());
			statement.setString(5, employeeIn.getUserEmail());
			statement.setInt(6, employeeIn.getUserRoleId());
			statement.executeUpdate();
			statement = connectionVariable.prepareStatement("COMMIT");
			statement.execute();
		}
		catch(Exception caughtException)
		{
			caughtException.printStackTrace();
		}
		return true;
	}
	public List<Employee> retrieveAllEmployees()
	{
		Statement statement = null;
		ResultSet resultSet = null;
		List<Employee> employees = new ArrayList();
		try(Connection connectionVariable = ConnectionUtility.getConnection())
		{
			statement = connectionVariable.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM ersUsers");
			while(resultSet.next())
			{
				employees.add(new Employee(resultSet.getInt(1),
											resultSet.getString(2),
											resultSet.getString(3),
											resultSet.getString(4),
											resultSet.getString(5),
											resultSet.getString(6),
											resultSet.getInt(7)));
			}
		}
		catch(Exception caughtException)
		{
			caughtException.printStackTrace();
		}
		finally
		{
			close(resultSet);
			close(statement);
		}
		return employees;
	}
	
	public Boolean updateEmployee(Employee employeeIn)
	{
		try(Connection connectionVariable = ConnectionUtility.getConnection())
		{
			statement = connectionVariable.prepareStatement("UPDATE ersUsers set ersUserName=?, ersPassword=?, userFirstName=?, " +
															"userLastName=?, userEmail=?, userRoleId=? WHERE ersUserId=?");
			statement.setString(1, employeeIn.getUserUsername());
			statement.setString(2, employeeIn.getUserPassword());
			statement.setString(3, employeeIn.getUserFirstName());
			statement.setString(4, employeeIn.getUserLastName());
			statement.setString(5, employeeIn.getUserEmail());
			statement.setInt(6, employeeIn.getUserRoleId());
			statement.setInt(7, employeeIn.getUserId());
			statement.execute();
			statement = connectionVariable.prepareStatement("COMMIT");
			statement.execute();
		}
		catch(Exception caughtException)
		{
			caughtException.printStackTrace();
		}
		return true;
	}
}
