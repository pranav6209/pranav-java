/**
 * 
 */
package com.pranav.educative.L_Dynamic_Programming;

import java.util.Arrays;

/**
 * @author pranavpatel
 * 
 *       1.  Fractional knapsack -- Greedy you can partially choose weight
 *       2.  0/1 knapsack -- multiple occurrence is not allowed 
 *       3.  Unbounded Knapsack -- multiple occurrence is allowed
 *       
 *       How to identify DP problems
 *       
 *        1. Choice 
 *        2. optimal 
 *        
 *        
 *       choice diagram (include/exclude logic)
 *       
 *       if element chosen is bigger than knapsack weight, we exclude if 
 *       it is smaller, we have choice to include or exclude   *
 */
public class A1_Knapsack {

  /*
   Recursive Solution -- we do not need to use this but just for understanding 
   solve it with IK strategy for better understanding but do not waste time
   goal is to achieve always bottom up // Educative has both recursive and top down solution
   this is more like include exclude case we do in recursion
   
   */
  
  private int solveKnapsackRecursively(int[] profits, int[] weights, int capacity) {
    return knapsackRecursive(capacity, 0,profits, weights);
  }

  // current index is sub problem definition capacity is partial solution
  
  private int knapsackRecursive(int capacity, int currentIndex,int[] profits, int[] weights) {
    // base checks. think of smallest valid input
    if (capacity <= 0 || currentIndex >= profits.length) // n == 0 || w == 0
      return 0;

    int profit1 = 0;
    if (weights[currentIndex] <= capacity) // if current weight is less than capacity include/exclude
      profit1 = profits[currentIndex]
      + knapsackRecursive(capacity - weights[currentIndex], currentIndex + 1,profits, weights);

    // else only choice is exclude it
    int profit2 = knapsackRecursive( capacity, currentIndex + 1,profits, weights);
    
    // max of include and exclude is profit
    return Math.max(profit1, profit2);
  }
  
  // DP Solution // bottom up
  // as we have see n and w are only changing so we have to make table for those
  
  //value at a specific grid is a sub-optimal solution.means if we look at value at capacity 3 index 2
  // which is 11, that is the optimal answer(max answer) in the case problem is given with that capacity
  //and that wight.Matrix is in educative. 
  private int solveKnapsack(int[] profits, int[] weights, int capacity) {

    // 
    if (capacity <= 0 || profits.length == 0 || weights.length == 0 || profits.length != weights.length)
      return 0;

    int n = profits.length;
    
    // base case
    int[][] dp = new int[n][capacity + 1];

    // similar to base condition in recursive call 
    
    // populate the capacity=0 columns, with '0' capacity we have '0' profit
    for (int i = 0; i < n; i++)
      dp[i][0] = 0;

    // populate first row, for weight[0] if it is less than capacity include it
    
    for (int c = 1; c <= capacity; c++) {

      if (weights[0] <= c) {

        dp[0][c] = profits[0];
      }

    }

    // process all sub-arrays for all the capacities
    for (int i = 1; i < n; i++) {
      for (int c = 1; c <= capacity; c++) {

        
        
        /* 
         * if weight is less than or equal to capacity - choice of include it or exclude. select max of both choice 
           if we include the item, subtract its weight
           dp[i - 1][c - weights[i]] as we do not want to include the same weight in
           
           */

        if (weights[i] <= c)
          
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
