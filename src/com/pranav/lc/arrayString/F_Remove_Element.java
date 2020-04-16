/**
 * 
 */
package com.pranav.lc.arrayString;

/**
 * @author pranavpatel
 * 
 * https://leetcode.com/problems/remove-element/
 *
 *         * fast pointer(j) runs through each array elements and slow pointer
 *         (i) stays back to check weather i and j are different or not.
 *         
 *         here i is keeping track of the index, where we inserting an element
 */
public class F_Remove_Element {

  public static int removeElement(int[] nums, int val) {

    if (nums == null || nums.length == 0)
      return 0;

    int i = 0;

    for (int j = 0; j < nums.length; j++) {

      // goal here is to move all un removed number to front and doen't matter what we left behind
      // so no need to swap i and j just. just assign value of j to i.
     
      
      // if array value is not equal to value to be removed add it to an array 
      if (nums[j] != val) {
        // put value of unmatched element into new index in
        // existing array and increment slow pointer
        nums[i] = nums[j];
        i++;

      }

    }

    return i;
  }

  public static void main(String[] args) {

    int[] nums = { 3, 2, 2, 3 };
    int val = 3;

    // int[] nums = { 0, 1, 2, 2, 3, 0, 4, 2 };
    // int val = 2;
    System.out.println(removeElement(nums, val));

  }
}
