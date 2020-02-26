/**
 * 
 */
package com.pranav.lc;

import java.util.Arrays;

/**
 * @author pranavpatel
 * 
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/submissions/
 * 
 * Array two pointer ( Binary Search )
 * 1. 1st Pointer start from beginning and 2nd pointer starts from end 
 * They move toward each other until they both meet. . 

 *
 */
public class B_twoSumSortedArray {

  public static int[] twoSum(int[] numbers, int target) {

    for (int i = 0; i < numbers.length; i++) {

      int complement = target - numbers[i];

      //how??
      if (complement == numbers[i])
        return new int[] { i + 1, i + 2 };

      // calling binary search with array,left index, right index and search element
      int searchElementInedx = binarySearch(numbers, 0, numbers.length, complement);

      if (searchElementInedx != -1) {

        return new int[] { i + 1, searchElementInedx + 1 };
      }

    }

    throw new RuntimeException("No Match Found");

  }

  
  // Binary search with recursive approach. better explanation CTCI 6 page no :149 
  public static int binarySearch(int arr[], int l, int r, int x) {
        
    while (l <= r) {
      int mid = l + (r - l) / 2;

      // If the element is present at the
      // middle itself
      if (arr[mid] == x)
        return mid;

      // If element is smaller than mid, then
      // it can only be present in left subarray
      if (arr[mid] > x)
        return binarySearch(arr, l, mid - 1, x);

      // Else the element can only be present
      // in right subarray
      return binarySearch(arr, mid + 1, r, x);

      // if we reach here, then element was
      // not present
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] nums = { 1, 4, 3, 4, 9, 56, 90 };
    int target = 8;

    System.out.println(Arrays.toString(twoSum(nums, target)));

  }

}
