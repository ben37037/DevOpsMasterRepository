package project1.beans;

import java.sql.Blob;

public class ReimbursementsWithNames 
{
	private Integer reimbursementId;
	private Double reimbursementAmount;
	private String reimbursementDateSubmitted;
	private String reimbursementDateResolved;
	private String reimbursementDescription;
	private Blob reimbursementReceipt;
	private Integer reimbursementResolver;
	private Integer reimbursementStatusId;
	private Integer reimbursementTypeId;
	private String ersUserName;
	
	
	
	public ReimbursementsWithNames(Integer reimbursementIdIn, Double reimbursementAmountIn,
			String reimbursementDateSubmittedIn, String reimbursementDateResolvedIn, String reimbursementDescriptionIn,
			Integer reimbursementResolverIn, Integer reimbursementStatusIdIn, Integer reimbursementTypeIdIn,
			String ersUserNameIn) 
	{
		super();
		this.reimbursementId = reimbursementIdIn;
		this.reimbursementAmount = reimbursementAmountIn;
		this.reimbursementDateSubmitted = reimbursementDateSubmittedIn;
		this.reimbursementDateResolved = reimbursementDateResolvedIn;
		this.reimbursementDescription = reimbursementDescriptionIn;
		this.reimbursementResolver = reimbursementResolverIn;
		this.reimbursementStatusId = reimbursementStatusIdIn;
		this.reimbursementTypeId = reimbursementTypeIdIn;
		this.ersUserName = ersUserNameIn;
	}
	public ReimbursementsWithNames(Integer reimbursementIdIn, Double reimbursementAmountIn,
			String reimbursementDateSubmittedIn, String reimbursementDateResolvedIn, String reimbursementDescriptionIn,
			Blob reimbursementReceiptIn, Integer reimbursementResolverIn, Integer reimbursementStatusIdIn,
			Integer reimbursementTypeIdIn, String ersUserNameIn) 
	{
		super();
		this.reimbursementId = reimbursementIdIn;
		this.reimbursementAmount = reimbursementAmountIn;
		this.reimbursementDateSubmitted = reimbursementDateSubmittedIn;
		this.reimbursementDateResolved = reimbursementDateResolvedIn;
		this.reimbursementDescription = reimbursementDescriptionIn;
		this.reimbursementReceipt = reimbursementReceiptIn;
		this.reimbursementResolver = reimbursementResolverIn;
		this.reimbursementStatusId = reimbursementStatusIdIn;
		this.reimbursementTypeId = reimbursementTypeIdIn;
		this.ersUserName = ersUserNameIn;
	}
	@Override
	public String toString() 
	{
		return "ReimbursementsWithNames [reimbursementId=" + reimbursementId + ", reimbursementAmount="
				+ reimbursementAmount + ", reimbursementDateSubmitted=" + reimbursementDateSubmitted
				+ ", reimbursementDateResolved=" + reimbursementDateResolved + ", reimbursementDescription="
				+ reimbursementDescription + ", reimbursementReceipt=" + reimbursementReceipt
				+ ", reimbursementResolver=" + reimbursementResolver + ", reimbursementStatusId="
				+ reimbursementStatusId + ", reimbursementTypeId=" + reimbursementTypeId + ", ersUserName="
				+ ersUserName + "]";
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
	public String getReimbursementDateSubmitted() 
	{
		return reimbursementDateSubmitted;
	}
	public void setReimbursementDateSubmitted(String reimbursementDateSubmittedIn) 
	{
		this.reimbursementDateSubmitted = reimbursementDateSubmittedIn;
	}
	public String getReimbursementDateResolved() 
	{
		return reimbursementDateResolved;
	}
	public void setReimbursementDateResolved(String reimbursementDateResolvedIn) 
	{
		this.reimbursementDateResolved = reimbursementDateResolvedIn;
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
	public Integer getReimbursementResolver() 
	{
		return reimbursementResolver;
	}
	public void setReimbursementResolver(Integer reimbursementResolverIn) 
	{
		this.reimbursementResolver = reimbursementResolverIn;
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
	public String getErsUserName() 
	{
		return ersUserName;
	}
	public void setErsUserName(String ersUserNameIn) 
	{
		this.ersUserName = ersUserNameIn;
	}
	
	
}