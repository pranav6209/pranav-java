package com.tripaction.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.tripaction.exception.StockDataException;
import com.tripaction.model.StockData;
import com.tripaction.services.StockDataCollector;

public class StockDataCollectorTest {

	@Mock
	RestTemplate restTemplate;

	@InjectMocks
	StockDataCollector stockDataCollector;

	@Before
	public void setup() {
		restTemplate = Mockito.mock(RestTemplate.class);
		stockDataCollector = new StockDataCollector(restTemplate);
	}

	@Test
	public void testGetTimeSerirsDailyValidInput() throws StockDataException {
		
		String url = "https://data.nasdaq.com/api/v3/datasets/WIKI/GM.json?limit=90&column_index=2&api_key=RvHzNkm838h8PoXeqAyz&order=asc";
		String urlResponse = "{\"dataset\":{\"id\":9775715,\"dataset_code\":\"GM\",\"database_code\":\"WIKI\",\"name\":\"General Motors Co. "
				+ "(GM) Prices, Dividends, Splits and Trading Volume\",\"description\":\"End of day open, high, low, close and volume, dividends "
				+ "and splits, and split/dividend adjusted open, high, low close and volume for General Motors Company (GM). Ex-Dividend is non-zero "
				+ "on ex-dividend dates. Split Ratio is 1 on non-split dates. Adjusted prices are calculated per CRSP (www.crsp.com/products/documentation/crsp-calculations)\\n\\nThis data is "
				+ "in the public domain. You may copy, distribute, disseminate or include the data in other products for commercial and/or noncommercial purposes.\\n\\nThis data is part of Quandl's Wiki "
				+ "initiative to get financial data permanently into the public domain. Quandl relies on users like you to flag errors and provide data where data is wrong or missing. Get involved: connect@quandl.com\\n\",\"refreshed_at\":\"2018-03-27T21:46:11.168Z\","
				+ "\"newest_available_date\":\"2018-03-27\",\"oldest_available_date\":\"2010-11-18\",\"column_names\":[\"Date\",\"High\"],\"frequency\":\"daily\",\"type\":\"Time Series\",\"premium\":false,\"limit\":90,\"transform\":null,\"column_index\":2,\"start_date\":\"2010-11-18\",\"end_date\":\"2018-03-27\",\"data\":[[\"2017-11-15\",43.04],[\"2017-11-16\",43.63],[\"2017-11-17\",44.14],[\"2017-11-20\",45.09],[\"2017-11-21\",45.179],[\"2017-11-22\",44.95],[\"2017-11-24\",44.54],[\"2017-11-27\",44.49],[\"2017-11-28\",45.08],[\"2017-11-29\",45.35],[\"2017-11-30\",44.53],[\"2017-12-01\",43.25],[\"2017-12-04\",43.42],[\"2017-12-05\",43.06],[\"2017-12-06\",42.69],[\"2017-12-07\",42.39],[\"2017-12-08\",42.3],[\"2017-12-11\",41.93],[\"2017-12-12\",41.77],[\"2017-12-13\",41.91],[\"2017-12-14\",41.44],[\"2017-12-15\",41.33],[\"2017-12-18\",42.32],[\"2017-12-19\",42.8],[\"2017-12-20\",42.78],[\"2017-12-21\",42.75],[\"2017-12-22\",42.31],[\"2017-12-26\",42.09],[\"2017-12-27\",41.85],[\"2017-12-28\",41.44],[\"2017-12-29\",41.5922],[\"2018-01-02\",41.87],[\"2018-01-03\",42.95],[\"2018-01-04\",44.25],[\"2018-01-05\",44.64],[\"2018-01-08\",44.59],[\"2018-01-09\",44.59],[\"2018-01-10\",44.14],[\"2018-01-11\",44.27],[\"2018-01-12\",44.7],[\"2018-01-16\",45.52],[\"2018-01-17\",44.27],[\"2018-01-18\",44.19],[\"2018-01-19\",44.09],[\"2018-01-22\",43.42],[\"2018-01-23\",43.44],[\"2018-01-24\",44.4],[\"2018-01-25\",44.48],[\"2018-01-26\",43.565],[\"2018-01-29\",43.78],[\"2018-01-30\",43.22],[\"2018-01-31\",42.95],[\"2018-02-01\",42.6],[\"2018-02-02\",42.27],[\"2018-02-05\",41.67],[\"2018-02-06\",42.23],[\"2018-02-07\",43.56],[\"2018-02-08\",42.71],[\"2018-02-09\",41.97],[\"2018-02-12\",42.62],[\"2018-02-13\",42.07],[\"2018-02-14\",41.91],[\"2018-02-15\",42.21],[\"2018-02-16\",42.28],[\"2018-02-20\",41.33],[\"2018-02-21\",41.3],[\"2018-02-22\",41.2],[\"2018-02-23\",41.14],[\"2018-02-26\",41.62],[\"2018-02-27\",41.54],[\"2018-02-28\",40.15],[\"2018-03-01\",39.59],[\"2018-03-02\",37.61],[\"2018-03-05\",37.9],[\"2018-03-06\",38.0799],[\"2018-03-07\",37.84],[\"2018-03-08\",37.93],[\"2018-03-09\",38.08],[\"2018-03-12\",37.99],[\"2018-03-13\",38.5399],[\"2018-03-14\",38.61],[\"2018-03-15\",37.99],[\"2018-03-16\",38.15],[\"2018-03-19\",37.98],[\"2018-03-20\",37.26],[\"2018-03-21\",38.02],[\"2018-03-22\",37.33],[\"2018-03-23\",36.59],[\"2018-03-26\",36.05],[\"2018-03-27\",36.03]],\"collapse\":null,\"order\":\"asc\",\"database_id\":4922}}";
		
		Mockito.when(restTemplate.getForObject(url, String.class)).thenReturn(urlResponse);

		List<StockData> response = stockDataCollector.getTimeSeriesDailyNasdaq("GM");
		Assert.assertNotNull(response);
		Assert.assertEquals(90, response.size());
	}



}
