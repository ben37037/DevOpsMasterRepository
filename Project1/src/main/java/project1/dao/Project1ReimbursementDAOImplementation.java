package project1.dao;

import static files.CloseStreams.close;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import files.ConnectionUtility;
import project1.beans.Employee;
import project1.beans.Reimbursements;
import project1.beans.ReimbursementsWithNames;

public class Project1ReimbursementDAOImplementation implements Project1ReimbursementDAO
{
	PreparedStatement statement = null;
	Logger logger = Logger.getLogger(Project1ReimbursementDAOImplementation.class);
	
	public Reimbursements selectReimbursementsById(Integer idIn)
	{
		Statement statement = null;
		ResultSet resultSet = null;
		Reimbursements tempReimbursement = null;
		try(Connection connectionVariable = ConnectionUtility.getConnection())
		{
			statement = connectionVariable.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM ersReimbursement WHERE reimbursementId=" + (idIn));
			while(resultSet.next())
			{
				tempReimbursement = new Reimbursements(resultSet.getInt(1), 
											resultSet.getDouble(2), 
											resultSet.getString(3),
											resultSet.getString(4),
											resultSet.getString(5), 
											resultSet.getInt(7),
											resultSet.getInt(8),
											resultSet.getInt(9),
											resultSet.getInt(10));
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
		return tempReimbursement;
	}
	
	public Reimbursements seletReimbursementsByDescription(String descriptionIn)
	{
		Statement statement = null;
		ResultSet resultSet = null;
		Reimbursements tempReimbursement = null;
		try(Connection connectionVariable = ConnectionUtility.getConnection())
		{
			statement = connectionVariable.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM ersReimbursement WHERE reimbursementDescription=" + (descriptionIn));
			while(resultSet.next())
			{
				tempReimbursement = new Reimbursements(resultSet.getInt(1), 
											resultSet.getDouble(2), 
											resultSet.getString(3),
											resultSet.getString(4),
											resultSet.getString(5), 
											resultSet.getBlob(6),
											resultSet.getInt(7),
											resultSet.getInt(8),
											resultSet.getInt(9),
											resultSet.getInt(10));
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
		return tempReimbursement;
	}
	
	public Boolean addReimbursement(HttpServletRequest requestIn, HttpServletResponse responseIn)
	{
		try(Connection connectionVariable = ConnectionUtility.getConnection())
		{
			Cookie[] usernameCookie = requestIn.getCookies();
			Employee tempEmp = new Project1EmployeeDAOImplementation().selectEmployeeByUsername(usernameCookie[0].getValue());
			String reimbursementTypeText = "";
			Integer reimbursementType;
			switch(reimbursementTypeText)
			{
				case "Lodging":
					reimbursementType = 1;
					break;
				case "Travel":
					reimbursementType = 2;
					break;
				case "Food":
					reimbursementType = 3;
					break;
				case "Other":
					reimbursementType = 4;
				default:
					reimbursementType = 4;	
			}
			statement = connectionVariable.prepareStatement("INSERT INTO ersReimbursement VALUES(NULL,?,SYSDATE,NULL,?,NULL,?,null,?,?)");
			statement.setDouble(1, Double.parseDouble(requestIn.getParameter("reimbursementAmount")));
			statement.setString(2, requestIn.getParameter("reimbursementDescription"));
			//statement.setBlob(3, requestIn.getInputStream());
			statement.setInt(4, tempEmp.getUserId());
			statement.setInt(5, 1);
			statement.setInt(6, reimbursementType);
			
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
	
	public List<ReimbursementsWithNames> retrieveAllReimbursementsWithNames()
	{
		Statement statement = null;
		ResultSet resultSet = null;
		List<ReimbursementsWithNames> returnList = new ArrayList();
		try(Connection connectionVariable = ConnectionUtility.getConnection())
		{
			statement = connectionVariable.createStatement();
			resultSet = statement.executeQuery("SELECT ersReimbursement.reimbursementId, ersReimbursement.reimbursementAmount, \r\n" + 
					"    ersReimbursement.reimbursementSubmitted, ersReimbursement.reimbursementResolved, \r\n" + 
					"    ersReimbursement.reimbursementDescription, ersReimbursement.reimbursementReceipt, \r\n" + 
					"    ersReimbursement.reimbursementResolver, ersReimbursement.reimbursementStatusId, \r\n" + 
					"    ersReimbursement.reimbursementTypeId, ersUsers.ersUserName FROM ersReimbursement, ersUsers \r\n" + 
					"    WHERE reimbursementAuthor = ersUsers.ersUserId");
			while(resultSet.next())
			{
				returnList.add(new ReimbursementsWithNames(resultSet.getInt(1),
											resultSet.getDouble(2),
											resultSet.getString(3),
											resultSet.getString(4),
											resultSet.getString(5),
											resultSet.getInt(7),
											resultSet.getInt(8),
											resultSet.getInt(9),
											resultSet.getString(10)));
			}
		}
		catch(Exception caughtException)
		{
			logger.info(caughtException.getMessage());
			caughtException.printStackTrace();
		}
		finally
		{
			close(resultSet);
			close(statement);
		}
		return returnList;
	}
	
	public List<Reimbursements> retrieveAllReimbursements()
	{
		Statement statement = null;
		ResultSet resultSet = null;
		List<Reimbursements> reimbursementList = new ArrayList();
		try(Connection connectionVariable = ConnectionUtility.getConnection())
		{
			statement = connectionVariable.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM ersReimbursement");
			while(resultSet.next())
			{
				reimbursementList.add(new Reimbursements(resultSet.getInt(1),
											resultSet.getDouble(2),
											resultSet.getString(3),
											resultSet.getString(4),
											resultSet.getString(5),
											//resultSet.getBlob(6),
											resultSet.getInt(7),
											resultSet.getInt(8),
											resultSet.getInt(9),
											resultSet.getInt(10)));
			}
		}
		catch(Exception caughtException)
		{
			logger.info(caughtException.getMessage());
			caughtException.printStackTrace();
		}
		finally
		{
			close(resultSet);
			close(statement);
		}
		return reimbursementList;
	}
	
	public List<Reimbursements> retrieveMyReimbursements(HttpServletRequest requestIn, HttpServletResponse responseIn) throws IOException, ServletException
	{
		Statement statement = null;
		ResultSet resultSet = null;
		Employee tempEmp = new Project1EmployeeDAOImplementation().selectEmployeeByUsername(requestIn.getParameter("username"));
		logger.info("The value of username is: " + tempEmp.getUserUsername());
		List<Reimbursements> reimbursementList = new ArrayList();
		try(Connection connectionVariable = ConnectionUtility.getConnection())
		{
			statement = connectionVariable.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM ersReimbursement WHERE reimbursementAuthor=" + tempEmp.getUserId());
			while(resultSet.next())
			{
				reimbursementList.add(new Reimbursements(resultSet.getInt(1),
											resultSet.getDouble(2),
											resultSet.getString(3),
											resultSet.getString(4),
											resultSet.getString(5),
											//resultSet.getBlob(6),
											resultSet.getInt(7),
											resultSet.getInt(8),
											resultSet.getInt(9),
											resultSet.getInt(10)));
			}
		}
		catch(Exception caughtException)
		{
			logger.info(caughtException.getMessage());
			caughtException.printStackTrace();
		}
		finally
		{
			close(resultSet);
			close(statement);
		}
		return reimbursementList;
	}
	
	public Boolean updateReimbursementStatusById(Integer idIn, Integer statusIn)
	{
		try(Connection connectionVariable = ConnectionUtility.getConnection())
		{
			statement = connectionVariable.prepareStatement("UPDATE ersReimbursement SET reimbursementResolved=SYSDATE, " +
															"reimbursementStatusId=? WHERE reimbursementId=?");
			statement.setInt(1, statusIn);
			statement.setInt(2, idIn);
			
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
