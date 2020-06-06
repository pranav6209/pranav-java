/**
 * 
 */
package com.pranav.lc.arrayString;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pranavpatel
 * 
 * https://leetcode.com/problems/contiguous-array/
 * 
 * https://www.youtube.com/watch?v=VM5Mh3-UFPg
 * 
 * time complexity O(N)
 * if the all value is either O or 1 in worst case map will gorw till n
 * space complexity O(N)
 *
 */
public class V_Contiguous_Array {
  public static int findMaxLength(int[] nums) {

    // Map of count and index
    Map<Integer, Integer> map = new HashMap<>();

    int maxLen = 0, count = 0;

    // adding count 0 at -1 index as base case.
    map.put(0, -1);

    for (int i = 0; i < nums.length; i++) {

      // if the current number is 1 increase the count by 1 and for 0 decrease it by
      // -1;
      count = count + (nums[i] == 1 ? 1 : -1);

      if (map.containsKey(count)) {

        // index where the same count happened earlier
        int index = map.get(count);

        int newMaxLen = i - index;

        if (newMaxLen > maxLen)
          maxLen = newMaxLen;

        // above four line of code can be replaced by one liner below
        // maxLen = Math.max(maxLen, i-map.get(count));

      } else {
        map.put(count, i);
      }

    }
    return maxLen;

  }

  public static void main(String[] args) {

    // int[] nums = { 0, 1 };
    int[] nums = { 0, 0, 0, 1, 1, 1, 0 };
    System.out.println(findMaxLength(nums));
  }

}
