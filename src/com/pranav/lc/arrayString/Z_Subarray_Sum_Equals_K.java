/**
 * 
 */
package com.pranav.lc.arrayString;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pranavpatel
 * 
 *         https://leetcode.com/problems/subarray-sum-equals-k/
 * 
 *         https://www.youtube.com/watch?v=HbbYPQc-Oo4&t=55s
 *
 */
public class Z_Subarray_Sum_Equals_K {

  /*
   * time complexity O(N^2):for nested sub array calculation and O(N) space
   * complexity constant O(1)
   * 
   */

  public static int subarraySum1(int[] nums, int k) {

    int res = 0;

    for (int start = 0; start < nums.length; start++) {
      int sum = 0;
      for (int end = start; end < nums.length; end++) {

        sum = sum + nums[end];

        if (sum == k)
          res++;

      }
    }
    return res;
  }

  /*
   * time complexity O(N): space complexity O(N)
   * 
   */ public static int subarraySum2(int[] nums, int k) {

     // cumulative sum
    int currSum = 0;
    int res = 0;
    // map to maintain cumulative and total no of times it repeated 
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {

      currSum = currSum + nums[i];

      // we found subarray with sum =k
      if (currSum == k)
        res = res + 1;

      // if map has currSum - k get the value and add it to result
      if (map.containsKey(currSum - k)) {

        res = res + map.get(currSum - k);
      }

      // if map has a currSum get it the value and increment
      if (map.containsKey(currSum)) {
        map.put(currSum, map.get(currSum) + 1);
      } else {
        // else put the current sum value for and 1
        map.put(currSum, 1);
      }
      
      // can be replaced by one liner 
      
     //map.put(currSum, map.getOrDefault(currSum, 0)+1);
      
    }
    return res;
  }

  public static void main(String[] args) {
    //
    // int[] nums = { 3, 4, 7, 2, -3, 1, 4, 2 };
    // int k = 7;
    //
    // int[] nums = { 1, 2, 3 };
    // int k = 3;

    int[] nums = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    int k = 0;
    System.out.println(subarraySum2(nums, k));
  }
}
