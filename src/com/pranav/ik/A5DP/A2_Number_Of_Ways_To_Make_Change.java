/**
 * 
 */
package com.pranav.ik.A5DP;

import java.util.List;

/**
 *  
 * make sure to study bounded/unbounded knapsack first before trying this. code/matrix is similar from educative/aditya
 *
 */
public class A2_Number_Of_Ways_To_Make_Change {
  public static int number_of_ways(List<Integer> coins, int amount) {

    int n = coins.size();

    int[][] dp = new int[n][amount + 1];

    for (int i = 0; i < n; i++) {

      dp[i][0] = 1;
    }

    for (int t = 0; t <= amount; t++) {
      // here if 0th index denomination is less than total we can use it
      // multiple time so considering each sub array.
      if (coins.get(0) <= t) {
        dp[0][t] = dp[0][t - coins.get(0)];
      }
    }

    for (int i = 1; i < n; i++) {
      for (int t = 1; t <= amount; t++) {

        if (coins.get(i) <= t)
          dp[i][t] = dp[i - 1][t] + dp[i][t - coins.get(i)];
        else
          dp[i][t] = dp[i - 1][t];

        dp[i][t] %= 1000000007;
      }
    }
    return dp[n - 1][amount];

  }

}
