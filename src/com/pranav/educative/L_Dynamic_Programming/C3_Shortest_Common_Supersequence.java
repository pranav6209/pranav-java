
package com.pranav.educative.L_Dynamic_Programming;

/**
 * @author pranavpatel
 * 
 *   make sure dp[][] is not same as educative. diff logic then one in educative
 * 
 *  String s1 = "abcf"
 *  String s2 = "bdcf"
 * 
 *   worst case S1 + S2 which is if "abcfbdcf" if we do not consider shortest. this is ll be longest 
 *   remove common elements (longestCommonSubsequence -- bcf ) from both string as we can just write
 *   them once.
 *   
 *   so, length of string S1+ length of string S2 - lcs = (4+4-3)
 */
public class C3_Shortest_Common_Supersequence {

  private int findShoertestCommonsSupersequence2(String s1, String s2) {
    return s1.length() + s2.length() - findLCSLengthBottomUp(s1, s2);
  }

  private int findLCSLengthBottomUp(String s1, String s2) {

    int m = s1.length();
    int n = s2.length();

    if (m <= 0 || n <= 0)
      return 0;

    int[][] dp = new int[m + 1][n + 1];
    for (int i = 0; i < m + 1; i++) {
      for (int j = 0; j < n + 1; j++) {
        if (i == 0 || j == 0)
          dp[i][j] = 0;
      }
    }

    for (int i = 1; i < m + 1; i++) {
      for (int j = 1; j < n + 1; j++) {
        if (s1.charAt(i - 1) == s2.charAt(j - 1))
          dp[i][j] = 1 + dp[i - 1][j - 1];
        else
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);

      }
    }

    System.out.println(printShortestCommonsuperSequece(s1, s2, dp));
    return dp[m][n];
  }

  
  // make sure dp[][] is not same as educative. diff logic then one in educative
  public String printShortestCommonsuperSequece(String s1, String s2, int[][] dp) {

    int m = s1.length(), n = s2.length();
    StringBuffer res = new StringBuffer();

    while (m > 0 && n > 0) {

      
      // instead of logic on string, do this logic like print longest common subsequence
      //if (s1.charAt(m - 1) == s2.charAt(n - 1)) { // aditya logic
      
      System.out.println(dp[m][n]);
      System.out.println(dp[m][n-1]);
      System.out.println(dp[m-1][n]);
      if(dp[m][n]!=dp[m][n-1] && dp[m][n]!=dp[m-1][n]) { // educative logic, easy to understand
        res.append(s1.charAt(m - 1));
        m--;
        n--;
      } else {
        
        
        // top cell is greater than left, include s1 char at m-1 before moving to top as char come from there
        if (dp[m - 1][n] > dp[m][n - 1]) {
          res.append(s1.charAt(m - 1));
          m--;
        } else {
        //  left cell is greater than top, include s2 char at n-1 before moving to left as char came from there
          res.append(s2.charAt(n - 1));
          n--;
        }
      }

    }
    
    
    // either m > 0 or n > 0 or none will execute 
    // m > 0 if we haven't reach at end of string s1, n > 0 if we haven't reach at end of string s2
    // none if we have reach at end for both of the strings 
    
    
    
    // add remaining string if m is still greater than 0
    while (m > 0) {
      res.append(s1.charAt(m - 1));
      m--;
    }

    // add remaining string if n is still greater than 0
    while (n > 0) {
      res.append(s2.charAt(n - 1));
      n--;
    }

    return res.reverse()
      .toString();
  }

  public static void main(String[] args) {
    C3_Shortest_Common_Supersequence scs = new C3_Shortest_Common_Supersequence();
    //System.out.println(scs.findShoertestCommonsSupersequence2("abdca", "cbda"));
    // System.out.println(scs.findShoertestCommonsSupersequence2("abac", "cab"));
    System.out.println(scs.findShoertestCommonsSupersequence2("abcf", "bdcf"));
    // System.out.println(scs.findShoertestCommonsSupersequence2("dynamic",
    // "programming"));

  }
}
