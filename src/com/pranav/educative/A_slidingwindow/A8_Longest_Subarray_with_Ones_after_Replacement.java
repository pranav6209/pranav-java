/**
 * 
 */
package com.pranav.educative.A_slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pranavpatel
 * 
 *        https://leetcode.com/problems/max-consecutive-ones-iii/submissions/
 * 
 *         // time O(N) // space O(K) - as we are storing only k+1 char in
 *         hashmap
 *
 */
public class A8_Longest_Subarray_with_Ones_after_Replacement {

  public static int findLength(int[] arr, int k) {

    int window_start = 0, max_length = 0, max_one_count = 0;

    for (int window_end = 0; window_end < arr.length; window_end++) {

      if (arr[window_end] == 1)
        max_one_count++;

      if (window_end - window_start + 1 - max_one_count > k) {

        if (arr[window_start] == 1) max_one_count--;
        window_start++;

      }

      max_length = Math.max(max_length, window_end - window_start + 1);

    }

    return max_length;

  }

  public static void main(String[] args) {
    System.out.println(
      A8_Longest_Subarray_with_Ones_after_Replacement.findLength(new int[] { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 }, 2));
    System.out.println(
      A8_Longest_Subarray_with_Ones_after_Replacement
        .findLength(new int[] { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 }, 3));

  }

}
