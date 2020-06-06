/**
 * 
 */
package com.pranav.lc.DP.MinMaxToTarget;

import java.util.Arrays;

/**
 * @author pranavpatel
 * 
 * 
 *         https://leetcode.com/problems/coin-change/
 * 
 *         https://www.youtube.com/watch?v=jgiZlGzXMBw 08:05 for logic
 *
 */
public class C_Coin_Change {

  public static int coinChage(int[] coins, int amount) {

    int[] dp = new int[amount + 1];

    //
    Arrays.fill(dp, amount + 1);

    for (int i = 0; i < amount; i++) {

      for (int j = 0; j < coins.length; j++) {

        if (coins[j] <= i) {

          dp[i] = Math.min(1 + dp[i - coins[j]], dp[i]);

        }

      }

    }

    // coins [2] amount =3;
    return dp[amount] > amount ? -1 : dp[amount];
  }

  public static void main(String[] args) {

    int[] coins = { 1, 2, 5 };
    int amount = 11;

    System.out.println(coinChage(coins, amount));
  }

}
