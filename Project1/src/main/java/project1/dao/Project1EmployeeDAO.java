package project1.dao;

import project1.beans.Employee;
import java.util.List;

public interface Project1EmployeeDAO 
{
	public Employee selectEmployeeById(Integer idIn);
	public Employee selectEmployeeByUsername(String usernameIn);
	public Boolean addUser(Employee employeeIn);
	public List<Employee> retrieveAllEmployees();
	public Boolean updateEmployee(Employee employeeIn);
}
