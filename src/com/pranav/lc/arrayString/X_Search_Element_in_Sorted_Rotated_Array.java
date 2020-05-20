/**
 * 
 */
package com.pranav.lc.arrayString;

/**
 * @author pranavpatel
 * 
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * https://www.youtube.com/watch?v=5BI0Rdm9Yhk
 *
 */
public class X_Search_Element_in_Sorted_Rotated_Array {

  public static int search(int[] nums, int target) {
    /* check for the empty and when the length of array is one */
    if (nums.length == 0)
      return -1;
    if (nums.length == 1)
      // if target equals to element return 0 ( only one index else -1)
      return nums[0] == target ? 0 : -1;

    /* initialize the variables which needs to be passed */
    int result = 0; // will not be passed
    int start = 0;
    int end = nums.length - 1;
    
    if (nums[start] < nums[end]) {
      /* Just do the simple binary search on the sorted array */
      result = binarySearch(start, end, nums, target);
    } else {
      /* Find the point of Inflection/Pivot */
      int index = findPivot(start, end, nums);

      /* check in which sorted array does our target may lie */
      if (target >= nums[index] && target <= nums[end]) {
        result = binarySearch(index, end, nums, target);
      } else {
        /* lies in the left sorted of the inflection */
        result = binarySearch(start, index - 1, nums, target);
      }
    }
    return result;
  }

  private static int findPivot(int start, int end, int[] nums) {
    int mid = start + (end - start) / 2;
    int foundIndex = 0;
    /* Base case for recursion */
    /*
     * If array would have been sorted the successor element on the array would have
     * been greater than it's previous index element, we have leveraged that idea in
     * our favor to find the point of infection
     */
    if (nums[mid] > nums[mid + 1]) {
      return mid + 1;
    } else {
      if (nums[start] > nums[mid]) {
        /*
         * means point of infection lies on left of current mid, hence shift end to mid
         * -1
         */
        foundIndex = findPivot(start, mid - 1, nums);
      } else {
        /*
         * means point of infection lies on right of current mid, hence shift start to
         * mid + 1
         */
        foundIndex = findPivot(mid + 1, end, nums);
      }
    }
    return foundIndex;
  }

  /* Simple Binary Search Algorithm */
  private static int binarySearch(int start, int end, int[] nums, int target) {
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (nums[mid] == target)
        return mid;
      else if (target > nums[mid])
        start = mid + 1;
      else
        end = mid - 1;
    }
    return -1;
  }

  public static void main(String[] args) {

    // int[] nums = { 4, 5, 6, 7, 8, 1, 2 };
    // int[] nums = { 5, 1, 3 };
    int[] nums = { 1, 3 };
    int target = 0;
    System.out.println(search(nums, target));
  }
}
