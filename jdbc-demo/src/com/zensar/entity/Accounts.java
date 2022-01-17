package com.zensar.entity;

public class Accounts {
	
	private Integer accountId;   
	private String accountType; 
	private Float InterestRate;
	private String subcategory;  
	private Double minimum_bal;
	
	
	public Accounts() {
		super();
	}
	
	
	public Accounts(Integer accountId, String accountType, Float interestRate, String subcategory, Double minimum_bal) {
		super();
		this.accountId = accountId;
		this.accountType = accountType;
		InterestRate = interestRate;
		this.subcategory = subcategory;
		this.minimum_bal = minimum_bal;
	}


	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public Float getInterestRate() {
		return InterestRate;
	}
	public void setInterestRate(Float interestRate) {
		InterestRate = interestRate;
	}
	public String getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}
	public Double getMinimum_bal() {
		return minimum_bal;
	}
	public void setMinimum_bal(Double minimum_bal) {
		this.minimum_bal = minimum_bal;
	}
	
	@Override
	public String toString() {
		return "Accounts [accountId=" + accountId + ", accountType=" + accountType + ", InterestRate=" + InterestRate
				+ ", subcategory=" + subcategory + ", minimum_bal=" + minimum_bal + "]";
	}
	
	

}
