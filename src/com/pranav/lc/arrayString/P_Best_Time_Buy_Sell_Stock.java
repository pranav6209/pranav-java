/**
 * 
 */
package com.pranav.lc.arrayString;

import java.util.Arrays;

/**
 * @author pranavpatel
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 */
public class P_Best_Time_Buy_Sell_Stock {

  static int buySellStock(int[] prices) {

    int maxProfit = 0;
    for (int i = 0; i < prices.length - 1; i++) {

      for (int j = i + 1; j < prices.length; j++) {

        // make sure to do j-i as first buy and then sell so subtracting
        // buy at samllest and then sell at higher
        int profit = prices[j] - prices[i];

        if (profit > maxProfit) {

          maxProfit = profit;
        }
      }

    }
    return maxProfit;
  }

  static int buySellStock1(int[] prices) {

    int minPrice = Integer.MAX_VALUE;
    int maxProfit = 0;

    for (int i = 0; i < prices.length; i++) {

      if (prices[i] < minPrice)
        minPrice = prices[i];
      else if (prices[i] - minPrice > maxProfit)
        maxProfit = prices[i] - minPrice;

    }

    return maxProfit;

  }

  public static void main(String[] args) {

    int[] nums = new int[] { 7, 1, 5, 3, 6, 4 };

    System.out.println(buySellStock(nums));
    System.out.println(buySellStock1(nums));
  }
}
