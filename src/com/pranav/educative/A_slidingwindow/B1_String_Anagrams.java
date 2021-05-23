/**
 * 
 */
package com.pranav.educative.A_slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author pranavpatel
 *         https://leetcode.com/problems/find-all-anagrams-in-a-string/
 * 
 *         https://www.youtube.com/watch?v=MW4lJ8Y0xXk&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=7&ab_channel=AdityaVerma
 * 
 *         time : O(N+M) where N and M are no of characters in the string and
 *         pattern respectively
 * 
 *         space :O(M) no of char is patter in the worst case the whole pattern
 *         can have distinct characters which will go into the HashMap.
 * 
 *         we also need O(N) space for result list
 */
public class B1_String_Anagrams {

  public static List<Integer> findStringAnagrams(String str, String pattern) {
    List<Integer> resultIndices = new ArrayList<Integer>();
    Map<Character, Integer> map = new HashMap<>();

    // variable that we ll keep a count of so we do not have to traverse the loop to
    // see match
    int match = 0;
    int window_start = 0;
    int k = pattern.length();

    // creating a map from pattern
    char[] pattern_array = pattern.toCharArray();

    for (char ch : pattern_array) {

      map.put(ch, map.getOrDefault(ch, 0) + 1);

    }

    System.out.println(map);

    for (int window_end = 0; window_end < str.length(); window_end++) {

      // when we move window_end and if char is in pattern map

      // 1. reduce the count in map
      // 2. if value of that char is 0 increment the match count
      char right_char = str.charAt(window_end);

      if (map.containsKey(right_char)) {

        map.put(right_char, map.get(right_char) - 1);

        if (map.get(right_char) == 0)
          match++;

      }

      // when window_size is hit
      if (window_end - window_start + 1 == k) {

        // if we have match add the indices to the result
        if (match == map.size())

          resultIndices.add(window_start);

        // slide the window

        
        // 1. if the value of that char is 0 decrement the match count
        // 2. increase the count in map
        
        char left_char = str.charAt(window_start);

        if (map.containsKey(left_char)) {
          if (map.get(left_char) == 0) match--;
          map.put(left_char, map.get(left_char) + 1);
        }
        window_start++;
      }

    }

    return resultIndices;

  }

  public static void main(String[] args) {
    System.out.println("Permutation exist: " + B1_String_Anagrams.findStringAnagrams("ppqp", "pq"));
     System.out.println("Permutation exist: " +
     B1_String_Anagrams.findStringAnagrams("abbcabc", "abc"));
  }

}
