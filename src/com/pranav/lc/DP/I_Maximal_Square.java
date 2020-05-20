/**
 * 
 */
package com.pranav.lc.DP;

/**
 * @author pranavpatel
 * 
 * https://leetcode.com/problems/maximal-square/
 * 
 * https://www.youtube.com/watch?v=_Lf1looyJMU
 *
 */
public class I_Maximal_Square {

  public static int maximalSquare(int[][] matrix) {

    int rows = matrix.length;
    if(rows==0) return 0;    
    int cols = matrix[0].length;
    int res = 0;
    int[][] dp = new int[rows + 1][cols + 1];

    for (int row = 1; row <= rows; row++) {
      for (int col = 1; col <= cols; col++) {

        if (matrix[row - 1][col - 1] == 1) {

          dp[row][col] = 1+Math.min(Math.min(dp[row - 1][col], dp[row][col - 1]), dp[row - 1][col - 1]);
          if (res < dp[row][col]) {
            res = dp[row][col];
          }
        }

      }

    }
    return res*res;
  }

  public static void main(String[] args) {

    int[][] grid = { { 1, 0, 1, 0, 0 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 1, 0, 0, 1, 0 } };
    System.out.println(maximalSquare(grid));
  }

}
