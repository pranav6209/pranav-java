/**
 * 
 */
package com.pranav.ik.A5DP;

/**
 * @author pranavpatel do the n stairs problme before this
 */
public class PP1_Count_ways_to_reach_the_Nth_stair {
  static long countWaysToClimb(int[] steps, int n) {

    long[] dp = new long[n + 1];

    // base case
    dp[0] = 1;

    // starts from step - 1
    for (int i = 1; i <= n; i++) {

      for (int j = 0; j < steps.length; j++) {

        // i-steps[j] is the current step
        if (steps[j] <= i) {

          // get total of all the valid step for f(n) = f(n-1) + f(n-2) we do for n stairs
          // but here we have to check if it valid(>=0)
          dp[i] = dp[i] + dp[i - steps[j]];

        }
      }
    }
    return dp[n];
  }
  
  public static void main(String[] args) {
    
    countWaysToClimb(new int[] {2,3},7);
  }

}
