/**
 * 
 */
package com.pranav.ik.A6PrefixSum;

/**
 * @author pranavpatel
 * 
 * time : O(N) to compute presum 
 * space : O(1)  not using extra space
 * 
 * 
 * basic idea is if we want to compute sum of 
 * 
 * 11+12...100
 * 
 * we ll compute (1+2+3...100) - (1+2+3+4...10)
 * 
 * Leetcode example 
 * 
 * [-2, 0, 3, -5, 2, -1]  after calculating prefix sum, [-2,-2,1,-4,-2,-3]
 * 
 * if we want to calculate range sum for index [2,5]. get the prefix sum of 5
 * subtract the prfix sum of 1. 
 * 
 * if calculating for [0,2] just return prefix sum of 2 as nothing to subtract 
 * 
 *
 */
public class A2_Range_Sum_Query_Immutable {

  int[] nums;

  public A2_Range_Sum_Query_Immutable(int[] nums) {

    for(int i = 1; i< nums.length; i++)
         
        nums[i] = nums[i] + nums[i-1];
      
      this.nums = nums;
  
  }

  public int sumRange(int left, int right) {

    if (left == 0)
      return nums[right];

    else {
      return nums[right] - nums[left - 1];
    }

  }
}
