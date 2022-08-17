package com.tripaction.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.tripaction.exception.StockDataException;
import com.tripaction.model.StockData;
import com.tripaction.utill.Constants;

@Service
public class StockDataCollector {

	@Autowired
	RestTemplate restTemplate;

	Logger logger = LoggerFactory.getLogger(StockDataCollector.class);

	public StockDataCollector(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public List<StockData> getTimeSeriesDailyNasdaq(String stockSymbol) throws StockDataException {

		String url = Constants.NASDAQ_NASE_URL + stockSymbol + Constants.NASDAQ_DATA_FORMAT + "?limit="
				+ Constants.NASDAQ_DATA_LIMIT + "&column_index=2&api_key=" + Constants.NASDAQ_KEY +"&order=asc";

		try {
			final long start = System.currentTimeMillis();

			// get the data as a String and then using GSON, convert to JSON
			String dailyDataRaw = restTemplate.getForObject(url, String.class);

			JsonObject jsonObject = new JsonParser().parse(dailyDataRaw).getAsJsonObject();

			boolean errorMessage = jsonObject.has("quandl_error");

			if (errorMessage) {
				logger.error("Error fetching data for a stock symbol " + stockSymbol
						+ jsonObject.getAsJsonObject("quandl_error").get("message").getAsString());
				throw new StockDataException(400, "Error fetching data for a stock symbol");
			}

			JsonObject dataset = jsonObject.getAsJsonObject("dataset");

			if (!stockSymbol.equals(dataset.get("dataset_code").getAsString())) {
				logger.error("Requested data for " + stockSymbol + "and got data for " + dataset.get("database_code"));
				throw new StockDataException(500, "Eror fetching data for " + stockSymbol);
			}

			JsonArray data = dataset.getAsJsonArray("data");

			logger.debug(
					"Time took to fetch data for " + stockSymbol + " in ms " + (System.currentTimeMillis() - start));

			return formatNasaqData(data);

		} catch (HttpClientErrorException e) {
			logger.error("Error fetching data for a stock symbol" + stockSymbol,e);
			JsonObject error = new JsonParser().parse(e.getResponseBodyAsString()).getAsJsonObject();
			String error_message = error.getAsJsonObject("quandl_error").get("message").getAsString();
			throw new StockDataException(e.getRawStatusCode(), error_message);
		}

	}

	private List<StockData> formatNasaqData(JsonArray jsonArray) {

		List<StockData> stockData = new ArrayList<>();
		
		jsonArray.iterator().forEachRemaining(element->{
			
			JsonArray data = element.getAsJsonArray();

			String date = data.get(0).getAsString();
			double price = data.get(1).getAsDouble();

			stockData.add(new StockData(date, price));	
			
		});

		return stockData;
	}
	
	/*

 	// The problem with Alpha Vantage is, it returns data worth 100 days. 
 	// There is no way to get data for just 90 days. So we can get the data from Alpha Vantage 
 	// and remove the last 10 days' worth of data but it is not an optimal solution.
 	
 	
	public List<StockData> getTimeSeriesDaily(String stockSymbol) throws RuntimeException {

		Logger logger = LoggerFactory.getLogger(StockDataCollector.class);

		try {
			final long start = System.currentTimeMillis();

			// move it to application.prop
			String url = "https://www.alphavantage.co/query?function=" + Constants.ALPHAVANTAGE_FUNCTION + "&symbol="
					+ stockSymbol + "&apikey=" + Constants.ALPHAVANTAGE_KEY;

			RestTemplate restTemplate = new RestTemplate();

			// get the data as a String and then using Gson
			String dailyDataRaw = restTemplate.getForObject(url, String.class);

			JsonObject jsonObject = new JsonParser().parse(dailyDataRaw).getAsJsonObject();

			boolean errorMessage = jsonObject.has("Error Message");

			if (errorMessage) {
				logger.error("Error fetching data for a stock symbol" + stockSymbol + jsonObject.get("Error Message"));
				throw new RuntimeException("Eror fetching data for " + stockSymbol);
			}

			JsonObject metaData = jsonObject.getAsJsonObject("Meta Data");
			JsonObject timeSeriesDaily = jsonObject.getAsJsonObject("Time Series (Daily)");

			logger.debug(
					"Time took to fetch data for " + stockSymbol + " in ms " + (System.currentTimeMillis() - start));

			return formatAlphavantageData(timeSeriesDaily);
		} catch (HttpClientErrorException e) {
			System.out.println(e.getStatusCode());
			System.out.println(e.getResponseBodyAsString());
			logger.error("Error fetching data for a stock symbol" + stockSymbol, e);
			throw new RuntimeException("Eror fetching data for " + stockSymbol);
		}

	}

	private List<StockData> formatAlphavantageData(JsonObject jsonobj) {

		List<StockData> stockData = new ArrayList<>();

		// iterate through each keys in timeSeriesDaily to get data

		// convert to java -8
		for (String keyStr : jsonobj.keySet()) {

			JsonObject dailyData = jsonobj.getAsJsonObject(keyStr);

			// convert to double
			Double dailyHigh = dailyData.get("2. high").getAsDouble();

			stockData.add(new StockData(keyStr, dailyHigh));

		}

		return stockData;
	}
*/
}
