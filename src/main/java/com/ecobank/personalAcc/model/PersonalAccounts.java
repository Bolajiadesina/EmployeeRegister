package com.ecobank.personalAcc.model;

public class PersonalAccounts {

	private String name;
	private String customerId;
	private String accountNumber;
	private String accountClass;
	private String email;
	private String telephone;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountClass() {
		return accountClass;
	}
	public void setAccountClass(String accountClass) {
		this.accountClass = accountClass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	@Override
	public String toString() {
		return "PersonalAccounts [name=" + name + ", customerId=" + customerId + ", accountNumber=" + accountNumber
				+ ", accountClass=" + accountClass + ", email=" + email + ", telephone=" + telephone + "]";
	}
	
	
	
}
