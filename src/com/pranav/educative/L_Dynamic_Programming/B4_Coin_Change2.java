/**
 * 
 */
package com.pranav.educative.L_Dynamic_Programming;

/**
 * @author pranavpatel
 * 
 *         https://leetcode.com/problems/coin-change-2/
 *
 */
public class B4_Coin_Change2 {
  public int countChange(int[] denominations, int total) {
    int n = denominations.length;
    int[][] dp = new int[n][total + 1];

    for (int i = 0; i < n; i++)
      for (int j = 0; j <= total; j++)
        dp[i][j] = Integer.MAX_VALUE;

    // populate the total=0 columns, as we don't need any coin to make zero total
    for (int i = 0; i < n; i++)
      dp[i][0] = 0;

    for (int t = 0; t <= total; t++) {
      // here if 0th index denomination is less than total we can use it
      // multiple time so considering each sub array.
      if (denominations[0] <= t) {
        if (dp[0][t - denominations[0]] != Integer.MAX_VALUE)
          dp[0][t] = 1+dp[0][t - denominations[0]];
      }
    }

    for (int i = 1; i < n; i++) {
      for (int t = 1; t <= total; t++) {
        if (denominations[i]<=t) {
          if (dp[i][t - denominations[i]] != Integer.MAX_VALUE)
            dp[i][t] = Math.min(dp[i-1][t], dp[i][t - denominations[i]] + 1); // include the coin
        } else {
            dp[i][t] = dp[i-1][t];
        }
      }
    }

    // total combinations will be at the bottom-right corner.
    return (dp[n - 1][total] == Integer.MAX_VALUE ? -1 : dp[n - 1][total]);
  }

  public static void main(String[] args) {
    B4_Coin_Change2 cc = new B4_Coin_Change2();
    int[] denominations = { 1, 2, 3 };
    // System.out.println(cc.countChange(denominations, 5));
    // System.out.println(cc.countChange(denominations, 11));
    System.out.println(cc.countChange(denominations, 7));
    // denominations = new int[] { 3, 5 };
    // System.out.println(cc.countChange(denominations, 7));
  }
}
