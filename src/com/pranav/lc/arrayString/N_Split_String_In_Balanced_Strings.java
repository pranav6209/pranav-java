/**
 * 
 */
package com.pranav.lc.arrayString;

/**
 * @author pranavpatel
 *         https://leetcode.com/problems/split-a-string-in-balanced-strings/
 *
 */
public class N_Split_String_In_Balanced_Strings {

  static int splitStringInBalancedString(String s) {
    // balanced string count
    int bc = 0;
    // R count
    int rc = 0;
    // L count
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
