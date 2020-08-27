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
  public static int findLength(String S, int k) {
    int longest_sub_string_length_so_far = 0;
    int current_sub_string_length = 0;
    int windowStart = 0;

    Map<Character, Integer> map = new HashMap<>();

    for (int windowEnd = 0; windowEnd < S.length(); windowEnd++) {
      
      
      char rightChar = S.charAt(windowEnd);
      
      map.put(rightChar,map.getOrDefault(rightChar, 0)+1);
      
//
//      if (map.containsKey(S.charAt(windowEnd))) {
//
//        map.put(S.charAt(windowEnd), map.get(S.charAt(windowEnd)) + 1);
//
//      } else {
//        map.put(S.charAt(windowEnd), 1);
//      }
      
      // shrink the sliding window, until we are left with 'k' distinct characters in the frequency map
      while (map.size() > k) {
        
        char leftChar = S.charAt(windowStart);
        
        // update the map count of the char going out 
        map.put(leftChar, map.get(leftChar) - 1);

        // if char value is 0 remove it from map
        if (map.get(leftChar) == 0) {
          map.remove(leftChar);
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

    System.out.println("Length of the longest substring: " + A4_Longest_Substring_with_K_Distinct_Characters.findLength("araaci", 2));
    System.out.println("Length of the longest substring: " + A4_Longest_Substring_with_K_Distinct_Characters.findLength("araaci", 1));
    System.out.println("Length of the longest substring: " + A4_Longest_Substring_with_K_Distinct_Characters.findLength("cbbebi", 3));

  }

}
