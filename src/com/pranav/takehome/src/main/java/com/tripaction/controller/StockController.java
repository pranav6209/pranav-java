package com.tripaction.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;
import com.tripaction.exception.StockDataException;
import com.tripaction.model.MaxProfitResponse;
import com.tripaction.model.ApiResponse;
import com.tripaction.services.StockDataCollector;
import com.tripaction.services.StockHandler;

@RestController
@RequestMapping("/stock")
public class StockController {

	@Autowired
	StockHandler stockHandler;

	Logger logger = LoggerFactory.getLogger(StockController.class);

	public StockController(StockHandler stockHandler) {
		this.stockHandler = stockHandler;
	}

	@GetMapping("/maxProfit")
	public ResponseEntity<Object> findMaxProfit(@RequestParam("stockSymbol") String stockSymbol) {

		ApiResponse apiResponse = new ApiResponse();

		if (stockSymbol.isBlank()) {
			apiResponse.setStatus(HttpStatus.BAD_REQUEST.value());
			apiResponse.setMessage("Invalid input");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse);
		}

		try {
			MaxProfitResponse maxProfitResponse = stockHandler.findMaxProfit(stockSymbol);
			if (maxProfitResponse.getBuyDate() == null && maxProfitResponse.getSellDate() == null
					&& maxProfitResponse.getMaxProfit() == 0.0) {

				apiResponse.setStatus(HttpStatus.OK.value());
				apiResponse.setMessage("Max profit is not possible as price is declining with dataset provided");
				return ResponseEntity.status(HttpStatus.OK).body(apiResponse);

			}

			apiResponse.setStatus(HttpStatus.OK.value());
			apiResponse.setMessage("Success");
			apiResponse.setMaxProfitResponse(maxProfitResponse);
			return ResponseEntity.status(HttpStatus.OK).body(apiResponse);

		} catch (StockDataException e) {
			logger.error("Error in processing request {} " + stockSymbol, e);

			// if 404 is returned means incorrect ticker passed, send that message out to
			// client
			if (404 == e.getStatusCode()) {
				apiResponse.setStatus(HttpStatus.BAD_REQUEST.value());
				apiResponse.setMessage(e.getMessage());
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse);

			}

			// in other cases like wrong API key or wrong DBcode passed. Log error for
			// internal use, return internal server error to
			// client
			apiResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

			apiResponse.setMessage("Error in processing request");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);
		}
	}

}
