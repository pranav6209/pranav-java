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


public class MaxProfitResponse {
   
	private String buyDate;
    private String sellDate;
    private double maxProfit;
    
    
    public MaxProfitResponse(int maxProfit) {
        this.maxProfit = maxProfit;
    }

}
