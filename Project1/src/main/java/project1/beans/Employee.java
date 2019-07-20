package project1.beans;

public class Employee 
{
	private Integer userId;
	private String userUsername;
	private String userPassword;
	private String userFirstName;
	private String userLastName;
	private String userEmail;
	private Integer userRoleId;
	
	public Employee(Employee employeeIn)
	{
		super();
		this.userId = employeeIn.userId;
		this.userUsername = employeeIn.userUsername;
		this.userPassword = employeeIn.userPassword;
		this.userFirstName = employeeIn.userFirstName;
		this.userLastName = employeeIn.userLastName;
		this.userEmail = employeeIn.userEmail;
		this.userRoleId = employeeIn.userRoleId;
	}
	
	
	public Employee(String userUsernameIn, String userPasswordIn, String userFirstNameIn, String userLastNameIn,
					String userEmailIn, Integer userRoleIdIn) 
	{
		super();
		this.userUsername = userUsernameIn;
		this.userPassword = userPasswordIn;
		this.userFirstName = userFirstNameIn;
		this.userLastName = userLastNameIn;
		this.userEmail = userEmailIn;
		this.userRoleId = userRoleIdIn;
	}
	
	


	public Employee(Integer userIdIn, String userUsernameIn, String userPasswordIn, String userFirstNameIn, 
			String userLastNameIn, String userEmailIn, Integer userRoleIdIn) 
	{
		super();
		this.userId = userIdIn;
		this.userUsername = userUsernameIn;
		this.userPassword = userPasswordIn;
		this.userFirstName = userFirstNameIn;
		this.userLastName = userLastNameIn;
		this.userEmail = userEmailIn;
		this.userRoleId = userRoleIdIn;
	}


	public Integer getUserId() 
	{
		return userId;
	}
	public void setUserId(Integer userIdIn) 
	{
		this.userId = userIdIn;
	}
	public String getUserUsername() 
	{
		return userUsername;
	}
	public void setUserUsername(String userUsernameIn) 
	{
		this.userUsername = userUsernameIn;
	}
	public String getUserPassword() 
	{
		return userPassword;
	}
	public void setUserPassword(String userPasswordIn) 
	{
		this.userPassword = userPasswordIn;
	}
	public String getUserFirstName() 
	{
		return userFirstName;
	}
	public void setUserFirstName(String userFirstNameIn) 
	{
		this.userFirstName = userFirstNameIn;
	}
	public String getUserLastName() 
	{
		return userLastName;
	}
	public void setUserLastName(String userLastNameIn) 
	{
		this.userLastName = userLastNameIn;
	}
	public String getUserEmail() 
	{
		return userEmail;
	}
	public void setUserEmail(String userEmailIn) 
	{
		this.userEmail = userEmailIn;
	}
	public Integer getUserRoleId() 
	{
		return userRoleId;
	}
	public void setUserRoleId(Integer userRoleIdIn) 
	{
		this.userRoleId = userRoleIdIn;
	}

	@Override
	public String toString() 
	{
		return "Employee [userId=" + userId + ", userUsername=" + userUsername + ", userPassword=" + userPassword + 
				", userFirstName=" + userFirstName + ", userLastName=" + userLastName + ", userEmail=" + userEmail + 
				", userRoleId=" + userRoleId + "]";
	}

	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		
		result = prime * result + ((userEmail == null) ? 0 : userEmail.hashCode());
		result = prime * result + ((userFirstName == null) ? 0 : userFirstName.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((userLastName == null) ? 0 : userLastName.hashCode());
		result = prime * result + ((userPassword == null) ? 0 : userPassword.hashCode());
		result = prime * result + ((userRoleId == null) ? 0 : userRoleId.hashCode());
		result = prime * result + ((userUsername == null) ? 0 : userUsername.hashCode());
		
		return result;
	}

	@Override
	public boolean equals(Object objectIn) 
	{
		if (this == objectIn)
			return true;
		
		if (objectIn == null)
			return false;
		
		if (getClass() != objectIn.getClass())
			return false;
		
		Employee other = (Employee) objectIn;
		if (userEmail == null) 
		{
			if (other.userEmail != null)
				return false;
		} 
		else if (!userEmail.equals(other.userEmail))
			return false;
		
		if (userFirstName == null) 
		{
			if (other.userFirstName != null)
				return false;
		}
		else if (!userFirstName.equals(other.userFirstName))
			return false;
		
		if (userId == null) 
		{
			if (other.userId != null)
				return false;
		}
		else if (!userId.equals(other.userId))
			return false;
		
		if (userLastName == null) 
		{
			if (other.userLastName != null)
				return false;
		}
		else if (!userLastName.equals(other.userLastName))
			return false;
		
		if (userPassword == null) 
		{
			if (other.userPassword != null)
				return false;
		}
		else if (!userPassword.equals(other.userPassword))
			return false;
		
		if (userRoleId == null) 
		{
			if (other.userRoleId != null)
				return false;
		}
		else if (!userRoleId.equals(other.userRoleId))
			return false;
		
		if (userUsername == null) 
		{
			if (other.userUsername != null)
				return false;
		}
		else if (!userUsername.equals(other.userUsername))
			return false;
		
		return true;
	}
	
	
}
