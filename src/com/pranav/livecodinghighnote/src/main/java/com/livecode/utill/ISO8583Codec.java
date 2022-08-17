package com.livecode.utill;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.livecode.model.AuthReq;

public class ISO8583Codec {

	int counter = 0;

	public AuthReq decode(String input) {

		AuthReq req = new AuthReq();

		String hex = input.substring(4, 6);

		String bin = convertHexToBin(hex, req);

		processString(input, bin, req);
		
		return req;

	}

	private String convertHexToBin(String input, AuthReq req) {

		return new BigInteger(input, 16).toString(2);
	}

	private void processString(String str, String input, AuthReq req) {

		if (input.charAt(0) == '1') {

			processPan( input, req);
		}

		if (input.charAt(1) == '1') {

			processExp(input, req);
		}

		if (input.charAt(2) == '1') {

			processAmt(input, req);
		}

		if (input.charAt(4) == '1') {

			processChName(input, req);
		}

		if (input.charAt(5) == '1') {

			processZipCode(input, req);
		}

	}

	private void processPan(String input, AuthReq req) {

		String lengthOfPan = input.substring(6, 8);
		int lengthOfPanNumeric = Integer.parseInt(lengthOfPan);

		String pan = input.substring(8, 8 + lengthOfPanNumeric);
		counter = 8 + lengthOfPanNumeric;

		req.setPanLength(lengthOfPanNumeric);
		req.setPan(pan);

	}

	private void processExp(String input, AuthReq req) {

		String Date = input.substring(counter, counter + 4);

		// 1225 --> 12/25 --- Date --> set it in req --> increase the count 4

		StringBuffer sb = new StringBuffer();

		sb.append(Date.substring(0, 2));
		sb.append("/");
		sb.append(Date.substring(2, 4));

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("MM/yy");
			Date expiry = sdf.parse(sb.toString());
			req.setExpDate(expiry);

		} catch (ParseException e) {
			System.out.println("Not a valide expiry date" + e);
		}

		counter = counter + 4;
	}

	private void processAmt(String input, AuthReq req) {
		
		String amt = input.substring(counter, counter+10);
		
		StringBuffer sb = new StringBuffer();

		sb.append(amt.substring(0, 8));
		sb.append(".");
		sb.append(amt.substring(8));
		
		double amount = Double.parseDouble(sb.toString());
		
		counter = counter + 10;
		
		req.setAmount(amount);

	}
	
	private void processChName(String input, AuthReq req) {
		
		String lengthOfChName = input.substring(counter, counter+2);
		int lengthOfChNameNumeric = Integer.parseInt(lengthOfChName);
		
		String chName = input.substring(counter+2 , counter+2 +lengthOfChNameNumeric);
		counter = counter+2 +lengthOfChNameNumeric;
		req.setChNameLength(lengthOfChNameNumeric);
		req.setChName(chName);
	}

	private void processZipCode(String input, AuthReq req) {
		
		String zipCode = input.substring(counter,counter+5);
		
		req.setZipCode(zipCode);
	}
	
	
}
