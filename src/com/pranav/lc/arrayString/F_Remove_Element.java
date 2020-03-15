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
 */
public class F_Remove_Element {

  public static int removeElement(int[] nums, int val) {

    if (nums == null || nums.length == 0)
      return 0;

    int i = 0;

    for (int j = 0; j < nums.length; j++) {

      // if array value is not equal to value to be removed add it to an array
      //https://www.sears.com/beats-by-dr-dre-970103076m-solo-3-wireless/p-SPM9121718002?rrec=true
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
