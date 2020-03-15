/**
 * 
 */
package com.pranav.lc.arrayString;

/**
 * @author pranavpatel
 * 
 * https://leetcode.com/problems/longest-common-prefix/
 *
 */
public class D_longest_common_prefix {

  // Vertical scanning
  public static String longestCommonPrefix(String[] strs) {

    // https://stackoverflow.com/questions/27476845/what-is-the-difference-between-a-null-array-and-an-empty-array

    if (strs == null || strs.length == 0)
      return "";
    // get the first String
    String str1 = strs[0];
    // Iterate through First String Character
    for (int i = 0; i < str1.length(); i++) {
      /*
       * iterate through other strings and check if the prefix are same.starting with
       * j =1 to start with second string
       */
      char ch = str1.charAt(i);
      /*
       * when i reaches other strings length or when the char doesn't
       * match["pra","pr","pranav",]
       */
      for (int j = 1; j < strs.length; j++) {

        if (i == strs[j].length() || ch != strs[j].charAt(i)) {
          // return first string substring till i
          return str1.substring(0, i);

        }

      }

    }
    /*
     * if we are here means full string matches, so return full string in this case,
     * return will not happen from inner loop for
     */
    return str1;

  }

  public static void main(String[] args) {

    String[] strs = { "pra", "pr", "prana" };

    System.out.println(longestCommonPrefix(strs));
  }

}
