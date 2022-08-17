package com.tripaction.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripaction.exception.StockDataException;
import com.tripaction.model.MaxProfitResponse;
import com.tripaction.model.StockData;

@Service
public class StockHandler {
	
	@Autowired
	StockDataCollector stockDataCollector;
	
	Logger logger = LoggerFactory.getLogger(StockDataCollector.class);
	
	public StockHandler(StockDataCollector stockDataCollector) {
		this.stockDataCollector = stockDataCollector;
	}

	public MaxProfitResponse findMaxProfit (String stockSymbol) throws StockDataException{

		List<StockData> data = stockDataCollector.getTimeSeriesDailyNasdaq(stockSymbol);
		if(data == null) {
			logger.error("No data to calculate max profit for stock symbol " + stockSymbol);
			throw new StockDataException(500,"Eror fetching data for " + stockSymbol);
		}
		return findMaxProfit(data, stockSymbol);
	}

	private MaxProfitResponse findMaxProfit(List<StockData> stockDataPoints, String stockSymbol) {
		
		final long start = System.currentTimeMillis();
		MaxProfitResponse maxProfitResponse = new MaxProfitResponse(0);
		
		// index where the stock price is minimum
		int minPriceIndex = 0;
		
		for (int index = 0; index < stockDataPoints.size(); index++) {
		
			// Current pointer stock data
			StockData currentData = stockDataPoints.get(index);
			
			// Minimum price stock data
			StockData minPriceData = stockDataPoints.get(minPriceIndex);
			
			// If the current stock data found to be min update the minIndex.
			
			if (currentData.getPrice() <= minPriceData.getPrice()) {
				minPriceIndex = index;
			/*
				 As we are here, we are guaranteed to have higher price then minimum price.
				 Count the profit. if the profit is more than current max profit, update the 
				 maxProfitResponse
			*/	 
			} else if ((currentData.getPrice()  - minPriceData.getPrice()) > maxProfitResponse.getMaxProfit()) {
				
				maxProfitResponse.setBuyDate(minPriceData.getDate());
				maxProfitResponse.setSellDate(currentData.getDate());
				
				// roundup 2 digit
				double maxProfit = currentData.getPrice() - minPriceData.getPrice();
				BigDecimal maxProfitRoundUp = new BigDecimal(maxProfit).setScale(2,RoundingMode.HALF_UP);
				
				maxProfitResponse.setMaxProfit(maxProfitRoundUp.doubleValue());
			}
		}
		logger.debug(
				"Time took to calculate max profit for " + stockSymbol + " in ms " + (System.currentTimeMillis() - start));
		
		return maxProfitResponse;
	}
}
