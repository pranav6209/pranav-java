/**
 * 
 */
package com.pranav.lc.arrayString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pranavpatel
 * 
 *         https://leetcode.com/problems/repeated-substring-pattern/
 *
 */
public class L_Repeated_Substring_Pattern {

  public static boolean repeatedSubstringPattern(String s) {
    int n = s.length();
    // starting with minimum repeat 2, if string length is 9 and repeat starts with
    // 2,
    // that substring is not valid, skip that and increase repeat
    for (int repeat = 2; repeat <= n; repeat++) {
      // no of times string is repeating and string length mode is not zero means
      // there is no repetition
      if (n % repeat != 0)
        continue;
      int currentSubstrLen = n / repeat;
      // variable that will start form the currentSubstrLen and iterate through string
      // length
      int j = currentSubstrLen;

      String currentSubstr = s.substring(0, currentSubstrLen);

      for (j = currentSubstrLen; j < n; j += currentSubstrLen) {
        while (j != n) {
          // System.out.println(s.substring(currentSubstrLen));
          if (!currentSubstr.equals(s.substring(j, j + currentSubstrLen)))
            break;
          // j += currentSubstrLen;
        }
      }
      if (j == n)
        return true;
    }
    return false;
  }

  public static void main(String[] args) {

    String str = "ababab";
    // String str = "abcabcabcabc";

    System.out.println(repeatedSubstringPattern(str));

  }

}
