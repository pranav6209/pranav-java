/**
 * 
 */
package com.pranav.educative.A_slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pranavpatel
 * 
 *         https://leetcode.com/problems/longest-repeating-character-replacement/
 * 
 *         // time O(N) // space O(K) - as we are storing only k+1 char in
 *         hashmap
 *
 */
public class A7_Longest_Substring_Same_Letters_After_Replacement {

  public static int findLength(String str, int k) {

    int window_start = 0, maxLength = 0, maxRepeatLetterCount = 0;
    Map<Character, Integer> letterFrequencyMap = new HashMap<>();
    // try to extend the range [windowStart, windowEnd]
    for (int window_end = 0; window_end < str.length(); window_end++) {
      char rightChar = str.charAt(window_end);
      letterFrequencyMap.put(rightChar, letterFrequencyMap.getOrDefault(rightChar, 0) + 1);
      
      // for aab we do want letter count to be 1 rather we need 2 ;
      maxRepeatLetterCount = Math.max(maxRepeatLetterCount, letterFrequencyMap.get(rightChar));
      
//      https://leetcode.com/problems/longest-repeating-character-replacement/discuss/91271/Java-12-lines-O(n)-sliding-window-solution-with-explanation

//      In case anyone is confused by this solution, here's another way of explaining it:
//
//      end-start+1 = size of the current window
//      maxCount = largest count of a single, unique character in the current window
//
//      The main equation is: end-start+1-maxCount
//
//      When end-start+1-maxCount == 0, then then the window is filled with only one character
//      When end-start+1-maxCount > 0, then we have characters in the window that are NOT the character that occurs the most. end-start+1-maxCount is equal to exactly the # of characters that are NOT the character that occurs the most in that window. Example: For a window "xxxyz", end-start+1-maxCount would equal 2. (maxCount is 3 and there are 2 characters here, "y" and "z" that are not "x" in the window.)
//
//      We are allowed to have at most k replacements in the window, so when end-start+1-maxCount > k, then there are more characters in the window than we can replace, and we need to shrink the window.
//
//      If we have window with "xxxy" and k = 1, that's fine because end-start+1-maxCount = 1, which is not > k. maxLength gets updated to 4.
//
//      But if we then find a "z" after, like "xxxyz", then we need to shrink the window because now end-start+1-maxCount = 2, and 2 > 1. The window becomes "xxyz".
//
//      maxCount may be invalid at some points, but this doesn't matter, because it was valid earlier in the string, and all that matters is finding the max window that occurred anywhere in the string. Additionally, it will expand if and only if enough repeating characters appear in the window to make it expand. So whenever it expands, it's a valid expansion.
//
//      Hope that helps.
//
//      P.S. Yes, as several other people mentioned already, the while should be replaced with if. The time complexity is exactly the same, because the while-loop only runs once anyway.
      
      
      if (window_end - window_start + 1 - maxRepeatLetterCount > k) {
        char leftChar = str.charAt(window_start);
        letterFrequencyMap.put(leftChar, letterFrequencyMap.get(leftChar) - 1);
        window_start++;
      }

      maxLength = Math.max(maxLength, window_end - window_start + 1);
    }

    return maxLength;

  }

  public static void main(String[] args) {
    System.out.println(A7_Longest_Substring_Same_Letters_After_Replacement.findLength("aabccbb", 2));
    System.out.println(A7_Longest_Substring_Same_Letters_After_Replacement.findLength("abbcb", 1));
    System.out.println(A7_Longest_Substring_Same_Letters_After_Replacement.findLength("abccde", 1));
  }

}
