/**
 * 
 */
package com.pranav.educative.B_twopointer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pranavpatel
 * 
 *         https://leetcode.com/problems/remove-element/
 * 
 *         time : O(N) space : O(1)
 */
public class A3_Remove_Instance_Of_Key {

  public static int remove(int[] nums, int key) {

    if (nums == null || nums.length == 0)
      return 0;

    int slow = 0;

    for (int fast = 0; fast < nums.length; fast++) {

      // goal here is to move all number that are staying to front and doesn't matter what we
      // left behind
      // so no need to swap i and j just. just assign value of j to i.

      // if array value is not equal to value to be removed add it to an array
      if (nums[fast] != key) {
        // put value of unmatched element into new index in
        // existing array and increment slow pointer
        nums[slow] = nums[fast];
        slow++;

      }

    }

    return slow;
  }

  public static void main(String[] args) {

    System.out.println(remove(new int[] { 3, 2, 3, 6, 3, 10, 9, 3 }, 3));
    System.out.println(remove(new int[] { 2, 11, 2, 2, 1 }, 2));

  }
}
