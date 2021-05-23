/**
 * 
 */
package com.pranav.educative.A_slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pranavpatel
 *
 */

public class A4_Longest_Substring_with_K_Distinct_Characters {

  // time O(N)
  // space O(K) - as we are storing only k+1 char in hashmap
  
  //  https://www.youtube.com/watch?v=Lav6St0W_pQ&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=11&ab_channel=AdityaVerma
  public static int findLength(String S, int k) {

    int max_length = Integer.MIN_VALUE;
    int window_start = 0;

    Map<Character, Integer> map = new HashMap<>();

    for (int window_end = 0; window_end < S.length(); window_end++) {
      char rightChar = S.charAt(window_end);
      map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);

      
      /*
       * if (map.containsKey(S.charAt(windowEnd))) {
       * map.put(S.charAt(windowEnd), map.get(S.charAt(windowEnd)) + 1);
       *      } else {
       *      map.put(S.charAt(windowEnd), 1);
       *    }
       * }
       *      
       */

      if (map.size() == k) {

        max_length = Math.max(max_length, window_end - window_start + 1);

      }

      // shrink the sliding window, until we are left with 'k' distinct characters in the frequency map
      
      else if (map.size() > k) {
        while (map.size() > k) {
          char leftChar = S.charAt(window_start);

          // update the map count of the char going out
          map.put(leftChar, map.get(leftChar) - 1);

          // if char value is 0 remove it from map
          if (map.get(leftChar) == 0) {
            map.remove(leftChar);
          }

          window_start++;
        }
      }

    }

    return max_length;
  }

  public static void main(String[] args) {

    System.out.println(
      "Length of the longest substring: " + A4_Longest_Substring_with_K_Distinct_Characters.findLength("araaci", 2));
    System.out.println(
      "Length of the longest substring: " + A4_Longest_Substring_with_K_Distinct_Characters.findLength("araaci", 1));
    System.out.println(
      "Length of the longest substring: " + A4_Longest_Substring_with_K_Distinct_Characters.findLength("cbbebi", 3));

  }

}
