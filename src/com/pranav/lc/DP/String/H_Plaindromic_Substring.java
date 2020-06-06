/**
 * 
 */
package com.pranav.lc.DP.String;

/**
 * @author pranavpatel
 * 
 *         https://leetcode.com/problems/longest-common-subsequence/
 *
 */

//https://leetcode.com/problems/palindromic-substrings/discuss/258917/Java-Simple-Code%3A-DP-short
public class H_Plaindromic_Substring {
  public static int countSubstrings(String s) {
  
    int count = 0, n = s.length();
    boolean[][] dp = new boolean[n][n];
    
    // this outer loop we need as we always want to start i with 0 
    for (int d = 0; d < n; d++) {
      // i+d < n to avoid out of bound, as i first go till 4 then 3 then 2....
      for (int i = 0; i + d < n; i++) {
        int j = i + d;
        if (s.charAt(i) == s.charAt(j)) {
          // i+1 >= j-1 as we are looking for diagonal value if char matches i+1 j-1 gives diagonal 
          dp[i][j] = (i + 1 >= j - 1) ? true : dp[i + 1][j - 1];
          if (dp[i][j])
            count++;
        }
      }
    }
    return count;
  }

  //https://leetcode.com/problems/palindromic-substrings/discuss/105707/Java-DP-solution-based-on-longest-palindromic-substring
  public static int countSubstrings1(String s) {
    int n = s.length();
    int res = 0;
    boolean[][] dp = new boolean[n][n];
    for (int i = n - 1; i >= 0; i--) {
        for (int j = i; j < n; j++) {
            dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i  + 1 < 3 || dp[i + 1][j - 1]);
            if(dp[i][j]) ++res;
        }
    }
    return res;
}
  public static void main(String[] args) {

    String String1 = "abbac";

    System.out.println(countSubstrings(String1));
    System.out.println(countSubstrings1(String1));

  }

}
