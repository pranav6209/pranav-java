/**
 * 
 */
package com.pranav.educative.L_Dynamic_Programming;

/**
 https://leetcode.com/problems/is-subsequence/
 
 try to solve using 2 pointer approach from leetcode solution. that is 
 easier then DP 
 */

public class C8_Sequence_Pattern_Matching {

  public boolean isSubsequence(String s, String t) {
    
    // if the longest subsequence length is same as s, return true
    return s.length() == findLCSLengthBottomUp(s, t);

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

    for (int i = 1; i <= m ; i++) {
      for (int j = 1; j <= n; j++) {

        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }

      }
    }

    return dp[m][n];
  }

  public static void main(String[] args) {
    C8_Sequence_Pattern_Matching is = new C8_Sequence_Pattern_Matching();
    System.out.println(is.isSubsequence("abc", "ahbgdc"));
  }

}
