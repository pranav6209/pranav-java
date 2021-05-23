/**
 * 
 */
package com.pranav.educative.A_slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pranavpatel
 * 
 *         problem is same as below but here they are taking integer array
 *         instead https://leetcode.com/problems/fruit-into-baskets/
 * 
 * 
 *
 */

public class A5_Fruit_into_baskets {

  // time O(N)
  // space O(K) - as we are storing only k+1 char in hashmap
  public static int findLength(char[] arr) {

    int max_length = Integer.MIN_VALUE;
    int window_start = 0;

    Map<Character, Integer> map = new HashMap<>();

    for (int window_end = 0; window_end < arr.length; window_end++) {
      char rightChar = arr[window_end];
      map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);

      if (map.size() == 2) {

        max_length = Math.max(max_length, window_end - window_start + 1);

      }

      // shrink the sliding window, until we are left with 'k' distinct characters in
      // the frequency map

      else if (map.size() > 2) {
        while (map.size() > 2) {
          char leftChar = arr[window_start];

          // update the map count of the char going out
          map.put(leftChar, map.get(leftChar) - 1);

          // if char value is 0 remove it from map
          if (map.get(leftChar) == 0) {
            map.remove(leftChar);
          }

          window_start++;
        }
      }
      // to cover the scenarios of i/p [0] o/p 1 and i/p [1,1] o/p 2
      // when window size is not his still we want to calculate max_length
      max_length = Math.max(max_length, window_end - window_start + 1);
    }

    return max_length;
  }

  public static void main(String[] args) {

    System.out.println(
      "Maximum number of fruits:" + A5_Fruit_into_baskets.findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }));
    System.out.println(
      "Maximum number of fruits:" + A5_Fruit_into_baskets.findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));

  }

}
