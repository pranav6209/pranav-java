/**
 * 
 */
package com.pranav.ik.A4Graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author pranavpatel
 *
 */
public class A9_Rotting_Oranges {

  static int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

  public int orangesRotting(int[][] grid) {
    return bfs(grid);
  }

  private static int bfs(int[][] grid) {

    Queue<int[]> queue = new LinkedList<>();

    int freshOrange = 0;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 2) {
          queue.offer(new int[] { i, j });
        } else if (grid[i][j] == 1) {
          freshOrange++;
        }
      }
    }

    if (freshOrange == 0)
      return 0; // if no fresh orange in the grid
    if (queue.isEmpty())
      return -1; // if no rotten orange in grid

    /*
     * at first level we want to count 0 so starting with -1 or we can start with 1 
     * and then while (!queue.isEmpty() && freshCount > 0) in this case after roting 
     * last orange, we ll not go in a while loop so time will not increase 
     * 
     * 
     */
    
    int minute = -1;
    int rows = grid.length;
    int cols = grid[0].length;

    // continue iterating if we have a fresh orange
    while (!queue.isEmpty()) {

      int size = queue.size();

      for (int i = 0; i < size; i++) {

        int[] current = queue.poll();

        for (int j = 0; j < directions.length; j++) {

          int r = current[0] + directions[j][0];
          int c = current[1] + directions[j][1];

          if (r < 0 || r >= rows || c < 0 || c >= cols)
            continue;

          if (grid[r][c] == 1) {
            queue.offer(new int[] { r, c });
            grid[r][c] = 2;
            freshOrange--;
          }
        }

      }
      minute++;
    }
    return freshOrange == 0 ? minute : -1; // if fresh is 0 (all are rotten) return minute and if all are not rotten -1. 
  }

}
