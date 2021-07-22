/**
 * 
 */
package com.pranav.ik.A5DP;

/**
 * @author pranavpatel 
 * https://leetcode.com/problems/unique-paths-ii/
 *  
 *  each cell doing constant amount of work
 *  
 *  Time : O(no of row * no of col)
 *  space : O(no of row * no of col)
 *  
 *  // can we optimize to use just 2 rows explanation OD video 1:30:00
 */
public class A1_Unique_Paths_2 {
  public static int countUniquePaths(int[][] obstacleGrid) {

    int noOfRows = obstacleGrid.length;
    int noOfCols = obstacleGrid[0].length;

    int[][] table = new int[noOfRows][noOfCols];

    // if there is an obstacle no of top left we can't start so return 0 else fill
    // it with 1
    if (obstacleGrid[0][0] == 1)
      return 0;
    else {
      table[0][0] = 1;
    }

    // if we have an obstacle, at particular point we break as point beyond it
    // is not reachable and there is no way to reach there we ll keep it 0

    for (int row = 0; row < noOfRows; row++) {
      if (table[row][0] == 1)
        break;
      table[row][0] = 1;

    }

    // same logic as row for cols as well
    for (int col = 0; col < noOfCols; col++) {
      if (table[0][col] == 1)
        break;
      table[0][col] = 1;
    }

    for (int row = 1; row < noOfRows; row++) {
      for (int col = 1; col < noOfCols; col++) {
        // if there is an obstacle in my own cell.no update just keep 0
        // assuming we have a table initialize with 0
        if (obstacleGrid[row][col] == 1)
          continue;
        else table[row][col] = table[row - 1][col] + table[row][col - 1];// top cell + left cell
      }
    }
    return table[noOfRows - 1][noOfCols - 1];
  }
}
