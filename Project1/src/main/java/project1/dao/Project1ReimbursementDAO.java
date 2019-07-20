package project1.dao;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import project1.beans.Reimbursements;
import project1.beans.ReimbursementsWithNames;

public interface Project1ReimbursementDAO 
{
	public Reimbursements selectReimbursementsById(Integer idIn);
	public Reimbursements seletReimbursementsByDescription(String descriptionIn);
	public Boolean addReimbursement(HttpServletRequest requestIn, HttpServletResponse responseIn);
	public List<Reimbursements> retrieveAllReimbursements();
	public List<ReimbursementsWithNames> retrieveAllReimbursementsWithNames();
	public Boolean updateReimbursementStatusById(Integer idIn, Integer statusIn);
	public List<Reimbursements> retrieveMyReimbursements(HttpServletRequest requestIn, HttpServletResponse responseIn) throws IOException, ServletException;
}
