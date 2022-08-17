package com.tripaction.controller;

import com.tripaction.exception.StockDataException;
import com.tripaction.model.MaxProfitResponse;
import com.tripaction.services.StockHandler;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class StockControllerTest {

	@Mock
	StockHandler stockHandler;

	@InjectMocks
	StockController stockController;

	@Before
	public void setup() {
		stockHandler = Mockito.mock(StockHandler.class);
		stockController = new StockController(stockHandler);
	}

	@Test
	public void testFindMaxProfitEmptyStockSymbol() {
		ResponseEntity response = stockController.findMaxProfit("");
		Assert.assertNotNull(response);
		Assert.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}

	@Test
	public void testFindMaxProfitValid() throws Exception {
		Mockito.when(stockHandler.findMaxProfit(Mockito.anyString())).thenReturn(new MaxProfitResponse(200));
		ResponseEntity response = stockController.findMaxProfit("GMC");
		Assert.assertNotNull(response);
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	public void testFindMaxProfitInternalError() throws Exception {
		Mockito.when(stockHandler.findMaxProfit(Mockito.anyString()))
				.thenThrow(new StockDataException(400, "Error in processing request"));
			ResponseEntity response = stockController.findMaxProfit("GMC");
			Assert.assertNotNull(response);
			Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
		
	}
}
