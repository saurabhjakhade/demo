package com.example.model;

public class Client {

	String fullName;
	String accountId;
	String bankId;
	String customerNumber;

	boolean isAccountAvailable;
	boolean isCustomerAvailable;
	boolean isKYCDone;

	public boolean isCustomerAvailable() {
		return isCustomerAvailable;
	}

	public void setCustomerAvailable(boolean isCustomerAvailable) {
		this.isCustomerAvailable = isCustomerAvailable;
	}

	public boolean isAccountAvailable() {
		return isAccountAvailable;
	}

	public void setAccountAvailable(boolean isAccountAvailable) {
		this.isAccountAvailable = isAccountAvailable;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public boolean isKYCDone() {
		return isKYCDone;
	}

	public void setKYCDone(boolean isKYCDone) {
		this.isKYCDone = isKYCDone;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

}
