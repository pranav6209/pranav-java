/**
 * 
 */
package com.pranav.ik.A5DP;

/**
 * @author pranavpatel
 * 
 * Time : O(N)
 * Space : O(N)
 *
 *         https://leetcode.com/problems/min-cost-climbing-stairs/
 *
 *         Super useful blog
 *         https://leetcode.com/discuss/general-discussion/458695/dynamic-programming-patterns/439810#distinct-ways
 *         
 *    dry run OD Minimum cost stair climb class video     
 */
public class C4_Min_Cost_Climbing_Stairs {

  // calculating with bottom down approach
  public static int minCostClimbingStairs(int[] cost) {
    int len = cost.length;
 // extra entry at the beginning and end for floor below  and floor above
 // see class video for explanation   
    int[] dp = new int[len + 2]; 

    // initial Assignment in dp[]
    dp[0] = 0;
    dp[1] = cost[0];
    
    // appending 0 at the end of cost array as there is no cost to reach at end 
    // see class note
    cost[len] = 0;

    for (int i = 2; i < dp.length; i++) {
      dp[i] = cost[i - 1] + Math.min(dp[i - 1], dp[i - 2]);
    }

    // Math.min(dp[len - 1], dp[len - 2]); for the cost [0,0,0,1] dp [0,0,0,1] in
    // that case we want to return 0;
    return (dp[len + 1]);
  }

  public static void main(String[] args) {

    int[] nums = { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
    System.out.println(minCostClimbingStairs(nums));
  }
}
