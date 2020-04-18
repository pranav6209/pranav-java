/**
 * 
 */
package com.pranav.lc.graphs;

/**
 * @author pranavpatel
 * 
 * 
 *         https://www.youtube.com/watch?v=__98uL6wst8
 *
 *
 *         0-water,1-land,2-visited
 *
 *         in video above 8:24 time complexity 0(n) - each node is repeated 1
 *         time space complextiy 0(no of recursive call) which 0(m*n)
 *         
 *         DFS bse we are not visiting all the edges once we check for land/water/visited, we are moving 
 *         to adjacent vortex and checking all means only one
 */
public class A_Number_Of_Island {

  public static int numIslands(char[][] grid) {

    int rows = grid.length;
    if (rows == 0)
      return 0;
    int columns = grid[0].length;
    int noOfIsland = 0;

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {

        if (grid[i][j] == '1') {

          markCurrentIsalnd(grid, i, j, rows, columns);
          noOfIsland++;

        }

      }

    }

    return noOfIsland;
  }

  private static void  markCurrentIsalnd(char[][] grid,int i, int j, int rows, int columns) {
    
    if(i<0 || i>= rows || j<0 || j>=columns || grid[i][j]!='1') return;
    
    //mark current cell visited 
    grid[i][j]='2';
    
    // make recursive call in all 4 adjacent direction
    
    markCurrentIsalnd(grid,i+1,j,rows,columns); // down
    markCurrentIsalnd(grid,i,j+1,rows,columns); // right
    markCurrentIsalnd(grid,i-1,j,rows,columns); //Top
    markCurrentIsalnd(grid,i,j-1,rows,columns); //left
    
    
    
  }

  public static void main(String[] args) {

    char[][] grid = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
        { '0', '0', '0', '0', '0' } };
    System.out.println(numIslands(grid));

  }

}
