package com.livecode.model;

import java.util.Date;

public class AuthReq {

	String authMessage;
	String hex;
	int panLength;
	String pan;
	Date expDate;
	double amount;
	int chNameLength;
	String chName;
	String zipCode;

	public String getAuthMessage() {
		return authMessage;
	}

	public void setAuthMessage(String authMessage) {
		this.authMessage = authMessage;
	}

	public String getHex() {
		return hex;
	}

	public void setHex(String hex) {
		this.hex = hex;
	}

	public int getPanLength() {
		return panLength;
	}

	public void setPanLength(int panLength) {
		this.panLength = panLength;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getChNameLength() {
		return chNameLength;
	}

	public void setChNameLength(int chNameLength) {
		this.chNameLength = chNameLength;
	}

	public String getChName() {
		return chName;
	}

	public void setChName(String chName) {
		this.chName = chName;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

}
