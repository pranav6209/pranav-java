/**
 * 
 */
package com.pranav.lc.DP;

/**
 *         @author pranavpatel
 *
 *         https://leetcode.com/problems/min-cost-climbing-stairs/
 *
 *         Super useful blog
 *         https://leetcode.com/discuss/general-discussion/458695/dynamic-programming-patterns/439810#distinct-ways
 */
public class A_Min_Cost_Climbing_Stairs {

  
  //calculating with bottom down approach
  public static int minCostClimbingStairs(int[] cost) {
    int len = cost.length;
    int[] dp = new int[len];

    // base cases are covered in return else we can put something like

    /*
     * cost[0] return 0; cost[1] return 1;
     */

    // initial Assignment in dp[]
    dp[0] = cost[0];
    dp[1] = cost[1];
    
    for (int i = 2; i < len; i++) {
      dp[i] = Math.min(dp[i - 1] + cost[i], dp[i - 2] + cost[i]);
    }
    
    //Math.min(dp[len - 1], dp[len - 2]); for the cost [0,0,0,1] dp [0,0,0,1] in that case we want to return 0;
    return Math.min(dp[len - 1], dp[len - 2]);
  }

  public static void main(String[] args) {

    int[] nums = { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
    System.out.println(minCostClimbingStairs(nums));
  }
}
