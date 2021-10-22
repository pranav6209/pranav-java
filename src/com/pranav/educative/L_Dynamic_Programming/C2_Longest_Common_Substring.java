
/**
 * 
 */
package com.pranav.educative.L_Dynamic_Programming;

/**
 * @author pranavpatel
 * 
 *   make sure dp[][] is not same as educative. diff logic then one in educative
 * 
 *
 */
public class C2_Longest_Common_Substring {
  private int findLongestCommonSubstring(String s1, String s2) {

    int m = s1.length();
    int n = s2.length();

    if (m <= 0 || n <= 0)
      return 0;

    int[][] dp = new int[m + 1][n + 1];
    int maxLength = 0;

    // initialize first row and col with 0 as we longest common subsequence is 0
    // with either one string being zero(empty)
    for (int i = 0; i <= m + 1; i++) {
      for (int j = 0; j <= n + 1; j++) {
        if (i == 0 || j == 0)
          dp[i][j] = 0;
      }
    }

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        /*
         * if current char matches, 1+ diagonal cell value. means we want to decrease
         * index of both the string and check what is the value there. See recursive
         * video
         */
        if (s1.charAt(i - 1) == s2.charAt(j - 1))
          dp[i][j] = 1 + dp[i - 1][j - 1];
        else
          dp[i][j] = 0; // when char doesn't match value of substring is 0 
        maxLength = Math.max(dp[i][j], maxLength); // carry max with each iteration
      }
    }

    return maxLength;
  }

  public static void main(String[] args) {
    C2_Longest_Common_Substring lcs = new C2_Longest_Common_Substring();
    System.out.println(lcs.findLongestCommonSubstring("abdca", "cbda"));
    System.out.println(lcs.findLongestCommonSubstring("passport", "ppsspt"));

  }
}
