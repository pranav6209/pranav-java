/**
 * 
 */
package com.pranav.educative.slidingwindow;

/**
 * @author pranavpatel
 * 
 * 
 * https://leetcode.com/problems/minimum-size-subarray-sum/submissions/
 *
 */

public class A3_smallest_subarray_with_given_sum {

  // time O(N)
  // space O(1) -
  public static int findMinSubArray(int S, int[] arr) {
    
    // here we have to assign  Integer.MAX_VALUE as if we just assign 0, when we do math.min it will always get the zero.
    int windowSum = 0, minLength = Integer.MAX_VALUE;
    int windowStart = 0;
    for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
      windowSum += arr[windowEnd]; // add the next element
      // shrink the window as small as possible until the 'windowSum' is smaller than 'S'
      while (windowSum >= S) {
        minLength = Math.min(minLength, windowEnd - windowStart + 1);
        windowSum -= arr[windowStart]; // subtract the element going out
        windowStart++; // slide the window ahead
      }
    }

    return minLength == Integer.MAX_VALUE ? 0 : minLength;
  }

  public static void main(String[] args) {

    int res = findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });

    System.out.println(res);

  }

}
