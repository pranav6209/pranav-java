/**
 * 
 */
package com.pranav.educative.L_Dynamic_Programming;

import java.util.List;

/**
 * @author pranavpatel
 * 
 *         https://leetcode.com/problems/coin-change/
 *
 */
public class B4_Coin_Change2 {

  public int countChange(int[] coins, int amount) {
    int n = coins.length;
    int[][] dp = new int[n + 1][amount + 1];

    // populate the total=0 columns, as we don't need any coin to make zero total
    for (int i = 1; i <= n; i++)
      dp[i][0] = 0;

    // we can not keep matrix initialize to 0 as if the total is not possible,
    // we want to return -1
    for (int j = 0; j <= amount; j++)
      dp[0][j] = Integer.MAX_VALUE - 1;

    for (int j = 1; j <= amount; j++) {
      // here if 0th index denomination is less than total we can use it
      // multiple time so considering each sub array.
      if (j % coins[0] == 0) {
        dp[1][j] = j /coins[0];
      } else {
        dp[1][j] = Integer.MAX_VALUE - 1;
      }
    }

    for (int i = 2; i <= n; i++) {
      for (int j = 1; j <= amount; j++) {
        if (coins[i - 1] <= j) {
          dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]); // include the coin
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }

    // total combinations will be at the bottom-right corner.
    return (dp[n][amount] == Integer.MAX_VALUE - 1 ? -1 : dp[n][amount]);
  }

  public int countChange1(int[] denominations, int total) {
    int n = denominations.length;
    int[][] dp = new int[n][total + 1];

    // we can not keep matrix initialize to 0 as if the total is not possible,
    // we want to return -1
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
          dp[0][t] = 1 + dp[0][t - denominations[0]];
      }
    }

    for (int i = 1; i < n; i++) {
      for (int t = 1; t <= total; t++) {
        if (denominations[i] <= t) {
          if (dp[i][t - denominations[i]] != Integer.MAX_VALUE)
            // if including then only + 1
            dp[i][t] = Math.min(dp[i - 1][t], 1 + dp[i][t - denominations[i]]); // include the coin
        } else {
          dp[i][t] = dp[i - 1][t];
        }
      }
    }

    // total combinations will be at the bottom-right corner.
    return (dp[n - 1][total] == Integer.MAX_VALUE ? -1 : dp[n - 1][total]);
  }

  // one dimensional Array instead of 2 d array
  // for each value -- iterate through each coin and get the min value and store
  // the min value at that index
  public static int minimum_coins(List<Integer> coins, int value) {

    int[] dp = new int[value + 1];

    dp[0] = 0;

    for (int j = 1; j <= value; j++) {
      int min = Integer.MAX_VALUE;
      for (int coin : coins) {
        if (coin <= j) {
          min = Math.min(min, 1 + dp[j - coin]);
        }
      }
      dp[j] = min;
    }

    return dp[value] == Integer.MAX_VALUE ? -1 : dp[value];
  }

  public static void main(String[] args) {
    B4_Coin_Change2 cc = new B4_Coin_Change2();
    int[] denominations = { 1,2,5 };
    //int[] denominations = { 8, 10, 3, 7, 9, 1, 2 };
    
    // System.out.println(cc.countChange(denominations, 5));
     System.out.println(cc.countChange(denominations, 11));
    //System.out.println(cc.countChange(denominations, 455));
    // denominations = new int[] { 3, 5 };
    // System.out.println(cc.countChange(denominations, 7));
  }
}
