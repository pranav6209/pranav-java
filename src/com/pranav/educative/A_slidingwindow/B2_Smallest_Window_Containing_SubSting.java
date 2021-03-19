/**
 * 
 */
package com.pranav.educative.A_slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pranavpatel
 * 
// * https://leetcode.com/problems/minimum-window-substring
 *
 */
public class B2_Smallest_Window_Containing_SubSting {

  public static String findSubstring(String str, String pattern) {

    if(str.equals(pattern)) return str;
    
    Map<Character, Integer> map = new HashMap<>();

    int matched = 0;
    int window_start = 0;
    int min_length = str.length() + 1;
    int sub_str_start = 0;

    char[] pattern_array = pattern.toCharArray();

    for (char ch : pattern_array) {

      map.put(ch, map.getOrDefault(ch, 0) + 1);

    }

    for (int window_end = 0; window_end < str.length(); window_end++) {

      char right_char = str.charAt(window_end);

      if (map.containsKey(right_char)) {

        map.put(right_char, map.get(right_char) - 1);

        // count every matching of a character, not only when it is == 0, to cover scenarios where patterns has dups
        // we are doing match == pattern.length() so we have to increments with each char match not when it zero
        
        // also in the previous examples we are doing matched == map.size() means we are matching complete character
        // here we are doing matched == patern.length()  so we have to increment match with each map
        if (map.get(right_char) >= 0) 
          matched++;

      }
      
      // all the character is matched start decreasing window from start until we loose the match 
      while (matched == pattern.length()) {

        if (min_length > window_end - window_start + 1) {

          min_length = window_end - window_start + 1;
          sub_str_start = window_start;

        }

        char left_char = str.charAt(window_start);

        if (map.containsKey(left_char)) {

          if (map.get(left_char) == 0)
            matched--;

          map.put(left_char, map.get(left_char) + 1);
        }

        window_start++;

      }

    }

    return min_length > str.length() ? "" : str.substring(sub_str_start, sub_str_start+min_length);
  }

  public static void main(String[] args) {
    System.out.println(B2_Smallest_Window_Containing_SubSting.findSubstring("aabdec", "abc"));
    System.out.println(B2_Smallest_Window_Containing_SubSting.findSubstring("abdabca", "abc"));
    System.out.println(B2_Smallest_Window_Containing_SubSting.findSubstring("adcad", "abc"));
    System.out.println(B2_Smallest_Window_Containing_SubSting.findSubstring("aa", "aa"));
    System.out.println(B2_Smallest_Window_Containing_SubSting.findSubstring("bbaa", "aba"));
  }

}
