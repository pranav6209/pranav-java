/**
 * 
 */
package com.pranav.lc.DP;

/**
 * @author pranavpatel
 * 
 * https://leetcode.com/problems/minimum-path-sum/
 * 
 * https://leetcode.com/problems/minimum-path-sum/discuss/344980/Java.-Details-from-Recursion-to-DP.
 *
 */

// top down approach

// i think this is tabulation approach and bottom up approach 
public class B_Minimum_Path_Sum {
  public static int minPathSum(int[][] grid) {

    int height = grid.length;
    int width = grid[0].length;
    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        if (row == 0 && col == 0)
          grid[row][col] = grid[row][col];
        else if (row == 0 && col != 0)
          grid[row][col] = grid[row][col] + grid[row][col - 1];
        else if (col == 0 && row != 0)
          grid[row][col] = grid[row][col] + grid[row - 1][col];
        else
          grid[row][col] = grid[row][col] + Math.min(grid[row - 1][col], grid[row][col - 1]);
      }
    }
    return grid[height - 1][width - 1];
  }

  public static void main(String[] args) {

    int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
    
    System.out.println(minPathSum(grid));
    
    
    
  }
}
