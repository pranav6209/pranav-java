/**
 * 
 */
package com.pranav.ik.A4Graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author pranavpatel
 * 
 *         https://leetcode.com/problems/knight-probability-in-chessboard/
 *
 */

// goal here is to find shortest distance so BFS 
public class PP2_Knights_Tour_On_Chess_Board {
  static int[][] directions = { { -1,-2 }, { -2, -1 }, { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 },{ 1, -2 } };

  static int find_minimum_number_of_moves(int rows, int cols, int start_row, int start_col, int end_row, int end_col) {

    if (start_row == end_row && start_col == end_col) return 0;
    return bfs(rows, cols, start_row, start_col, end_row, end_col);
  }

  private static int bfs(int rows, int cols, int start_row, int start_col, int end_row, int end_col) {
    int minMoves = 0;
    // grid is not given make one
    int[][] grid = new int[rows][cols];
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[] { start_row, start_col });
    grid[start_row][start_col] = 1;

    while (!queue.isEmpty()) {
      System.out.println(minMoves);
      // scanning through each level. Like a level order traversal. as  at each level we increment a move
      // similar approach of a level order traversal of a tree
      int size = queue.size(); // store it here in var as it will change dynamically 
      for (int i = 0; i < size; i++) {
        int[] current = queue.poll();
        if (current[0] == end_row && current[1] == end_col)
          return minMoves;

        for (int j = 0; j < directions.length; j++) {

          int r = current[0] + directions[j][0];
          int c = current[1] + directions[j][1];

          if (r < 0 || c < 0 || r >= rows || c >= cols)
            continue;

          if (grid[r][c] == 0) { // not visited
            queue.offer(new int[] { r, c });
            grid[r][c] = 1;

          }

        }

      }
      // at the end of each level increment move
      minMoves++;
    }
    return -1;
  }

  public static void main(String[] args) {
    System.out.println(find_minimum_number_of_moves(5, 5, 0, 0, 4, 1));
  }
}
