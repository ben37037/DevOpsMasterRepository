package project1.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

//import daoBenHunt.HTMLTemplate;
//import daoBenHunt.Owner;
//import daoBenHunt.OwnerDao;
//import daoBenHunt.OwnerDaoImpl;
//import daoBenHunt.OwnerService;
import project1.beans.Employee;

public class EmployeeService 
{
	private Project1EmployeeDAO empDao = null;
	private static Logger logger = Logger.getLogger(EmployeeService.class);
	
	public boolean confirmUserLogin(HttpServletRequest requestIn, HttpServletResponse responseIn) throws
	IOException, ServletException  
	{
		logger.info("Confirming user log in....");
		Project1EmployeeDAO empDao = new Project1EmployeeDAOImplementation();
		Employee employee = null;
		
		if((employee = empDao.selectEmployeeByUsername(requestIn.getParameter("username"))) !=null)
		{
			logger.info("Checking to see if password is correct");
			if(employee.getUserPassword().equals(requestIn.getParameter("password"))) 
			{
				logger.info("Password is correct.");
				logger.info("User log in confirmed!");
				return true;
			}
		}
		return false;
	}
	
	public boolean usernameExists(String usernameIn)
	{
		logger.info("Checking to see if username exists....");
		if(new Project1EmployeeDAOImplementation().selectEmployeeByUsername(usernameIn)!=null) 
		{
			logger.info("Username exists!");
			return true;
		}
		logger.info("Username does not exist.");
		return false;
	}
	
	public boolean emailExists(String emailIn)
	{
		logger.info("Checking to see if email exists....");
		if(new Project1EmployeeDAOImplementation().selectEmployeeByEmail(emailIn)!=null) 
		{
			logger.info("Email exists!");
			return true;
		}
		logger.info("Email does not exist.");
		return false;
	}
	
	public boolean registerEmployee(String usernameIn, String passwordIn, String nameIn, String emailIn, Integer userRoleIn)
	{
		logger.info("Attempting to create account");
		if(new Project1EmployeeDAOImplementation().addUser(new Employee(usernameIn, passwordIn, nameIn.split(" ")[0], nameIn.split(" ")[1], 
																		emailIn, userRoleIn)))
		{
			logger.info("Account successfully created");
			return true;
		}
		logger.info("Account creation was not successful."); 
		return false;
	}
	
	public Boolean employeeIsManager(HttpServletRequest requestIn, HttpServletResponse responseIn) throws 	IOException, ServletException
	{
		logger.info("Checking to see if employee is manager....");
		try
		{
			if(empDao.selectEmployeeByUsername(requestIn.getParameter("username")).getUserRoleId() == 2)
			{
				logger.info("Employee IS manager");
				return true;
			}
			else
			{
				logger.info("Employee is not manager");
				return false;
			}
		}
		catch(Exception caughtException)
		{
			logger.info("Something went wrong: " + caughtException.getMessage());
			return null;
		}
	}
	
	public void invalidateUser(HttpServletRequest requestIn, HttpServletResponse responseIn) throws
	IOException, ServletException
	{
		logger.info("Invalidating user");
		RequestDispatcher dataDispatch = requestIn.getRequestDispatcher("error.jsp");
		HttpSession session = requestIn.getSession();
		 String directedPage = "";
		    try 
		    {
	
		    } 
		    catch (Exception caughtExeption) 
		    {
		    	logger.info("User invalidation failed!");
		    	directedPage = "error.jsp";
		    } 
		    finally 
		    {
		    	logger.info("User invalidation successful");
		    	directedPage = "index.html";
		    }
		
		if(session != null)
		{
			logger.trace((String)session.getAttribute("username") + ": has logged out!");
			session.invalidate();
			logger.info("Session invalidated");
			dataDispatch = requestIn.getRequestDispatcher(directedPage);
			dataDispatch.forward(requestIn, responseIn);
			responseIn.sendRedirect("Project1/main");
		}
	}
	
	public void logInUser(HttpServletRequest requestIn, HttpServletResponse responseIn) throws
	IOException, ServletException
	{
		Employee tempEmp = null;
		logger.info("Created tempEmp Employee objectg and set to null.");
		try
		{
			logger.info("Attempting to create Employee object for log in.");
			tempEmp = new Project1EmployeeDAOImplementation().selectEmployeeByUsername(requestIn.getParameter("username"));
			logger.info("The value of tempEmp is: " + tempEmp.toString());
			new EmployeeService().usernameExists(requestIn.getParameter("username"));
			new EmployeeService().emailExists(tempEmp.getUserEmail());
		}
		catch(Exception caughtException)
		{
			logger.info("Employee creation attempt failed\r" + caughtException.getMessage());
			return;
		}
		String username = requestIn.getParameter("username");
		String password = requestIn.getParameter("password");
		password = hashThePassword(password.toCharArray());
		Cookie loginCookie = new Cookie("username", username);
		responseIn.addCookie(loginCookie);
		
		logger.info("Login instantiated with username for Employee: " + username);
		if(tempEmp.getUserPassword().equals(password))
		{
			if(tempEmp.getUserRoleId() == 2)
			{
				//new EmployeeService().logInUser(requestIn, responseIn);
				HttpSession session = requestIn.getSession();
				session.setAttribute("username", username);
				RequestDispatcher requestDispatcher = requestIn.getRequestDispatcher("/manager.html");
				requestDispatcher.forward(requestIn, responseIn);
				logger.info("Manager " + username + " logged in successfully!");
				return;
			}
			else
			{
				//new EmployeeService().logInUser(requestIn, responseIn);
				HttpSession session = requestIn.getSession();
				session.setAttribute("username", username);
				RequestDispatcher requestDispatcher = requestIn.getRequestDispatcher("/employee.html");
				requestDispatcher.forward(requestIn, responseIn);
				logger.info("Employee " + username + " logged in successfully!");
				return;
			}
		}
		else
		{
			PrintWriter out = HTMLTemplate.getHtmlOut(responseIn);
			out.println("<h3 style='color: red'>Denied!</h3>");
			return;
		}
	}

	
	public Boolean insertEmployee(Employee employeeIn )
	{
		empDao = new Project1EmployeeDAOImplementation();
		return empDao.addUser(employeeIn);
	}
	
	public List<Employee> selectAllEmployees()
	{
		empDao = new Project1EmployeeDAOImplementation();
		return empDao.retrieveAllEmployees();
	}
	
	public static String hashThePassword(char[] passIn)
	{
		String returnVariable = "";
		for(char i: passIn)
		{
			returnVariable += (7 * 31 + i);
		}
		return returnVariable;
	}
}
