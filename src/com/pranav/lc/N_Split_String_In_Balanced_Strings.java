/**
 * 
 */
package com.pranav.lc;

/**
 * @author pranavpatel
 *         https://leetcode.com/problems/split-a-string-in-balanced-strings/submissions/
 *
 */
public class N_Split_String_In_Balanced_Strings {

  static int splitStringInBalancedString(String s) {

    int bc = 0;
    int rc = 0;
    int lc = 0;
    for (int i = 0; i < s.length(); i++) {

      if (s.charAt(i) == 'R') {
        rc++;

      }
      if (s.charAt(i) == 'L') {
        lc++;
      }

      if (rc == lc)
        bc++;

    }

    return bc;

  }

  public static void main(String[] args) {

    String str = "RLRRLLRLRL";

    System.out.println(splitStringInBalancedString(str));
  }
}
