
package com.pranav.educative.L_Dynamic_Programming;

/**
 * @author pranavpatel
 * 
 *  String s1 = "abc"
 *  String s2 = "fbc"
 *  
 *  
 *  convert string 1 to LCS by deleting a char and then convert LCS to string 2 by inserting char
 *  
 *  
 *  abc(String 1) --convertToLCS --> bc (deletion -1 which is a )  ---convertToString 2 ---> fbc (insertion 1 which is f)
 * 
 *  no of deletion lengthOfString S1 - LCS 
 *  no of insertion lengthOfString S2 - LCS 
 *   
 
 */
public class C4_Minimum_Deletions_Insertions_Transform_String_into_another {

  private void findMinDeleteInsert(String s1, String s2) {
    System.out.println("Minimum deletions needed: " + (s1.length() - findLCSLengthBottomUp(s1,s2)));
    System.out.println("Minimum insertions needed: " + (s2.length() - findLCSLengthBottomUp(s1,s2)));
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
    return dp[m][n];
  }

  

  public static void main(String[] args) {
    C4_Minimum_Deletions_Insertions_Transform_String_into_another scs = new C4_Minimum_Deletions_Insertions_Transform_String_into_another();
    scs.findMinDeleteInsert("abc", "fbc");

  }
}
