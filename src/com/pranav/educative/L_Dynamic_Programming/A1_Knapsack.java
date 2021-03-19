/**
 * 
 */
package com.pranav.educative.L_Dynamic_Programming;

/**
 * @author pranavpatel
 * 
 *         Time and Space complexity of O(N*C), where ‘N’ represents total
 *         items, and ‘C’ is the maximum capacity.
 * 
 * 
 *         // Matrix drawn in book
 *
 */
public class A1_Knapsack {

  private int solveKnapsackRecursively(int[] profits, int[] weights, int capacity) {
    return this.knapsackRecursive(profits, weights, capacity, 0);
  }

  private int knapsackRecursive(int[] profits, int[] weights, int capacity, int currentIndex) {
    // base checks
    if (capacity <= 0 || currentIndex >= profits.length)
      return 0;

    // recursive call after choosing the element at the currentIndex
    // if the weight of the element at currentIndex exceeds the capacity, we
    // shouldn't process this
    int profit1 = 0;
    if (weights[currentIndex] <= capacity)
      profit1 = profits[currentIndex]
      + knapsackRecursive(profits, weights, capacity - weights[currentIndex], currentIndex + 1);

    // recursive call after excluding the element at the currentIndex
    int profit2 = knapsackRecursive(profits, weights, capacity, currentIndex + 1);

    return Math.max(profit1, profit2);
  }

  private int solveKnapsack(int[] profits, int[] weights, int capacity) {

    if (capacity <= 0 || profits.length == 0 || weights.length == 0 || profits.length != weights.length)
      return 0;

    int n = profits.length;
    // [index][capacity]
    int[][] dp = new int[n][capacity + 1];

    // populate the capacity=0 columns, with '0' capacity we have '0' profit
    for (int i = 0; i < n; i++)
      dp[i][0] = 0;

    // if we have only one weight, we will take it if it is not more than the
    // capacity
    for (int c = 1; c <= capacity; c++) {

      if (weights[0] <= c) {

        dp[0][c] = profits[0];
      }

    }

    // process all sub-arrays for all the capacities
    for (int i = 1; i < n; i++) {
      for (int c = 1; c <= capacity; c++) {

        // int profit1 = 0, profit2 = 0;

        if (weights[i] <= c)
          // include the item, if it is not more than the capacity
          // dp[i - 1][c - weights[i]] as we do not want to include the same weight in
          // knapsack
          dp[i][c] = Math.max(dp[i - 1][c], profits[i] + dp[i - 1][c - weights[i]]);
        // exclude the item
        else
          dp[i][c] = dp[i - 1][c];
      }
    }

    printSelectedElemets(dp, weights, profits, capacity);
    // maximum profit will be at the bottom-right corner.
    return dp[n - 1][capacity];

  }

  private void printSelectedElemets(int dp[][], int[] weights, int[] profits, int capacity) {

    System.out.println("Selected Weights");

    int n = profits.length;
    int totalProfit = dp[n - 1][capacity];

    // only go till i > 0 as we are doing i-1
    for (int i = n - 1; i > 0; i--) {

      if (totalProfit != dp[i - 1][capacity]) {

        System.out.println(" " + weights[i]);
        totalProfit = totalProfit - profits[i];
        capacity = capacity - weights[i];

      }
    }
    if (totalProfit != 0) {
      System.out.print(" " + weights[0]);
    }
    System.out.println("");

  }

  public static void main(String[] args) {
    A1_Knapsack ks = new A1_Knapsack();
    int[] profits = { 1, 6, 10, 16 };
    int[] weights = { 1, 2, 3, 5 };
    int maxProfit = ks.solveKnapsackRecursively(profits, weights, 7);
    System.out.println("Total knapsack profit ---> " + maxProfit);
    maxProfit = ks.solveKnapsack(profits, weights, 6);
    System.out.println("Total knapsack profit ---> " + maxProfit);
  }

}
