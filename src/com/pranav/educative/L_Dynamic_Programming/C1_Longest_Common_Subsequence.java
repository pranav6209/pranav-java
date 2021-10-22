
/**
 * 
 */
package com.pranav.educative.L_Dynamic_Programming;

/**
 * @author pranavpatel
 * 
 *    insubsequence we have to preserve the order
 * 
 *          make sure dp[][] is not same as educative. diff logic then one in educative
 * 
 *         https://leetcode.com/problems/longest-common-subsequence/submissions/
 *         
 *           
 *    
 *
 */
public class C1_Longest_Common_Subsequence {
  public int findLCSLength(String s1, String s2) {

    return findLCSLengthRecursive(s1, s2, s1.length(), s2.length());
  }

  private int findLCSLengthRecursive(String s1, String s2, int m, int n) {

    if (m == 0 || n == 0)
      return 0;
    if (s1.charAt(m - 1) == s2.charAt(n - 1))
      return 1 + findLCSLengthRecursive(s1, s2, m - 1, n - 1);
    else {
      return Math.max(findLCSLengthRecursive(s1, s2, m, n - 1), findLCSLengthRecursive(s1, s2, m - 1, n));
    }
  }
  
  public int findLCSLengthTopDown(String s1, String s2) {
    int m = s1.length();
    int n = s2.length();
    
    int [][] dp = new int[m+1][n+1];
    return findLCSLengthTopdownRecursive(s1, s2, m, n,dp);
  }

  private int findLCSLengthTopdownRecursive(String s1, String s2, int m, int n, int[][]dp) {

    if (m == 0 || n == 0)
      return 0;
    
    if(dp[m][n]!=-1) return dp[m][n];
    
    if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
      dp[m][n] = 1+findLCSLengthRecursive(s1, s2, m - 1, n - 1);
      return dp[m][n];
    } 
    else {
   
      dp[m][n] = Math.max(findLCSLengthTopdownRecursive(s1, s2, m, n - 1,dp), findLCSLengthTopdownRecursive(s1, s2, m - 1, n,dp));
      return dp[m][n];
    }
  }

  private int findLCSLengthBottomUp(String text1, String text2) {

    int m = text1.length();
    int n = text2.length();

    if (m <= 0 || n <= 0)
      return 0;

    int[][] dp = new int[m + 1][n + 1];

    // initialize first row and col with 0 as we longest common subsequence is 0
    // with either one string being zero(empty)
    for (int i = 0; i <= m; i++) {
      for (int j = 0; j <= n; j++) {
        if (i == 0 || j == 0)
          dp[i][j] = 0;
      }
    }

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        /*
         * if current char matches, 1+ diagonal cell value. 1 for matching that char and we have to 
         * decrease both index by 1 for smaller subproblem.
         */
        if (text1.charAt(i - 1) == text2.charAt(j - 1))
          dp[i][j] = 1 + dp[i - 1][j - 1];
        else
          /*
           * 
           * if we do not have a match, we decrease i and keep j same or decrease j and keep i same.
           * for smaller subproblems, max out of both is answer
           */
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);

      }
    }

    System.out.println(printLongestCommonSubsequence(text1, text2, dp));
    return dp[m][n];
  }

  public String printLongestCommonSubsequence(String s1, String s2, int[][] dp) {

    int m = s1.length(), n = s2.length();
    StringBuffer res = new StringBuffer();

    while (m > 0 && n > 0) {


       //if (s1.charAt(m - 1) == s2.charAt(n - 1)) {

      // instead of above logic, below logic makes more sense 10/20/2021
         
      // if current cell value is not equal to one in left or top then it is for sure coming from diagonal 
      // above logic or below is same  
         
         
      if(dp[m][n]!=dp[m][n-1] && dp[m][n]!=dp[m-1][n]) {
        res.append(s1.charAt(m - 1));
        m--;
        n--;
      } else {
        // if top cell is bigger than left cell decrease m
        if (dp[m - 1][n] > dp[m][n - 1]) {
          m--;
        } else{
          n--;
        }

      }

    }

    return res.reverse()
      .toString();

  }

  public static void main(String[] args) {
    C1_Longest_Common_Subsequence lcs = new C1_Longest_Common_Subsequence();
//    System.out.println(lcs.findLCSLength("abdca", "cbda"));
//    System.out.println(lcs.findLCSLength("passport", "ppsspt"));
    System.out.println(lcs.findLCSLengthBottomUp("abac", "cab"));
//    System.out.println(lcs.findLCSLengthBottomUp("abdca", "cbda"));
//    System.out.println(lcs.findLCSLengthBottomUp("passport", "ppsspt"));

  }
}
