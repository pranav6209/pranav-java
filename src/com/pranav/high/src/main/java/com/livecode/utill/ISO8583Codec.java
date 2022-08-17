package com.livecode.utill;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.livecode.model.AuthorizationReq;
import com.livecode.model.AuthorizationRes;

public class ISO8583Codec {

	Logger logger = LoggerFactory.getLogger(ISO8583Codec.class);
	String input;
	AuthorizationRes authRes;

	public ISO8583Codec(String input, AuthorizationRes authRes) {
		super();
		this.input = input;
		this.authRes = authRes;
	}

	public ISO8583Codec(String input) {
		super();
		this.input = input;
	}

	public ISO8583Codec(AuthorizationRes authRes) {
		super();
		this.authRes = authRes;
	}

	static int counter = 0;

	public static AuthorizationReq decode(String str) {

		AuthorizationReq req = new AuthorizationReq();

		String bitMap = str.substring(4, 6);

		req.setHex(bitMap);
		String bin = hexToBin(bitMap);
		processString(bin, str, req);
		return req;

	}

	private static String hexToBin(String s) {
		return new BigInteger(s, 16).toString(2);
	}

	private static void processString(String bin, String str, AuthorizationReq req) {

		// e0 --> 11100000
		// if any of the required bit is missing -- send a message out

		if (bin.charAt(0) == '1') {

			processPan(str, req);
		}
		if (bin.charAt(1) == '1') {

			processExp(str, req);
		}
		if (bin.charAt(2) == '1') {

			processAmt(str, req);
		}
//		if (bin.charAt(3) == 1) {
//
//			processRespCode();
//		}
		if (bin.charAt(4) == '1') {

			processcardHolderName(str, req);
		}
		if (bin.charAt(5) == '1') {

			processZipCode(str, req);
		}

	}

	private static void processPan(String str, AuthorizationReq req) {

		String legnthOfPan = str.substring(6, 8);

		int legnthOfPanNumeric = Integer.parseInt(legnthOfPan);

		String pan = str.substring(8, 8 + legnthOfPanNumeric);

		counter = 8 + legnthOfPanNumeric;
		req.setPanLength(legnthOfPanNumeric);
		req.setPan(pan);

	}

	private static void processExp(String str, AuthorizationReq req) {

		// convert str to date
		String Date = str.substring(counter, counter + 4);

		StringBuffer sb = new StringBuffer();

		sb.append(Date.substring(0, 2));
		sb.append("/");
		sb.append(Date.substring(2, 4));
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/yy");
			simpleDateFormat.setLenient(false);
			Date expiry = simpleDateFormat.parse(sb.toString());
			req.setExpDate(expiry);
		} catch (ParseException e) {
			System.out.println("Not a valid expiry date" + Date);
		}

		counter = counter + 4;

	}

	private static void processAmt(String str, AuthorizationReq req) {

		// convert String to amt
		String amt = str.substring(counter, counter + 10);

		StringBuffer sb = new StringBuffer();

		sb.append(amt.substring(0, 8));
		sb.append(".");
		sb.append(amt.substring(8));

		// roundup 2 digit
		double amount = Double.parseDouble(sb.toString());
		BigDecimal maxProfitRoundUp = new BigDecimal(amount).setScale(2, RoundingMode.HALF_UP);
		counter = counter + 10;
		req.setIdx(counter);
		req.setAmount(amount);
	}

	private static void processcardHolderName(String str, AuthorizationReq req) {

		String lenghthOfChName = str.substring(counter, counter + 2);
		int legnthOfChNameNumeric = Integer.parseInt(lenghthOfChName);

		String chName = str.substring(counter + 2, counter + 2 + legnthOfChNameNumeric);

		counter = counter + 2 + legnthOfChNameNumeric;

		req.setChNameLength(legnthOfChNameNumeric);
		req.setChName(chName);

	}

	private static void processZipCode(String str, AuthorizationReq req) {

		String zipCode = str.substring(counter, counter + 5);
		req.setZipCode(zipCode);
	}

	public static String encode(AuthorizationRes authRes) {

		return authRes.toString();

		/*
		 * StringBuilder sb = new StringBuilder();
		 * 
		 * sb.append(authRes.getResponseMessage());
		 * sb.append(authRes.getResponseMessage());
		 * sb.append(authRes.getResponseMessage());
		 * sb.append(authRes.getResponseMessage());
		 * sb.append(authRes.getResponseMessage());
		 * sb.append(authRes.getResponseMessage());
		 * sb.append(authRes.getResponseMessage());
		 * sb.append(authRes.getResponseMessage());
		 * sb.append(authRes.getResponseMessage());
		 */

	}

}
