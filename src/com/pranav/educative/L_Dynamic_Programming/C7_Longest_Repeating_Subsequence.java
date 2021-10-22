/**
 * 
 */
package com.pranav.educative.L_Dynamic_Programming;

/**
 * @author pranavpatel

 * watch video at 2x speed easy to understand short video
 * https://www.youtube.com/watch?v=hbTaCmQGqLg&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=29&ab_channel=AdityaVerma
 * 
 * logic is we have String AABEBCDD, we ll use it twice 
 * 
 * AABEBCDD
 * AABEBCDD  answer is ABD
 * 
 * if s1.charAt(i - 1) == s2.charAt(j - 1)  and i!=j if char matches between 2 strings and if they are at the same index,
 * do not consider(consider only if it is at diff index )
 * 
 * 

 */

public class C7_Longest_Repeating_Subsequence {

  private int findLRSLength(String s) {
    return findLCSLengthBottomUp(s, s);
  }

  private int findLCSLengthBottomUp(String s1, String s2) {
    int m = s1.length(), n = s2.length();

    int[][] dp = new int[m + 1][n + 1];

    for (int i = 0; i <= m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 || j == 0)
          dp[i][j] = 0;
      }
    }

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n ; j++) {

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
    //System.out.println(lrs.findLRSLength("fmff"));
    
    System.out.println(lrs.findLRSLength("AABEBCDD"));
    
  }

}
