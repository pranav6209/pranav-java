/**
 * 
 */
package com.pranav.educative.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pranavpatel
 * 
 * 
 * time : O(N+M) where N and M are no of characters in the string and pattern respectively
 * space :O(M) no of char is patter in the worst case the whole pattern can have distinct characters which will go into the HashMap.
  *
 */
public class A9_Permutation_In_String {

  public static boolean findPermutation(String str, String pattern) {

    int window_start = 0;
    // char to be matched
    int match = 0;
    // put pattern char in to hashmap with freq
    char[] pattern_array = pattern.toCharArray();

    Map<Character, Integer> map = new HashMap<>();

    for (char ch : pattern_array) {

      map.put(ch, map.getOrDefault(ch, 0) + 1);

    }
    
    System.out.println(map);

    for (int window_end = 0; window_end < str.length(); window_end++) {

      char right_char = str.charAt(window_end);

      // when str starts matching, just update the map, not moving right window.
      if (map.containsKey(right_char)) {

        // update the map as we got the match
        map.put(right_char, map.get(right_char) - 1);

        // char is completely matched, if there are 2as or 2bs
        if (map.get(right_char) == 0)
          match++;

      }

      if (match == map.size())
        return true;

      // when we have max length covered,move window_start window and add char going out back to map and update the match

      if (window_end >= pattern.length() - 1) {

        char left_char = str.charAt(window_start);
        if (map.containsKey(left_char)) {

          if (map.get(left_char) == 0)
            match--;

          map.put(left_char, map.get(left_char) + 1);

        }

        window_start++;

      }

    }

    return false;

  }

  public static void main(String[] args) {
//    System.out.println("Permutation exist: " + A9_Permutation_In_String.findPermutation("oidbcaf", "abc"));
//    System.out.println("Permutation exist: " + A9_Permutation_In_String.findPermutation("odicf", "dc"));
    System.out.println("Permutation exist: " + A9_Permutation_In_String.findPermutation("bcdxabcdy", "bcdyabcdx"));
//    System.out.println("Permutation exist: " + A9_Permutation_In_String.findPermutation("aaacb", "abc"));
  }

}
