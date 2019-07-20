package project1.beans;

import java.sql.Blob;

public class Reimbursements 
{
	private Integer reimbursementId;
	private Double reimbursementAmount;
	private String reimbursementSubmissionDate;
	private String reimbursementResolutionDate;
	private String reimbursementDescription;
	private Blob reimbursementReceipt;
	private Integer reimbursementAuthorId;
	private Integer reimbursementResolverId;
	private Integer reimbursementStatusId;
	private Integer reimbursementTypeId;
	
	
	
	public Reimbursements(Integer reimbursementIdIn, Double reimbursementAmountIn, String reimbursementSubmissionDateIn,
			String reimbursementResolutionDateIn, String reimbursementDescriptionIn, Blob reimbursementReceiptIn,
			Integer reimbursementAuthorIdIn, Integer reimbursementResolverIdIn, Integer reimbursementStatusIdIn,
			Integer reimbursementTypeIdIn) 
	{
		super();
		this.reimbursementId = reimbursementIdIn;
		this.reimbursementAmount = reimbursementAmountIn;
		this.reimbursementSubmissionDate = reimbursementSubmissionDateIn;
		this.reimbursementResolutionDate = reimbursementResolutionDateIn;
		this.reimbursementDescription = reimbursementDescriptionIn;
		this.reimbursementReceipt = reimbursementReceiptIn;
		this.reimbursementAuthorId = reimbursementAuthorIdIn;
		this.reimbursementResolverId = reimbursementResolverIdIn;
		this.reimbursementStatusId = reimbursementStatusIdIn;
		this.reimbursementTypeId = reimbursementTypeIdIn;
	}
	
	
	
	public Reimbursements(Integer reimbursementIdIn, Double reimbursementAmountIn, String reimbursementSubmissionDateIn,
			String reimbursementResolutionDateIn, String reimbursementDescriptionIn, Integer reimbursementAuthorIdIn,
			Integer reimbursementResolverIdIn, Integer reimbursementStatusIdIn, Integer reimbursementTypeIdIn) 
	{
		super();
		this.reimbursementId = reimbursementIdIn;
		this.reimbursementAmount = reimbursementAmountIn;
		this.reimbursementSubmissionDate = reimbursementSubmissionDateIn;
		this.reimbursementResolutionDate = reimbursementResolutionDateIn;
		this.reimbursementDescription = reimbursementDescriptionIn;
		this.reimbursementReceipt = null;
		this.reimbursementAuthorId = reimbursementAuthorIdIn;
		this.reimbursementResolverId = reimbursementResolverIdIn;
		this.reimbursementStatusId = reimbursementStatusIdIn;
		this.reimbursementTypeId = reimbursementTypeIdIn;
	}



	public Reimbursements(Double reimbursementAmountIn, String reimbursementDescriptionIn, Blob reimbursementReceiptIn, 
							Integer reimbursementAuthorIdIn) 
	{
		super();
		this.reimbursementAmount = reimbursementAmountIn;
//		this.reimbursementSubmissionDate = reimbursementSubmissionDateIn;
//		this.reimbursementResolutionDate = reimbursementResolutionDateIn;
		this.reimbursementDescription = reimbursementDescriptionIn;
		this.reimbursementReceipt = reimbursementReceiptIn;
		this.reimbursementAuthorId = reimbursementAuthorIdIn;
//		this.reimbursementResolverId = reimbursementResolverIdIn;
//		this.reimbursementStatusId = reimbursementStatusIdIn;
//		this.reimbursementTypeId = reimbursementTypeIdIn;
	}



	public Integer getReimbursementId() 
	{
		return reimbursementId;
	}
	public void setReimbursementId(Integer reimbursementIdIn) 
	{
		this.reimbursementId = reimbursementIdIn;
	}
	public Double getReimbursementAmount() 
	{
		return reimbursementAmount;
	}
	public void setReimbursementAmount(Double reimbursementAmountIn) 
	{
		this.reimbursementAmount = reimbursementAmountIn;
	}
	public String getReimbursementSubmissionDate() 
	{
		return reimbursementSubmissionDate;
	}
	public void setReimbursementSubmissionDate(String reimbursementSubmissionDateIn) 
	{
		this.reimbursementSubmissionDate = reimbursementSubmissionDateIn;
	}
	public String getReimbursementResolutionDate() 
	{
		return reimbursementResolutionDate;
	}
	public void setReimbursementResolutionDate(String reimbursementResolutionDateIn) 
	{
		this.reimbursementResolutionDate = reimbursementResolutionDateIn;
	}
	public String getReimbursementDescription() 
	{
		return reimbursementDescription;
	}
	public void setReimbursementDescription(String reimbursementDescriptionIn) 
	{
		this.reimbursementDescription = reimbursementDescriptionIn;
	}
	public Blob getReimbursementReceipt() 
	{
		return reimbursementReceipt;
	}
	public void setReimbursementReceipt(Blob reimbursementReceiptIn) 
	{
		this.reimbursementReceipt = reimbursementReceiptIn;
	}
	public Integer getReimbursementAuthorId() 
	{
		return reimbursementAuthorId;
	}
	public void setReimbursementAuthorId(Integer reimbursementAuthorIdIn) 
	{
		this.reimbursementAuthorId = reimbursementAuthorIdIn;
	}
	public Integer getReimbursementResolverId() 
	{
		return reimbursementResolverId;
	}
	public void setReimbursementResolverId(Integer reimbursementResolverIdIn) 
	{
		this.reimbursementResolverId = reimbursementResolverIdIn;
	}
	public Integer getReimbursementStatusId() 
	{
		return reimbursementStatusId;
	}
	public void setReimbursementStatusId(Integer reimbursementStatusIdIn) 
	{
		this.reimbursementStatusId = reimbursementStatusIdIn;
	}
	public Integer getReimbursementTypeId() 
	{
		return reimbursementTypeId;
	}
	public void setReimbursementTypeId(Integer reimbursementTypeIdIn) 
	{
		this.reimbursementTypeId = reimbursementTypeIdIn;
	}
	
	public String toString() 
	{
		return "Reimbursements [reimbursementId=" + reimbursementId + ", reimbursementAmount=" + reimbursementAmount + 
				", reimbursementSubmissionDate=" + reimbursementSubmissionDate + ", reimbursementResolutionDate=" + 
				reimbursementResolutionDate + ", reimbursementDescription=" + reimbursementDescription + 
				", reimbursementReceipt=" + reimbursementReceipt + ", reimbursementAuthorId=" + reimbursementAuthorId + 
				", reimbursementResolverId=" + reimbursementResolverId + ", reimbursementStatusId=" + 
				reimbursementStatusId + ", reimbursementTypeId=" + reimbursementTypeId + "]";
	}
	
	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		
		result = prime * result + ((reimbursementAmount == null) ? 0 : reimbursementAmount.hashCode());
		result = prime * result + ((reimbursementAuthorId == null) ? 0 : reimbursementAuthorId.hashCode());
		result = prime * result + ((reimbursementDescription == null) ? 0 : reimbursementDescription.hashCode());
		result = prime * result + ((reimbursementId == null) ? 0 : reimbursementId.hashCode());
		result = prime * result + ((reimbursementResolutionDate == null) ? 0 : reimbursementResolutionDate.hashCode());
		result = prime * result + ((reimbursementResolverId == null) ? 0 : reimbursementResolverId.hashCode());
		result = prime * result + ((reimbursementStatusId == null) ? 0 : reimbursementStatusId.hashCode());
		result = prime * result + ((reimbursementSubmissionDate == null) ? 0 : reimbursementSubmissionDate.hashCode());
		result = prime * result + ((reimbursementTypeId == null) ? 0 : reimbursementTypeId.hashCode());
		
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
		
		Reimbursements other = (Reimbursements) objectIn;
		if (reimbursementAmount == null) 
		{
			if (other.reimbursementAmount != null)
				return false;
		}
		else if (!reimbursementAmount.equals(other.reimbursementAmount))
			return false;
		
		if (reimbursementAuthorId == null) 
		{
			if (other.reimbursementAuthorId != null)
				return false;
		}
		else if (!reimbursementAuthorId.equals(other.reimbursementAuthorId))
			return false;
		
		if (reimbursementDescription == null) 
		{
			if (other.reimbursementDescription != null)
				return false;
		}
		else if (!reimbursementDescription.equals(other.reimbursementDescription))
			return false;
		
		if (reimbursementId == null) 
		{
			if (other.reimbursementId != null)
				return false;
		}
		else if (!reimbursementId.equals(other.reimbursementId))
			return false;
		
		if (reimbursementReceipt == null) 
		{
			if (other.reimbursementReceipt != null)
				return false;
		}
		else if (!reimbursementReceipt.equals(other.reimbursementReceipt))
			return false;
		
		if (reimbursementResolutionDate == null) 
		{
			if (other.reimbursementResolutionDate != null)
				return false;
		}
		else if (!reimbursementResolutionDate.equals(other.reimbursementResolutionDate))
			return false;
		
		if (reimbursementResolverId == null) 
		{
			if (other.reimbursementResolverId != null)
				return false;
		}
		else if (!reimbursementResolverId.equals(other.reimbursementResolverId))
			return false;
		
		if (reimbursementStatusId == null) 
		{
			if (other.reimbursementStatusId != null)
				return false;
		}
		else if (!reimbursementStatusId.equals(other.reimbursementStatusId))
			return false;
		
		if (reimbursementSubmissionDate == null) 
		{
			if (other.reimbursementSubmissionDate != null)
				return false;
		}
		else if (!reimbursementSubmissionDate.equals(other.reimbursementSubmissionDate))
			return false;
		
		if (reimbursementTypeId == null) 
		{
			if (other.reimbursementTypeId != null)
				return false;
		}
		else if (!reimbursementTypeId.equals(other.reimbursementTypeId))
			return false;
		
		return true;
	}
	
	
}
