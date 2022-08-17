package com.livecode.model;

import java.util.Date;

public class AuthorizationRes {
	String authorizationMessage;
	String hex;
	int panLength;
	String pan;
	Date expDate;
	double amount;
	String responseCode;
	int chNameLength;
	String chName;
	String zipCode;
	String pre;
	String post;

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMessage() {
		return responseCode;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseCode = responseMessage;
	}

	public String getAuthorizationMessage() {
		return authorizationMessage;
	}

	public void setAuthorizationMessage(String authorizationMessage) {
		this.authorizationMessage = authorizationMessage;
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

	public int getChNameLength() {
		return chNameLength;
	}

	public void setChNameLength(int chNameLength) {
		this.chNameLength = chNameLength;
	}

	public String getPre() {
		return pre;
	}

	public void setPre(String pre) {
		this.pre = pre;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

}
