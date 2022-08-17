package com.tripaction.model;

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
public class ApiResponse {

	private int status;
	private String message;
	private MaxProfitResponse maxProfitResponse;

	public ApiResponse(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

}