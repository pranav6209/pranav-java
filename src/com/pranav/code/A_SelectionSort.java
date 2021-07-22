/**
 * 
 */
package com.pranav.code;

import java.util.Arrays;

/**
 * @author pranavpatel https://www.geeksforgeeks.org/selection-sort/
 */
public class A_SelectionSort {
  public static int[] selectionSort(int[] nums) {

    // here i is maintained for swapping
    for (int i = 0; i < nums.length; i++) {

      // get the index of the minimum element, initiate believing min_index is at i
      // int min_indx = i;
      // iterate through all the elements of array starting from i+1 and then find the
      // minimum element in the array
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[j] < nums[i]) {

          int temp = nums[i];
          nums[i] = nums[j];
          nums[j] = temp;
        }
      }
    }

    return nums;

  }

  public static void main(String[] args) {
    int[] nums = { 121, 4, 111, 3, 5, 120 };
    System.out.println(Arrays.toString(selectionSort(nums)));

  }

}
