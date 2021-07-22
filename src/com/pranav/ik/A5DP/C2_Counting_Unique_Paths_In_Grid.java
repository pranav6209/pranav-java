/**
 * 
 */
package com.pranav.ik.A5DP;

import java.util.Arrays;

/**
 * @author pranavpatel
 *        
 *        
 * 
 *         https://leetcode.com/problems/unique-paths/
 *         
 *          Time : O(no of row * no of col)
 *          space : O(no of row * no of col)
 *          
 *          space can be optimized to either O(no of row) or o(no of col)
 *          see the class notes 
 *          
 *         OD class  
 *
 */
public class C2_Counting_Unique_Paths_In_Grid {

  public static int countUniquePaths(int noOfRow, int noOfCol) {

    int[][] grid = new int[noOfRow][noOfCol];

    // top left corner
    grid[0][0] =1;
    
    // top row 
    for (int row = 1; row < noOfRow; row++) {
      grid[row][0] = 1;

    }
    // left col
    for (int col = 1; col < noOfCol; col++) {
      grid[0][col] = 1;
    }

    for (int row = 1; row < noOfRow; row++) {
      for (int col = 1; col < noOfCol; col++) {
        grid[row][col] = grid[row - 1][col] + grid[row][col - 1];// top cell + left cell
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
