/**
 * 
 */
package com.pranav.educative.L_Dynamic_Programming;

/**
 * 
 */
public class Z2_StairCase {

  private static int countWaysRecursive(int n) {

    // we do not need to take any steps so there is only one way
    if (n == 0)
      return 1;
    // take one step to reach the end
    if (n == 1)
      return 1;
    // take one step twice or jump 2 steps
    if (n == 2)
      return 2;

    int take1Step = countWaysRecursive(n - 1);
    int take2Step = countWaysRecursive(n - 2);
    int take3Step = countWaysRecursive(n - 3);

    return take1Step + take2Step + take3Step;

  }

  private static int countWaysTopDown(int n) {
    int[] dp = new int[n + 1];
    return countWaysTD(n, dp);
  }

  private static int countWaysTD(int n, int[] dp) {

    // smallest valid inputs
    if (n == 0)
      return 1;
    if (n == 1)
      return 1;
    if (n == 2)
      return 2;

    if (dp[n] == 0) {
      int take1Step = countWaysRecursive(n - 1);
      int take2Step = countWaysRecursive(n - 2);
      int take3Step = countWaysRecursive(n - 3);

      dp[n] = take1Step + take2Step + take3Step;
    }

    return dp[n];
  }

  private static int countWays(int n) {
    if (n <= 2)
      return 1;

    int dp[] = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    dp[2] = 2;

    for (int i = 3; i <= n; i++)
      dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];

    return dp[n];
  }

  public static void main(String[] args) {
    System.out.println(countWays(5));
  }
}
