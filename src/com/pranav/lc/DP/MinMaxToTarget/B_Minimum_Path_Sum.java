/**
 * 
 */
package com.pranav.lc.DP.MinMaxToTarget;

/**
 * @author pranavpatel
 * 
 * https://leetcode.com/problems/minimum-path-sum/
 * 
 * https://leetcode.com/problems/minimum-path-sum/discuss/344980/Java.-Details-from-Recursion-to-DP.
 * 
 * time complexity O(r*C) -- each element of grid visited once so row * col
 * space complexity O(1) = no extra space used 
 *
 */

// i think this is tabulation approach and bottom up approach 
public class B_Minimum_Path_Sum {

  public static int minPathSum(int[][] grid) {

    int rows = grid.length;
    int columns = grid[0].length;
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < columns; col++) {
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
    return grid[rows - 1][columns - 1];
  }
  
/*  
 * Recursive solution 
  public static int minPathSum(int[][] grid) {

    int height = grid.length;
    int width = grid[0].length;
    return min(grid, height - 1, width - 1);

}

public static int min(int[][]grid, int row, int col){

    if(row == 0 && col == 0) return grid[row][col]; // this is the exit of the recursion
    if(row == 0) return grid[row][col] + min(grid, row, col - 1); *//** when we reach the first row, we could only move horizontally.*//*
    if(col == 0) return grid[row][col] + min(grid, row - 1, col); *//** when we reach the first column, we could only move vertically.*//*
    return grid[row][col] + Math.min(min(grid, row - 1, col), min(grid, row, col - 1)); *//** we want the min sum path so we pick the cell with the less value *//*

}
*/
  public static void main(String[] args) {

    int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
    
    System.out.println(minPathSum(grid));
    
    
    
  }
}
