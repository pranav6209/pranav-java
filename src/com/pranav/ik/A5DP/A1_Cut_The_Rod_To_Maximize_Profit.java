/**
 * 
 */
package com.pranav.ik.A5DP;

import java.util.ArrayList;
import java.util.List;

/*
 * 
 *   make sure to study bounded/unbounded knapsack first before trying this. code/matrix is similar from educative/aditya
 *  
 *   in case we want to go 1D. There is an explanation in Joseph class video @ 1:17:51
 *
 */
public class A1_Cut_The_Rod_To_Maximize_Profit {
  static int get_maximum_profit(List<Integer> price) {

    // capacity or length of rod given that we want to cut in smaller pieces 
    // knapsack capacity
    int n = price.size();

    // as len array is not given create one. [1,2,3,4,5].
    // this is more like a weight array in knapsacks
    List<Integer> len = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      len.add(i + 1);
    }

    int[][] dp = new int[n][n + 1];

    // With '0' capacity, maximum profit we can have for every subarray is '0'
    for (int i = 0; i < n; i++) {
      dp[i][0] = 0;
    }

    // with one length, we can cut the rod in size one unit pieces 
    for (int j = 0; j <= n; j++) {
      if (len.get(0) <= j) {
        dp[0][j] = price.get(0) + dp[0][j - len.get(0)];
      }
    }

    for (int i = 1; i < n; i++) {
      for (int j = 1; j <= n; j++) {
        if (len.get(i) <= j) {

          dp[i][j] = Math.max(price.get(i) + dp[i][j - len.get(i)], dp[i - 1][j]);

        } else {
          dp[i][j] = dp[i - 1][j];
        }

      }
    }
    
    return dp[n-1][n];
  }

  public static void main(String[] args) {
    List<Integer> prices = new ArrayList<>();
    prices.add(2);
    prices.add(6);
    prices.add(7);
    prices.add(10);
    prices.add(13);
    System.out.println(get_maximum_profit(prices));
  }
}
