/**
 * 
 */
package com.pranav.educative.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author pranavpatel
 * 
 * 
 *         time : O(N+M) where N and M are no of characters in the string and
 *         pattern respectively 
 *         
 *         space :O(M) no of char is patter in the worst
 *         case the whole pattern can have distinct characters which will go
 *         into the HashMap.
 *         
 *         we also need O(N) space for result list
 */
public class B1_String_Anagrams {

  public static List<Integer> findStringAnagrams(String str, String pattern) {
    List<Integer> resultIndices = new ArrayList<Integer>();
    Map<Character, Integer> map = new HashMap<>();

    int match = 0;
    int window_start = 0;

    char[] pattern_array = pattern.toCharArray();

    for (char ch : pattern_array) {

      map.put(ch, map.getOrDefault(ch, 0) + 1);

    }

    System.out.println(map);

    for (int window_end = 0; window_end < str.length(); window_end++) {

      char right_char = str.charAt(window_end);

      if (map.containsKey(right_char)) {

        map.put(right_char, map.get(right_char) - 1);

        if (map.get(right_char) == 0)
          match++;

      }
      
      
      
      if(match == map.size()) {
        
        resultIndices.add(window_start);
      }
      

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

    return resultIndices;
  }

  public static void main(String[] args) {
    System.out.println("Permutation exist: " + B1_String_Anagrams.findStringAnagrams("ppqp", "pq"));
    System.out.println("Permutation exist: " + B1_String_Anagrams.findStringAnagrams("abbcabc", "abc"));
  }

}
