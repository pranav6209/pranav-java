/**
 * 
 */
package com.pranav.ik.A5DP;

/**
 * @author pranavpatel
 * 
 *         https://leetcode.com/problems/minimum-path-sum/
 * 
 *         https://leetcode.com/problems/minimum-path-sum/discuss/344980/Java.-Details-from-Recursion-to-DP.
 * 
 *  time complexity O(r*C) -- each element of grid visited once so row * col 
 *  space complexity O(1) = no extra space used
 *  dry run in notes
 */

public class C3_Max_Path_Sum {

  public static int minPathSum(int[][] grid) {

    int rows = grid.length;
    int cols = grid[0].length;

    int[][] table = new int[rows][cols];

    table[0][0] = grid[0][0];
    for (int row = 0; row < rows; row++) {
      table[row][0] = table[row - 1][0] + grid[row][0];

    }

    for (int col = 0; col < cols; col++) {
      table[0][col] = table[0][col - 1] + grid[0][col];

    }

    for (int row = 1; row < rows; row++) {
      for (int col = 1; col < cols; col++) {
        grid[row][col] = grid[row][col] + Math.max(table[row - 1][col], table[row][col - 1]);
      }
    }
    return table[rows - 1][cols - 1];
  }

  public static void main(String[] args) {

    int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };

    System.out.println(minPathSum(grid));

  }
}
