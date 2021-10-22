/**
 * 
 */
package com.pranav.educative.L_Dynamic_Programming;

/**
 *  Aditya verma solution at the end. it passes all the test cases. just use that approach
 *  
 *  for String "abdbca"  longest palindromic subsequence is abdba and its length is 5
 *  
 *  https://leetcode.com/problems/longest-palindromic-subsequence/submissions/
 */
public class C5_1_Longest_Palindrominc_Subsequence {

  public int findLPSLengthRecursive(String s) {
    return findLPSLengthRecursiveCall(s, 0, s.length() - 1);
  }

  private int findLPSLengthRecursiveCall(String s, int startIndex, int endIndex) {

    // startIndex > endIndex is not possible return 0
    if (startIndex > endIndex)
      return 0;
    // startIndex = endIndex we have at lease length of 1
    if (startIndex == endIndex)
      return 1;
    // case 1: elements at the beginning and the end are the same
    if (s.charAt(startIndex) == s.charAt(endIndex))
      return 2 + findLPSLengthRecursiveCall(s, startIndex + 1, endIndex - 1);

    // case 2: skip one element either from the beginning or the end
    else
      return Math.max(
        findLPSLengthRecursiveCall(s, startIndex + 1, endIndex),
        findLPSLengthRecursiveCall(s, startIndex, endIndex - 1));
  }

  public int findLPSLengthTopDown(String s) {
    Integer[][] dp = new Integer[s.length()][s.length()];
    return findLPSLengthTopDownCall(dp, s, 0, s.length() - 1);
  }

  private int findLPSLengthTopDownCall(Integer[][] dp, String s, int startIndex, int endIndex) {

    // startIndex > endIndex is not possible return 0
    if (startIndex > endIndex)
      return 0;
    // startIndex = endIndex we have at lease length of 1
    if (startIndex == endIndex)
      return 1;

    if (dp[startIndex][endIndex] == null) {

      // case 1: elements at the beginning and the end are the same
      if (s.charAt(startIndex) == s.charAt(endIndex))
        dp[startIndex][endIndex] = 2 + findLPSLengthRecursiveCall(s, startIndex + 1, endIndex - 1);

      // case 2: skip one element either from the beginning or the end
      else
        dp[startIndex][endIndex] = Math.max(
          findLPSLengthRecursiveCall(s, startIndex + 1, endIndex),
          findLPSLengthRecursiveCall(s, startIndex, endIndex - 1));
    }
    return dp[startIndex][endIndex];
  }

  public int findLPSLengthBottomUp(String s) {
    return findLCSLengthBottomUp(
      s,
      new StringBuilder(s).reverse()
        .toString());
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
    C5_1_Longest_Palindrominc_Subsequence lps = new C5_1_Longest_Palindrominc_Subsequence();
    System.out.println(lps.findLPSLengthBottomUp("abdbca"));
    System.out.println(lps.findLPSLengthRecursive("abdbca"));
    System.out.println(lps.findLPSLengthTopDown("abdbca"));
    
    System.out.println(lps.findLPSLengthBottomUp("cddpd"));
    System.out.println(lps.findLPSLengthRecursive("cddpd"));
    System.out.println(lps.findLPSLengthTopDown("cddpd"));
    
    System.out.println(lps.findLPSLengthBottomUp("pqr"));
    System.out.println(lps.findLPSLengthRecursive("pqr"));
    System.out.println(lps.findLPSLengthTopDown("pqr"));
    
    System.out.println(lps.findLPSLengthBottomUp("bbbab"));
    System.out.println(lps.findLPSLengthRecursive("bbbab"));
    System.out.println(lps.findLPSLengthTopDown("bbbab"));
    
    System.out.println(lps.findLPSLengthBottomUp("cbbd"));
    System.out.println(lps.findLPSLengthRecursive("cbbd"));
    System.out.println(lps.findLPSLengthTopDown("cbbd"));
  }

}
