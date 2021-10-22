/**
 * 
 */
package com.pranav.educative.L_Dynamic_Programming;

/**
 * @author pranavpatel
 * 
 *         https://www.youtube.com/watch?v=aycn9KO8_Ls&ab_channel=AdityaVerma
 *
 */
public class B1_Unbounded_Kanpsack {
  public int solveKnapsack(int[] profits, int[] weights, int capacity) {
    // base checks
    if (capacity <= 0 || profits.length == 0 || weights.length != profits.length)
      return 0;

    int n = profits.length;
    int[][] dp = new int[n+1][capacity + 1];

    // same logic as 0/1 knapsack
    for (int i = 0; i <= n; i++)
      dp[i][0] = 0;

    for (int c = 1; c <= capacity; c++)
      dp[0][c] = 0;

    // process all sub-arrays for all capacities
    for (int i = 1; i <= n; i++) {
      for (int c = 1; c <= capacity; c++) {
        if (weights[i-1] <= c)
          // only when we have choice to include, we can include the same element again so, we want to be in the same raw(to use same element) dp[i][c - weights[i-1]], 
          // if we are excluding we do not want to include same element again. so, excluding that row dp[i-1][c] 
          
          dp[i][c] = Math.max(dp[i - 1][c], profits[i-1] + dp[i][c - weights[i-1]]);
        else
          dp[i][c] = dp[i - 1][c];
      }

    }
    return dp[n][capacity];

  }

  public static void main(String[] args) {
    B1_Unbounded_Kanpsack ks = new B1_Unbounded_Kanpsack();
    int[] profits = { 15, 50, 60, 90 };
    int[] weights = { 1, 3, 4, 5 };
    System.out.println(ks.solveKnapsack(profits, weights, 8));
    System.out.println(ks.solveKnapsack(profits, weights, 6));
  }
}
