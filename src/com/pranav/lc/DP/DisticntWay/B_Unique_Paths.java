/**
 * 
 */
package com.pranav.lc.DP.DisticntWay;

import java.util.Arrays;

/**
 * @author pranavpatel
 * 
 * 
 *         https://leetcode.com/problems/unique-paths/
 * 
 *         https://www.youtube.com/watch?v=GO5QHC_BmvM
 *
 */
public class B_Unique_Paths {

  public static int countUniquePaths(int noOfRow, int noOfCol) {

    int[][] grid = new int[noOfRow][noOfCol];

    for (int row = 0; row < noOfRow; row++) {
      for (int col = 0; col < noOfCol; col++) {
        // only one way to reach here
        if (row == 0 && col == 0)
          grid[row][col] = 1;
        // only one way to reach here
        else if (row == 0 && col != 0)
          grid[row][col] = 1;
        // only one way to reach here 
        else if (col == 0 && row != 0)
          grid[row][col] = 1;
        //can reach here by either top col or left row
        else
          grid[row][col] = grid[row - 1][col] + grid[row][col-1];
      }
    }
    return grid[noOfRow - 1][noOfCol - 1];
  }

  public static void main(String[] args) {

    int noOfRow = 3;
    int noOfCol = 7;

    System.out.println(countUniquePaths(noOfRow, noOfCol));
  }

}
