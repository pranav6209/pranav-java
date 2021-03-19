/**
 * 
 */
package com.pranav.educative.L_Dynamic_Programming;

/**
 * @author pranavpatel
 *
 */
public class C4_Longest_Repeating_Subsequence {

  private void findMDI(String s1, String s2) {
    System.out.println(findLCSLengthBottomUp(s1, s2));
    System.out.println("Minimum Deletion Needed:- " + (s1.length() - findLCSLengthBottomUp(s1, s2)));
    System.out.println("Minimum Deletion Needed:- " + (s2.length() - findLCSLengthBottomUp(s1, s2)));
  }

  private int findLCSLengthBottomUp(String s1, String s2) {
    int m = s1.length(), n = s2.length();

    int[][] dp = new int[m + 1][n + 1];

    for (int i = 0; i < m+1; i++) {
      for (int j = 0; j < n+1; j++) {
        if (i == 0 || j == 0)
          dp[i][j] = 0;
      }
    }

    for (int i = 1; i < m+1; i++) {
      for (int j = 1; j < n+1; j++) {

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
    C4_Longest_Repeating_Subsequence mdi = new C4_Longest_Repeating_Subsequence();
    mdi.findMDI("abc", "fbc");
    mdi.findMDI("abdca", "cbda");
    mdi.findMDI("passport", "ppsspt");
  }

}
