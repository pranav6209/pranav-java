/**
 * 
 */
package com.pranav.lc.arrayString;

/**
 * @author pranavpatel
 *
 *         https://leetcode.com/problems/implement-strstr/
 *
 *         two pointer , string
 */
public class K_Implement_StrStr {

  public static int implementStrStr(String hayStack, String needle) {

    if (hayStack == null || hayStack.isEmpty())
      return -1;
    if (needle == null || needle.isEmpty())
      return 0;
    if (needle.length() > hayStack.length())
      return -1;

    // variable to iterate over needle
    int j = 0;
    int i;
    for (i = 0; i < hayStack.length(); i++) {
      // System.out.println(hayStack.charAt(i));
      // System.out.println(needle.charAt(j));

      if (hayStack.charAt(i) == needle.charAt(j)) {
        j++;
      }
      /*
       * 
       * * when there is a first char match, j is greater than 0 and now if the second
       * char or other char doesn't match, beginning of the j should start matching with 
       * i=i-j, get the beginning index of haystack where earlier match started and then 
       * start matching it from next char of haystack and need from begining from j=0 
       * e.g "mississippi" and "issippi"
       */

      else {
        if (j > 0) {
          i = i - j;
          j = 0;
        }
      }

      // once there is a perfect match, to get i, subtract needle
      // length plus to get the start index of match
      if (j == needle.length())
        return i - j + 1;

    }
    return -1;

  }

  public static void main(String[] args) {

    System.out.println(implementStrStr("mississippi", "missippi"));
  }

}
