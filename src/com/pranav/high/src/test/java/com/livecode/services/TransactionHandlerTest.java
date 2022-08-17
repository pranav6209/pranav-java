package com.livecode.services;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class TransactionHandlerTest {
	@Test
	public void processTransactions() {
	
		
		TransactionHandler txnHandler = new TransactionHandler();
		
		
		String input =  "0100e016411111111111111112250000001000";
		String output = "0110f016411111111111111112250000001000OK";
		System.out.println(txnHandler.processTxn(input));
		
		Assert.assertTrue(output.equals(txnHandler.equals(input)));
		
	}
}
