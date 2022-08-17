package com.tripaction.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class StockDataException extends Exception {

	
	private int statusCode;
	private String message;


	public StockDataException(String message) {
		this.message = message;
		
	}
	
}
