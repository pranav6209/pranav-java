package com.tripaction.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.web.client.HttpClientErrorException;

import com.tripaction.exception.StockDataException;
import com.tripaction.model.MaxProfitResponse;
import com.tripaction.model.StockData;
import com.tripaction.services.StockDataCollector;
import com.tripaction.services.StockHandler;

public class StockHandlerTest {
	
	
	@Mock
    StockDataCollector stockDataCollector;

    @InjectMocks
    StockHandler stockHandler;
    
    List<StockData> stockData;
    
    MaxProfitResponse dummyResponse;
   

    @Before
    public void setup() {
    	stockDataCollector = Mockito.mock(StockDataCollector.class);
    	stockHandler = new StockHandler(stockDataCollector);
    	stockData = buildDummyStockData();
    	dummyResponse = buildDummyResponse();
    }
    
    
    
    @Test
    public void testFindMaxProfitValidStockSymbol() throws StockDataException  {
    	Mockito.when(stockDataCollector.getTimeSeriesDailyNasdaq(Mockito.anyString())).thenReturn(stockData);
    	MaxProfitResponse response = stockHandler.findMaxProfit("AMC");
        Assert.assertNotNull(response);   
        assertDoesNotThrow(()->stockHandler.findMaxProfit("AMC"));
        Assert.assertNotEquals(dummyResponse,response);;
        
    }

    @Test
    public void testFindMaxProfitEmptyInput() throws StockDataException {
    	Mockito.when(stockDataCollector.getTimeSeriesDailyNasdaq(Mockito.anyString()));
    	assertThrows(StockDataException.class,()->stockHandler.findMaxProfit(""));
    }
    
    @Test
    public void testFindMaxProfitInvlidInput() throws StockDataException {
      	Mockito.when(stockDataCollector.getTimeSeriesDailyNasdaq(Mockito.anyString())).thenThrow(new StockDataException());
    	assertThrows(StockDataException.class,()->stockHandler.findMaxProfit("GMC"));
    }
    
    private List<StockData> buildDummyStockData() {
    	
    	List<StockData> stockData = new ArrayList<>();
    	
    	stockData.add(new StockData("2018-02-03",42.00));
    	stockData.add(new StockData("2018-02-04",41.63));
    	stockData.add(new StockData("2018-02-05",40.67));
    	stockData.add(new StockData("2018-02-06",39.03));
    	
    	return stockData;
    }
    
   private MaxProfitResponse buildDummyResponse() {
	   return new MaxProfitResponse("2018-02-05", "2018-02-06",4.36 );
   }

}
