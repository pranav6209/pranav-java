/**
 * 
 */
package com.pranav.lc.arrayString;

/**
 * 
 * https://leetcode.com/problems/repeated-string-match/
 * @author pranavpatel
 *
 */
public class M_2_Repeated_String_Match2 {

  static int repeatedStringMatch(String A, String B) {

    StringBuilder sb = new StringBuilder(A);
    int i = 1;
    while (sb.length() < B.length()) {
      i++;
      sb.append(A);
    }
    int k = 0;
    
    // k has to be less than 0 as length is same now, both strings are same at this point or 
    // one more repetition max
    while (k < 2) {
      // The repeated version of A should have atleast B length. The possibility is
      // that the String A
      // is same as B or adding A one more time to the repeated A should contain it.
      
      System.out.println(sb.indexOf(B));
      if (sb.indexOf(B) == -1) {
        sb.append(A);
        i++;
      } else {
        return i;
      }
      k++;
    }
    return -1;
  }

  public static void main(String[] args) {

    String a = "abcd";
    String b = "cdabcdab";

    System.out.println(repeatedStringMatch(a, b));
  }

}
