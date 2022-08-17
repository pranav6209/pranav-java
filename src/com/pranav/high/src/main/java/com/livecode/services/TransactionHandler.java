package com.livecode.services;

import java.util.Date;

import com.livecode.model.AuthorizationReq;
import com.livecode.model.AuthorizationRes;
import com.livecode.utill.ISO8583Codec;

public class TransactionHandler {

	public String processTxn(String str) {

		// String str = "0100e016411111111111111112250000001000";

		// String str = "0100ec1651051051051051001225000001100011MASTER YODA90089";

		// add a quick validation method here if hex has a missing required bit

		AuthorizationReq req = ISO8583Codec.decode(str);

		AuthorizationRes res = auhorizeTxn(req, str);

		String response = ISO8583Codec.encode(res);

		return response;
	}

	public AuthorizationRes auhorizeTxn(AuthorizationReq req,String str) {

		AuthorizationRes res = new AuthorizationRes();

		/*
		 * String input = "11/12"; // for example SimpleDateFormat simpleDateFormat =
		 * new SimpleDateFormat("MM/yy"); simpleDateFormat.setLenient(false); Date
		 * expiry = simpleDateFormat.parse(input); boolean expired = expiry.before(new
		 * Date());
		 * 
		 */
		
		System.out.println(req.getExpDate());
		System.out.println(new Date());
		System.out.println(req.getExpDate().before(new Date()));

		if (req.getAmount() < 100.00 && !req.getExpDate().before(new Date())) {

			res.setAuthorizationMessage("OK");
		}

		else if ((req.getAmount() > 100.00 && req.getAmount() < 200.00) && !req.getExpDate().before(new Date())) {

			res.setAuthorizationMessage("OK");
		}

		// declined
		else {
			res.setResponseMessage("DE");
		}
		
		res.setResponseMessage("0110");
		res.setChNameLength(req.getChNameLength());
		res.setChName(req.getChName());
		res.setExpDate(req.getExpDate());
		res.setAmount(req.getAmount());
		res.setChNameLength(req.getChNameLength());
		res.setChName(req.getChName());
		res.setZipCode(req.getZipCode());
		
		
		res.setPre(str.substring(0, req.getIdx()+1));
		res.setPost(str.substring(req.getIdx()+1));
		
		return res;

	}

	public static void main(String[] args) {

		// System.out.println(processTransactions());

	}

}
