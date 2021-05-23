/**
 * 
 */
package com.pranav.educative.A_slidingwindow;

/**
 * @author pranavpatel variable size window
 *
 */
public class B5_Longest_Subarray_Of_Sumk {

  public static int lengthOfLongestSubarr(int[] nums, int k) {

    int window_start = 0;
    int max_length = 0;
    int window_sum = 0;

    for (int window_end = 0; window_end < nums.length; window_end++) {

      window_sum = window_sum + nums[window_end];

      // if widow_sum == k get the window size and get the max
      if (window_sum == k) {
        max_length = Math.max(max_length, window_end - window_start + 1);
      }
      // while window_sum is greater than k keep sliding window and remove element
      // from sum
      else if (window_sum > k) {
        while (window_sum > k) {
          window_sum = window_sum - nums[window_start];
          window_start++;
        }
      }
    }
    return max_length;
  }

  public static void main(String[] args) {

    int[] arr = { 4, 1, 1, 1, 2, 3, 5 };
    int k = 5;

    System.out.println(lengthOfLongestSubarr(arr, k));
  }
}
