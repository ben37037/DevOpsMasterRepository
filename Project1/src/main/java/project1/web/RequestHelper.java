package project1.web;

import java.io.IOException;
import java.io.PrintWriter;
import project1.dao.EmployeeService;
import project1.dao.ReimbursementService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import com.fasterxml.jackson.databind.ObjectMapper;

//import daoBenHunt.HTMLTemplate;
//import daoBenHunt.OwnerService;
//import daoBenHunt.PolkamansService;

@MultipartConfig
public class RequestHelper 
{
	private static Logger logger = Logger.getLogger(RequestHelper.class);
	private static ObjectMapper objectMapper = new ObjectMapper();
	private static RequestDispatcher requestDispatcher = null;
	
	public static void processGet(HttpServletRequest requestIn, HttpServletResponse responseIn) throws
	IOException, ServletException
	{
		logger.info("In the Request Helper Class, the URI is: " + requestIn.getRequestURI());
		final String URI = requestIn.getRequestURI().replace("/Project1/main", "");
			
		logger.info("Url Pattern: " + URI);
		
		switch(URI)
		{
			case "/allEmployees": 
				responseIn.setContentType("application/json");
				PrintWriter out = responseIn.getWriter();
				out.println(objectMapper.writeValueAsString(new EmployeeService().selectAllEmployees()));
				return;
			case "/seeAllReimbursements":
				responseIn.setContentType("application/json");
				out = responseIn.getWriter();
				out.println(objectMapper.writeValueAsString(new ReimbursementService().getAllReimbursementsWithNames(requestIn, responseIn)));
				return;
			case "/seeMyReimbursements":
				Cookie[] trackingCookie = requestIn.getCookies();
				logger.info("The value of username is: " + requestIn.getParameter("username"));
				responseIn.addCookie(trackingCookie[0]);
				responseIn.setContentType("application/json");
				out = responseIn.getWriter(); 
				requestIn.setAttribute("username", trackingCookie[0].getValue());
				logger.info("The value of requestIn.username is: " + requestIn.getParameter("username"));
				for(Cookie current: trackingCookie)
				{
					logger.info("The value of the current cookie is: " + current.getValue());
				}
				out.println(objectMapper.writeValueAsString(new ReimbursementService().showMyReimbursements(requestIn, responseIn)));
				logger.info("The value of seeMyReimbursments is: " + new ReimbursementService().showMyReimbursements(requestIn, responseIn));
				return; 
			case "/logOut":
				new EmployeeService().invalidateUser(requestIn, responseIn);
				requestDispatcher = requestIn.getRequestDispatcher("/index.html");
				requestDispatcher.forward(requestIn, responseIn);
				logger.info(requestIn.getParameter("username") + " logged out, returning to index.html");
				return;
			case "/blah.html":
				requestDispatcher = requestIn.getRequestDispatcher("/blah.html");
				requestDispatcher.forward(requestIn, responseIn);
			default:
				requestDispatcher = requestIn.getRequestDispatcher("/index.html");
				requestDispatcher.forward(requestIn, responseIn);
				logger.info("Defaulted, returning to index.html");
				return;
		}		
	}
	
	public static void processPost(HttpServletRequest requestIn, HttpServletResponse responseIn) throws
	IOException, ServletException 
	{
		logger.info("In the Request Helper Class, the URI is: " + requestIn.getRequestURI());
		final String URI = requestIn.getRequestURI().replace("/Project1/main", "");
		logger.info("Url Pattern: " + URI);
		
		switch(URI)
		{
			case "/allEmployees": 
				responseIn.setContentType("application/json");
				PrintWriter out = responseIn.getWriter();
				out.println(objectMapper.writeValueAsString(new EmployeeService().selectAllEmployees()));
				return;
				
			case "/createUser": 
				try
				{
					String passwordVariable = "";
					if(requestIn.getParameter("password1").equals(requestIn.getParameter("password2")))
					{
						passwordVariable = requestIn.getParameter("password1");
						passwordVariable = EmployeeService.hashThePassword(passwordVariable.toCharArray());
					}
					int userRoleId;
					if(requestIn.getParameter("name").contains("Ben"))
					{
						userRoleId = 2;
					}
					else
					{
						userRoleId = 1;
					}
					
					if(new EmployeeService().registerEmployee(requestIn.getParameter("username"), passwordVariable, 
															requestIn.getParameter("name"), requestIn.getParameter("email"), 
															userRoleId))
					{
						String username = requestIn.getParameter("username");
						HttpSession session = requestIn.getSession();
						session.setAttribute("username", username);
						RequestDispatcher requestDispatcher = requestIn.getRequestDispatcher("/index.html");
						requestDispatcher.forward(requestIn, responseIn);
						logger.info("Employee " + requestIn.getParameter("name") + " Created");
						return;
					}
					else
					{
						System.out.println("Unsuccessful!!!!!!!");
						return;
					}
				}
				catch(Exception caughtException)
				{
					return;
				}
			case "/login":
				logger.info("Logging in user " + requestIn.getParameter("username"));
				new EmployeeService().confirmUserLogin(requestIn, responseIn);
				new EmployeeService().logInUser(requestIn, responseIn);
				if(new EmployeeService().employeeIsManager(requestIn, responseIn))
				{
					RequestDispatcher requestDispatcher = requestIn.getRequestDispatcher("/manager.html");
					requestDispatcher.forward(requestIn, responseIn);
					logger.info("Manager " + requestIn.getParameter("username") + " logged in successfully!");
					return;
				}
				else
				{
					RequestDispatcher requestDispatcher = requestIn.getRequestDispatcher("/employee.html");
					requestDispatcher.forward(requestIn, responseIn);
					logger.info("Employee " + requestIn.getParameter("username") + " logged in successfully!");
					return;
				}
			case "/main/login":
				logger.info("Logging in user " + requestIn.getParameter("username"));
				new EmployeeService().confirmUserLogin(requestIn, responseIn);
				new EmployeeService().logInUser(requestIn, responseIn);
				if(new EmployeeService().employeeIsManager(requestIn, responseIn))
				{
					RequestDispatcher requestDispatcher = requestIn.getRequestDispatcher("/manager.html");
					requestDispatcher.forward(requestIn, responseIn);
					logger.info("Manager " + requestIn.getParameter("username") + " logged in successfully!");
					return;
				}
				else
				{
					RequestDispatcher requestDispatcher = requestIn.getRequestDispatcher("/employee.html");
					requestDispatcher.forward(requestIn, responseIn);
					logger.info("Employee " + requestIn.getParameter("username") + " logged in successfully!");
					return;
				}
		case "/addReimbursement":
				new ReimbursementService().insertReimbursement(requestIn, responseIn);
				if(new EmployeeService().employeeIsManager(requestIn, responseIn))
				{
					RequestDispatcher requestDispatcher = requestIn.getRequestDispatcher("/manager.html");
					requestDispatcher.forward(requestIn, responseIn);
					logger.info("Returning to Manager Page!");
					return;
				}
				else
				{
					RequestDispatcher requestDispatcher = requestIn.getRequestDispatcher("/employee.html");
					requestDispatcher.forward(requestIn, responseIn);
					logger.info("Returning to Employee Page!");
					return;
				}
		case "/goHome":
			logger.info("Returning to " + requestIn.getParameter("username") + "'s home page");
			new EmployeeService().confirmUserLogin(requestIn, responseIn);
			if(new EmployeeService().employeeIsManager(requestIn, responseIn))
			{
				RequestDispatcher requestDispatcher = requestIn.getRequestDispatcher("/manager.html");
				requestDispatcher.forward(requestIn, responseIn);
				logger.info("Manager " + requestIn.getParameter("username") + " navigated successfully!");
				return;
			}
			else
			{
				RequestDispatcher requestDispatcher = requestIn.getRequestDispatcher("/employee.html");
				requestDispatcher.forward(requestIn, responseIn);
				logger.info("Employee " + requestIn.getParameter("username") + " navigated successfully!");
				return;
			}
		default:
				requestDispatcher = requestIn.getRequestDispatcher("/index.html");
				requestDispatcher.forward(requestIn, responseIn);
				logger.info("Returning to index.html");
				return;
			
		}		
	}
	
	
}
