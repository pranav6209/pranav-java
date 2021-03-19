/**
 * 
 */
package com.pranav.educative.A_slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author pranavpatel
 *
 */

// time O(N*K) -
// space O(N) - if we consider o/p array

// more like a 2 - pointer approach
public class A1_avg_of_all_contiguos_subarray {

  // ask if it is ok to retuen list
  public static double[] findAvgIterative(int[] nums, int k) {

    double[] res = new double[nums.length - k + 1];

    // left pointer will max go to nums.length-k
    for (int left = 0; left <= nums.length - k; left++) {
      double sum = 0;
      // right starts with left always and goes to max to k at a time 
      for (int right = left; right < left + k; right++) {
        sum = sum + nums[right];
      }
      // get the avg and add it to array
      res[left] = sum / k;
    }
    return res;
  }

  // time O(N)
  // space O(N) - if we consider o/p array
  public static double[] findAvgSlidingWindow(int[] nums, int k) {

    
    // just take an example of 7 length array , it will be 3 elements and then make
    // this pattern
    double[] res = new double[nums.length - k + 1];

    double window_sum = 0;
    int window_start = 0;
    for (int window_end = 0; window_end < nums.length; window_end++) {

      window_sum = window_sum + nums[window_end]; // add the next element

      // slide the window, we don't need to slide if we've not hit the required window
      // size of 'k'
      // so for first 4 index, it will not go here and then it will start adding each
      // element and removing it
      if (window_end >= k - 1) {

        res[window_start] = window_sum / k; // window_avg
        window_sum = window_sum - nums[window_start]; // remove element going out of window
        window_start++;// increase the left counter
      }

    }

    return res;
  }

  public static void main(String[] args) {

//    double[] res = findAvgIterative(new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 }, 5);
//
//    double[] result1 = findAvgSlidingWindow(new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 }, 5);
//
//    System.out.println(Arrays.toString(res));
//    System.out.println(Arrays.toString(result1));
    
    System.out.println("p12passphrase".toCharArray());

  }

}
