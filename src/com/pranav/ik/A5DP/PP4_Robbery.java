/**
 * 
 */
package com.pranav.ik.A5DP;

/**
 * @author pranavpatel
 * 
 * https://leetcode.com/problems/house-robber/
 * 
 * solution is from educative 
 * 
 * https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/m2EOxJ0Nkp3
 *
 */
public class PP4_Robbery {
  static int maxStolenValue(int[] values) {

    int n = values.length;
    int[] dp = new int[n + 1];

    dp[0] = 0;
    dp[1] = values[0];

    for (int i = 2; i <= n; i++) {
      dp[i] = Math.max(values[i - 1] + dp[i - 2], dp[i - 1]);
    }

    return dp[n];
  }
}
