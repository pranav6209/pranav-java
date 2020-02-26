/**
 * 
 */
package com.pranav.lc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pranavpatel
 * https://leetcode.com/problems/two-sum/
 * 
 * Array HashTable
 *
 */
public class A_twoSum {

  public static int[] twoSum(int[] nums, int target) {
   
    // map 
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (map.containsKey(complement)) {
        return new int[] { map.get(complement), i };
      }
      map.put(nums[i], i);
    }
    throw new IllegalArgumentException("No two sum solution");
  }

  public static void main(String[] args) {

    int[] nums = { 2, 1, 11, 7 };
    int target = 9;

    System.out.println(Arrays.toString(twoSum(nums, target)));
   

  }
}
