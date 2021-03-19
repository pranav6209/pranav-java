/**
 * 
 */
package com.pranav.educative.L_Dynamic_Programming;

/**
 * @author pranavpatel
 * 
 * https://leetcode.com/problems/coin-change-2/
 *
 */
public class B3_Coin_Change {
  public int countChange(int[] denominations, int total) {

    int n = denominations.length;
    int[][] dp = new int[n][total + 1];
    
    // to pass leetcode tests
    if(n == 0 && total==0) return 1;
    
    if(n==0 && total > 0 ) return 0;

    for (int i = 0; i < n; i++) {

      dp[i][0] = 1;
    }

    for (int t = 0; t <= total; t++) {
      // here if 0th index denomination is less than total we can use it
      // multiple time so considering each sub array.
      if (denominations[0] <= t) {
        dp[0][t] = dp[0][t - denominations[0]];
      }
    }

    for (int i = 1; i < n; i++) {
      for (int t = 1; t <= total; t++) {

        if (denominations[i] <= t)
          dp[i][t] = dp[i - 1][t] + dp[i][t - denominations[i]];
        else
          dp[i][t] = dp[i - 1][t];

      }
    }
    return dp[n - 1][total];
  }

  public static void main(String[] args) {
    B3_Coin_Change cc = new B3_Coin_Change();
    int[] denominations = {};
    System.out.println(cc.countChange(denominations, 0));
  }
}
