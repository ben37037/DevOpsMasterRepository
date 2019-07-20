package project1.dao;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import project1.beans.Reimbursements;
import project1.beans.ReimbursementsWithNames;
import project1.dao.Project1ReimbursementDAO;

public class ReimbursementService 
{
	private Project1ReimbursementDAO reimbDao = null;
	private static Logger logger = Logger.getLogger(EmployeeService.class);
	
	public Boolean insertReimbursement(HttpServletRequest requestIn, HttpServletResponse responseIn) throws IOException, ServletException 
	{
		logger.info("Adding a Reimbursement");
		reimbDao = new Project1ReimbursementDAOImplementation();
		return reimbDao.addReimbursement(requestIn, responseIn);
	}
	
	public List<Reimbursements> showAllReimbursements()
	{
		logger.info("Showing all Reimbursements");
		reimbDao = new Project1ReimbursementDAOImplementation();
		return reimbDao.retrieveAllReimbursements();
	}
	public List<Reimbursements> showMyReimbursements(HttpServletRequest requestIn, HttpServletResponse responseIn) throws IOException, ServletException
	{
		logger.info("Showing 'My' Reimbursements");
		reimbDao = new Project1ReimbursementDAOImplementation();
		return reimbDao.retrieveMyReimbursements(requestIn, responseIn);
	}
	public List<ReimbursementsWithNames> getAllReimbursementsWithNames(HttpServletRequest requestIn, HttpServletResponse responseIn) throws IOException, ServletException
	{
		logger.info("Retrieving all Reimbursements with names");
		reimbDao = new Project1ReimbursementDAOImplementation();
		return reimbDao.retrieveAllReimbursementsWithNames();
	}
}
