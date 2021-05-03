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
 * https://www.youtube.com/watch?v=KtpqeN0Goro&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=3
 *
 */

// time O(N*K) -
// space O(N) - if we consider o/p array

// more like a 2 - pointer approach
public class A1_avg_of_all_contiguos_subarray {

  // brut force approach
  public static double[] findAvgIterative(int[] nums, int k) {

    
    // for array size 7 window size 3 prints array of size 5 that is why 7-3+1
    // for array size 7 window size 4 prints array of size 4 that is why 7-4+1
    
    
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

    // for array size 7 window size 3 prints array of size 5 that is why 7-3+1
    // for array size 7 window size 4 prints array of size 4 that is why 7-4+1
    
    double[] res = new double[nums.length - k + 1];

    double window_sum = 0;
    int window_start = 0;
    for (int window_end = 0; window_end < nums.length; window_end++) {

      window_sum = window_sum + nums[window_end]; // add the next element

      // how we decide window size window-end - window_start + 1
      //https://www.youtube.com/watch?v=KtpqeN0Goro&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=3
      
      
       /* we don't need to slide if we've not hit the required window size of 'k'
       so for first 4 index, it will not go here and then it will start adding each
       element and removing it*/
      if (window_end-window_start+1 == k) {

        res[window_start] = window_sum / k; // window_avg
        window_sum = window_sum - nums[window_start]; // remove element going out of window
        window_start++;// increase the left counter
      }

    }

    return res;
  }

  public static void main(String[] args) {

    double[] res = findAvgIterative(new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 }, 5);

    double[] result1 = findAvgSlidingWindow(new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 }, 5);
  

    System.out.println(Arrays.toString(res));
    System.out.println(Arrays.toString(result1));

    System.out.println("p12passphrase".toCharArray());

  }

}
