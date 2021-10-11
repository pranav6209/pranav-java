/**
 * 
 */
package com.pranav.ik.A6PrefixSum;

/**
 * @author pranavpatel
 * 
 * time : O(N)
 * space : O(N) we can also do in place. look at next problem
 *
 */

// we can also just replace values in i/p array

public class A1_Running_Sum_1D_Array {
  public int[] runningSum(int[] nums) {

    int[] prefixSum = new int[nums.length];
    int pSum = 0;
    for (int i = 0; i < nums.length; i++) {

      pSum = pSum + nums[i];
      prefixSum[i] = pSum;

    }

    return prefixSum;
  }
}
