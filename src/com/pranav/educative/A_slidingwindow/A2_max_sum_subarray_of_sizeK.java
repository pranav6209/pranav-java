/**
 * 
 */
package com.pranav.educative.A_slidingwindow;

import java.util.Arrays;

/**
 * @author pranavpatel
 *
 */

// time O(N*K)
// space O(1)
// more like a 2 - pointer approach
public class A2_max_sum_subarray_of_sizeK {

  // iterative 
  public static int findMaxSumSubArrayIterative(int k, int[] arr) {

    int max_sum_so_far = 0;
        
    for (int right = 0; right <= arr.length - k; right++) {

      int current_sum = 0;
      // left only iterate till it get k elements and sums it.
      for (int left = right; left < right + k; left++) {
        current_sum = current_sum + arr[left];
      }

      max_sum_so_far = Math.max(current_sum, max_sum_so_far);

    }
    return max_sum_so_far;
  }

  // time O(N)
  // space O(1) - 
  public static int findMaxSumSubArraySlidingWindow(int k, int[] arr) {

    if(arr ==null || arr.length==0) return 0;
    
    int max_sum_so_far = 0;
    int current_window_sum = 0;
    int window_start = 0;
    for (int window_end = 0; window_end < arr.length; window_end++) {

      current_window_sum = current_window_sum + arr[window_end]; // add the next element

      // slide the window, we don't need to slide if we've not hit the required window
      // size of 'k'
      // so for first k index, it will not go here and then it will start adding each
      // element
      if (window_end >= k - 1) {

        max_sum_so_far = Math.max(current_window_sum, max_sum_so_far);
        current_window_sum = current_window_sum - arr[window_start]; // remove element going out of window
        window_start++;// increase the left counter
        
      }
      

    }

    return max_sum_so_far;
  }

  public static void main(String[] args) {

   int res  = findMaxSumSubArrayIterative(2, new int[] {2, 3, 4, 1, 5});

   int res1 = findMaxSumSubArraySlidingWindow(2, new int[] {2, 3, 4, 1, 5});

    System.out.println(res);
    System.out.println(res1);

  }

}
