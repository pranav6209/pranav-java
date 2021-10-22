/**
 * 
 */
package com.pranav.educative.L_Dynamic_Programming;

/**
 * @author pranavpatel
 *
 */
public class B2_Rod_Cutting {
  public int solveRodCutting(int[] lengths, int[] prices, int n) {
    // base checks
    if (n <= 0 || prices.length == 0 || prices.length != lengths.length)
      return 0;

    int lengthCount = lengths.length;
    int[][] dp = new int[lengthCount+1][n + 1];

    for (int i = 0; i <= n; i++)
      dp[i][0] = 0;

    for (int len = 1; len <= n; len++) {
      dp[0][len] = 0;
      
    }

    // process all rod lengths for all prices
    for (int i = 1; i <= lengthCount; i++) {
      for (int len = 1; len <= n; len++) {
        if (lengths[i-1] <= len)
          dp[i][len] = Math.max(dp[i - 1][len], prices[i-1] + dp[i][len - lengths[i-1]]);
        else
          dp[i][len] = dp[i - 1][len];
      }
    }
    // maximum price will be at the bottom-right corner.
    return dp[lengthCount][n];

  }

  public static void main(String[] args) {
    B2_Rod_Cutting rc = new B2_Rod_Cutting();
    int[] lengths = { 1, 2, 3, 4, 5 };
    int[] prices = { 2, 6, 7, 10, 13 };
    int maxProfit = rc.solveRodCutting(lengths, prices, 5);
    System.out.println(maxProfit);
  }

}
