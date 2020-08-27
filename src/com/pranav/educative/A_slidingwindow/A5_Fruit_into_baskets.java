/**
 * 
 */
package com.pranav.educative.A_slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pranavpatel
 * 
 * problem is same as below but here they are taking integer array instead
 * https://leetcode.com/problems/fruit-into-baskets/
 * 
 * 
 *
 */

public class A5_Fruit_into_baskets {

  // time O(N)
  // space O(K) - as we are storing only k+1 char in hashmap
  public static int findLength(char[] arr) {

    int longest_sub_string_length_so_far = 0;
    int current_sub_string_length = 0;
    int windowStart = 0;

    Map<Character, Integer> map = new HashMap<>();

    for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {

      map.put(arr[windowEnd], map.getOrDefault(arr[windowEnd], 0) + 1);

      // if (map.containsKey(arr[windowEnd])) {
      //
      // map.put(arr[windowEnd], map.get(arr[windowEnd]) + 1);
      //
      // } else {
      // map.put(arr[windowEnd], 1);
      // }

      // shrink the sliding window, until we are left with 'k' distinct characters in
      // the frequency map
      while (map.size() > 2) {

        // update the map count of the char going out
        map.put(arr[windowStart], map.get(arr[windowStart]) - 1);

        // if char value is 0 remove it from map
        if (map.get(arr[windowStart]) == 0) {
          map.remove(arr[windowStart]);
        }

        windowStart++;

      }

      // remember the maximum length so far
      current_sub_string_length = windowEnd - windowStart + 1;
      longest_sub_string_length_so_far = Math.max(longest_sub_string_length_so_far, current_sub_string_length);

    }

    return longest_sub_string_length_so_far;
  }

  public static void main(String[] args) {

    System.out.println(
      "Maximum number of fruits:" + A5_Fruit_into_baskets.findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }));
    System.out.println(
      "Maximum number of fruits:" + A5_Fruit_into_baskets.findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));

  }

}
