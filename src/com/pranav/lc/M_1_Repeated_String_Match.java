/**
 * 
 */
package com.pranav.lc;

/**
 * https://leetcode.com/problems/repeated-string-match/
 * 
 * two solutions 
 * 
 * @author pranavpatel
 *
 */
public class M_1_Repeated_String_Match {

  static int repeatedStringMatch(String A, String B) {

    for (int i = 0; i < A.length(); i++) {
      // iterate over A till the first char of b is matched.
      if (A.charAt(i) == B.charAt(0)) {
      // once matched, j iterate over B and startIx over A
        int count = 1;
        int j = 0;
        int startIx = i;
        // while A and B continue matching,
        while (j < B.length() && A.charAt(startIx) == B.charAt(j)) {
          j++;
          startIx++;
          // if iteration over A reaches the length and B is still not reach till end
          // start A from beginning and increase the count.
          if (startIx >= A.length() && j < B.length()) {
            startIx = startIx % A.length();
            count++;
          }
        }
        if (j == B.length())
          return count;
      }
    }
    return -1;
  }

  public static void main(String[] args) {

    String a = "abcd";
    String b = "cdabcdab";

    System.out.println(repeatedStringMatch(a, b));
  }

}
