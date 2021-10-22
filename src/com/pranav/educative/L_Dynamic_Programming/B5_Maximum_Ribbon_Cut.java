/**
 * 
 */
package com.pranav.educative.L_Dynamic_Programming;

import java.util.List;

/**
 * @author pranavpatel
 * 
 *         https://leetcode.com/problems/coin-change/
 *
 */
public class B5_Maximum_Ribbon_Cut {

  public int countRibbonPieces(int[] ribbonLengths, int total) {

    int n = ribbonLengths.length;
    int[][] dp = new int[n + 1][total + 1];

    // populate the total=0 columns, as we don't need any coin to make zero total
    for (int i = 1; i <= n; i++)
      dp[i][0] = 0;

    // we can not keep matrix initialize to 0 as if the total is not possible,
    // we want to return -1
    for (int j = 0; j <= total; j++)
      dp[0][j] = Integer.MIN_VALUE;

    for (int j = 1; j <= total; j++) {
      // here if 0th index denomination is less than total we can use it
      // multiple time so considering each sub array.
      if (j % ribbonLengths[0] == 0) {
        dp[1][j] = j / ribbonLengths[0];
      } else {
        dp[1][j] = Integer.MIN_VALUE;
      }
    }

    for (int i = 2; i <= n; i++) {
      for (int j = 1; j <= total; j++) {
        if (ribbonLengths[i - 1] <= j) {
          dp[i][j] = Math.max(dp[i - 1][j], 1 + dp[i][j - ribbonLengths[i - 1]]); // include the coin
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }

    if (dp[n][total] == Integer.MIN_VALUE)
      return -1;
    if (dp[n][total] == Integer.MIN_VALUE + 1)
      return -1;
    else
      return dp[n][total];

  }

  public static void main(String[] args) {
    B5_Maximum_Ribbon_Cut cr = new B5_Maximum_Ribbon_Cut();
    int[] ribbonLengths = { 2, 3, 5 };
    System.out.println(cr.countRibbonPieces(ribbonLengths, 5));
    ribbonLengths = new int[] { 2, 3 };
    System.out.println(cr.countRibbonPieces(ribbonLengths, 7));
    ribbonLengths = new int[] { 3, 5, 7 };
    System.out.println(cr.countRibbonPieces(ribbonLengths, 13));
    ribbonLengths = new int[] { 3, 5 };
    System.out.println(cr.countRibbonPieces(ribbonLengths, 7));
  }
}
