/**
 * 
 */
package com.pranav.educative.L_Dynamic_Programming;

/**
 * @author pranavpatel
 * 
 * https://leetcode.com/problems/coin-change-2/
 * 
 * we have a choice to include/exclude so knapsack and we can 
 * use same coin multiple same time so unbounded 
 * 
 * when we have asked for count  or no of ways '+' between 2 choices.
 * when min or max, min max between 2 choices 
 *
 */
public class B3_Coin_Change {
  public int countChange(int[] denominations, int total) {

    int n = denominations.length;
    int[][] dp = new int[n+1][total + 1];
    
    // to pass leetcode tests
    if(n == 0 && total==0) return 1;
    
    if(n==0 && total > 0 ) return 0;

    // possible get 0 total with empty array so initialize with 1 
    for (int i = 0; i <= n; i++) {

      dp[i][0] = 1;
    }

    // with empty array, we can not achieve any sum so initialize with 0 
    for (int t = 1; t <= total; t++) {

      
      dp[0][t] = 0;
      
    }

    for (int i = 1; i <= n; i++) {
      for (int t = 1; t <= total; t++) {
        
        // include /exclude choices
        if (denominations[i-1] <= t)
          dp[i][t] = dp[i - 1][t] + dp[i][t - denominations[i-1]];
        else
          dp[i][t] = dp[i - 1][t];

      }
    }
    return dp[n][total];
  }

  public static void main(String[] args) {
    B3_Coin_Change cc = new B3_Coin_Change();
    int[] denominations = {};
    System.out.println(cc.countChange(denominations, 0));
  }
}
