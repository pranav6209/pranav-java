/**
 * 
 */
package com.pranav.educative.L_Dynamic_Programming;

/*
 * To get the minimum no of deletion, we have to find length of 
 * longest palindromic subsequence and then subtract it from 
 * original string 
 * for String "abdbca" longest palindromic subsequence is abdba. its length is 5
 * and total length of string is 6. 6-5 = 1
 */
public class C6_Minimum_Deletions_String_to_make_Palindrome {

  private int findMinimumDeletions(String s) {
    return s.length()-findLCSLengthBottomUp(s, new StringBuilder(s).reverse().toString());
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
    C6_Minimum_Deletions_String_to_make_Palindrome mdsp = new C6_Minimum_Deletions_String_to_make_Palindrome();
    System.out.println(mdsp.findMinimumDeletions("abdbca"));
    System.out.println(mdsp.findMinimumDeletions("cddpd"));
    System.out.println(mdsp.findMinimumDeletions("pqr"));
  }

}
