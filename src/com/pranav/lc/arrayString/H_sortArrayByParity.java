/**
 * 
 */
package com.pranav.lc.arrayString;

import java.util.Arrays;

/**
 * @author pranavpatel
 * 
 *         https://leetcode.com/problems/sort-array-by-parity
 *
 */
public class H_sortArrayByParity {

  public static int[] sortArrayByParity(int[] nums) {

    int i = 0;

    for (int j = 0; j < nums.length; j++) {

      // get the even number and then move them at the front of the array using slow
      // index(i)
      if (nums[j] % 2 == 0) {
        // swap the number using temp variables and put them at fast index(j)
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        i++;

      }

    }

    return nums;

  }

  public static void main(String[] args) {

    int[] nums = { 3, 1, 2, 4 };

    System.out.println(Arrays.toString(sortArrayByParity(nums)));

  }
}
