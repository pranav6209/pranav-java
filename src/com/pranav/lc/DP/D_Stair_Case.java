/**
 * 
 */
package com.pranav.lc.DP;

import java.util.Arrays;

/**
 * @author pranavpatel
 * 
 * 
 *         https://leetcode.com/problems/climbing-stairs/
 * 
 *         https://www.youtube.com/watch?v=jgiZlGzXMBw 08:05 for logic
 *
 */
public class D_Stair_Case {

  public static int climbStairs(int n) {

    int[] dp = new int[n];

    
    if (n == 1)
      return 1;

    // 0th index means at step 1
    dp[0] = 1;
    dp[1] = 2;

    for (int i = 2; i < n; i++) {

      dp[i] = dp[i - 1] + dp[i - 2];
      System.out.println(dp[i]);

    }
    return dp[n - 1];
  }

  public static void main(String[] args) {

    int noOfStair = 2;

    System.out.println(climbStairs(noOfStair));
  }

}
