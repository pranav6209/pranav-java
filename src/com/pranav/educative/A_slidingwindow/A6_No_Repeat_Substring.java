/**
 * 
 */
package com.pranav.educative.A_slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pranavpatel
 * 
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 *   // time O(N)
  // space O(K) - as we are storing only k+1 char in hashmap
 *
 */
public class A6_No_Repeat_Substring {

  public static int findLength(String str) {
    int window_start = 0;
    int res = 0;
    
    // map to store, Character and index of that Character
    Map<Character, Integer> map = new HashMap<>();

    if (str == null | str.isEmpty())
      return res;

    for (int window_end = 0; window_end < str.length(); window_end++) {

      char right_char = str.charAt(window_end);

      if (map.containsKey(right_char)) {

//          Here’s an example why we need max when setting window_start:
        
//          Let’s look at an input string of “abcba”
//
//          For the first three letters, the map will will have {“A”: 0, “B”: 1, “C”: 2}.
//
//          Then we get to the second “B”. Right now, window_end = 3, window_start = 0, and"B" is already in our map.
//          So we set window_start = map.get(right_char) + 1 = 2 which is “C”. All good and no need for the max(). Then we update our map for this second “B” to {“A”: 0, “B”: 3, “C”: 2}.
//
//          Then we reach the last “A”. Right now, window_start = 2, window_end = 4.
//          We can see that there’s no conflict here with this “A”, and we should not change window_start, but our program does not know that. It will check to see if “A” is in the map, which it is. In the map “A” has a value of 0. We do not want to change window_start to become 1, but keep it as it is at 2. Hence max() is needed.
        
        
        // basically we do not want to push back or window_start, if map contains letter that is before then what current index is,at that time we want to choose max 

 
        
        
        window_start = Math.max(window_start, map.get(right_char) + 1);

      }

      
     
      map.put(right_char, window_end);

      res = Math.max(res, window_end - window_start + 1);

    }

    return res;

  }

  public static void main(String[] args) {
    System.out.println("Length of the longest substring: " + A6_No_Repeat_Substring.findLength("abcba"));
    System.out.println("Length of the longest substring: " + A6_No_Repeat_Substring.findLength("aabccbb"));
    System.out.println("Length of the longest substring: " + A6_No_Repeat_Substring.findLength("abbbb"));
    System.out.println("Length of the longest substring: " + A6_No_Repeat_Substring.findLength("abccde"));
  }

}
