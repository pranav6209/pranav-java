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
    int i = 0;
    while (i < nums.length) {

      // get the index of the minimum element, initiate believing min_index is at i
      int min_indx = i;
      // iterate through all the elements of array starting from i+1 and then find the
      // minimum element in the array
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[j] < nums[min_indx]) {

          min_indx = j;
        }
      }

      // once we got the min swap it
      int temp = nums[i];
      nums[i] = nums[min_indx];
      nums[min_indx] = temp;

      System.out.println(Arrays.toString(nums));
      i++;
    }

    return nums;

  }

  public static void main(String[] args) {
    int[] nums = { 121, 4, 111, 3, 5, 120 };
    System.out.println(Arrays.toString(selectionSort(nums)));

  }

}
