/**
 * 
 */
package com.pranav.ik.A5DP;

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
public class C1_Climbing_N_Stairs {

  public static int climbStairs(int n) {

    int[] dp = new int[n+1];
    
    
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

      dp[i] = dp[i - 1] + dp[i - 2];
      //System.out.println(dp[i]);

    }
    return dp[n];
  }

  public static void main(String[] args) {

    int noOfStair = 8;

    System.out.println(climbStairs(noOfStair));
  }

}
