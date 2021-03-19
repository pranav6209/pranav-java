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
    int[][] dp = new int[n][capacity + 1];

    // populate the capacity=0 columns
    for (int i = 0; i < n; i++)
      dp[i][0] = 0;

    /*   
 *   populate the capacity=0 columns here we are adding dp[0][c - weights[0]] unlike 0/1
 *   because we want to reuse element at index 0 and that is why we are counting 
 *   each sub array created before it.
     */
    for (int c = 0; c <= capacity; c++)
      if (weights[0] <= c) {
        dp[0][c] = profits[0] + dp[0][c - weights[0]];
      }

    // process all sub-arrays for all capacities
    for (int i = 1; i < n; i++) {
      for (int c = 1; c <= capacity; c++) {
        if (weights[i] <= c)
          // here we are not doing dp[i-1][c - weights[i]] like 0/1
          // rather we are counting each sub array and created before it.
          dp[i][c] = Math.max(dp[i - 1][c], profits[i] + dp[i][c - weights[i]]);
        else
          dp[i][c] = dp[i - 1][c];
      }

    }
    return dp[n - 1][capacity];

  }

  public static void main(String[] args) {
    B1_Unbounded_Kanpsack ks = new B1_Unbounded_Kanpsack();
    int[] profits = { 15, 50, 60, 90 };
    int[] weights = { 1, 3, 4, 5 };
    System.out.println(ks.solveKnapsack(profits, weights, 8));
    System.out.println(ks.solveKnapsack(profits, weights, 6));
  }
}
