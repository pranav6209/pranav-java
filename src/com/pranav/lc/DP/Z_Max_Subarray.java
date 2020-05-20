/**
 * 
 */
package com.pranav.lc.DP;

import java.util.Map;

/**
 * @author pranavpatel
 * 
 *          
 *         https://leetcode.com/problems/maximum-subarray/
 *         Kadanes's Algo 
           https://www.youtube.com/watch?v=kekmCQXYwQ0 
           DP solution 
 *         https://leetcode.com/problems/maximum-subarray/discuss/20193/DP-solution-and-some-thoughts
 *
 */
public class Z_Max_Subarray {

  // DP
  public static int maxSubArrayDP(int[] nums) {

    int n = nums.length;
    int[] dp = new int[n];// dp[i] means the maximum subarray ending with A[i];
    dp[0] = nums[0];
    int max = dp[0];

    for (int i = 1; i < n; i++) {
      dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
      max = Math.max(max, dp[i]);
    }

    
    
    return max;

  }

  //

  public static int maxSubArray(int[] nums) {

    int max_sum_ending_here = 0;
    int max_sum_so_far = nums[0];
    int start = 0;
    int end = 0;
    int s = 0;

    for (int i = 0; i < nums.length; i++) {

      max_sum_ending_here = nums[i] + max_sum_so_far;

      if (max_sum_so_far < max_sum_ending_here) {

        max_sum_so_far = max_sum_ending_here;
        start = s;
        end = i;

      }

      if (max_sum_ending_here < 0) {
        s = i + 1;
      }

    }

    System.out.println("Starting Index: " + start + ". Ending Index: " + end);
    return max_sum_so_far;

  }

  public static void main(String[] args) {

    int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

    System.out.println(maxSubArrayDP(nums));
    System.out.println(maxSubArray(nums));
  }

}
