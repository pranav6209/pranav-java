/**
 * 
 */
package com.pranav.educative.L_Dynamic_Programming;

/**
 * @author pranavpatel
 * 
 * Matrix in note
 * 
 * e.g AXXXY
 * Here is the explanation:
 * Read this: Given a string, print the longest repeating subsequence such that the two subsequences don’t have same string character at same position
 * The same Position is the twist here: A X X X Y ==> 
 * X of index1 is used in both but its position in both substrings is different. In the first subsequence, it comes at 1st index whereas in 
 * the second subsequence comes at the 0th index.
 * 
 * similar thing for fmff
 */

public class C7_Longest_Repeating_Subsequence {

  private int findLRSLength(String s) {
    return findLCSLengthBottomUp(s, s);
  }

  private int findLCSLengthBottomUp(String s1, String s2) {
    int m = s1.length(), n = s2.length();

    int[][] dp = new int[m + 1][n + 1];

    for (int i = 0; i < m + 1; i++) {
      for (int j = 0; j < n + 1; j++) {
        if (i == 0 || j == 0)
          dp[i][j] = 0;
      }
    }

    for (int i = 1; i < m + 1; i++) {
      for (int j = 1; j < n + 1; j++) {

        if (s1.charAt(i - 1) == s2.charAt(j - 1) && i != j) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }

      }
    }

    return dp[m][n];
  }

  public static void main(String[] args) {
    C7_Longest_Repeating_Subsequence lrs = new C7_Longest_Repeating_Subsequence();
    //System.out.println(lrs.findLRSLength("tomorrow"));
    //System.out.println(lrs.findLRSLength("aabdbcec"));
    System.out.println(lrs.findLRSLength("fmff"));
  }

}
