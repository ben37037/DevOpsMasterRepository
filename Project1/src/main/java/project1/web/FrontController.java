package project1.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class FrontController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(FrontController.class);
	
    public FrontController() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws 
	ServletException, IOException 
	{
		logger.debug("In front controller servlet. URI is: " + request.getRequestURI());
		RequestHelper.processGet(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws 
	ServletException, IOException 
	{
		logger.debug("In front controller servlet. URI is: " + request.getRequestURI());
		RequestHelper.processPost(request, response);
	}

}
