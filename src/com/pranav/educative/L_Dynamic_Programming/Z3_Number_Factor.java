/**
 * 
 */
package com.pranav.educative.L_Dynamic_Programming;

/**
 * @author pranavpatel 0, 1, 1, 2, 3, 5, 8,13 …
 */
public class Z3_Number_Factor {

  private int CountWays(int n) {
    int[] dp = new int[n + 1];

    // reach step -1 only one 1 way direct go to it
    if (n == 1)
      return 1;
    // reach step -2 two way direct go to it or 1 at a time.
    if (n == 2)
      return 2;

    // We can reach 0 by only starting there. Thus, s(0) = 1
    dp[0] = 1;

    // base case
    dp[1] = 1;
    dp[2] = 2;

    for (int i = 3; i <= n; i++) {

      dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
      // System.out.println(dp[i]);

    }
    return dp[n];
  }
}
