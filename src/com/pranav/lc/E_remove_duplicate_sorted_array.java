/**
 * 
 */
package com.pranav.lc;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * @author pranavpatel two pointer -- fast and slow
 * 
 *         fast pointer(j) runs through each array elements and slow pointer (i)
 *         stays back to check weather i and j are different or not.
 *         
 *         here j is keeping track of the index, where we inserting an element
 */
public class E_remove_duplicate_sorted_array {
  public static int removeDuplicates(int[] nums) {

    if (nums == null || nums.length == 0)
      return 0;

    int i = 0;
    for (int j = 1; j < nums.length; j++) {

      int value1 = nums[i];
      int value2 = nums[j];

      // if both the values are not same then only add it an array
      if (value1 != value2) {
        // make sure to first increment and then assign the value
        i++;
        nums[i] = nums[j];

      }
    }

    return i + 1;

  }

  public static void main(String[] args) {
    int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
   // int[] nums = { 0, 1, 1, 1, 1, 2, 2, 3, 3, 4 };
    System.out.println(removeDuplicates(nums));
  }
}