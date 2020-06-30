/**
 * 
 */
package com.pranav.educative.twopointer;

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

    int i = 0;

    for (int j = 0; j < nums.length; j++) {

      // goal here is to move all un removed number to front and doen't matter what we
      // left behind
      // so no need to swap i and j just. just assign value of j to i.

      // if array value is not equal to value to be removed add it to an array
      if (nums[j] != key) {
        // put value of unmatched element into new index in
        // existing array and increment slow pointer
        nums[i] = nums[j];
        i++;

      }

    }

    return i;
  }

  public static void main(String[] args) {

    System.out.println(remove(new int[] { 3, 2, 3, 6, 3, 10, 9, 3 }, 3));
    System.out.println(remove(new int[] { 2, 11, 2, 2, 1 }, 2));

  }
}
