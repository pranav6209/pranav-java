/**
 * 
 */
package com.pranav.ik.A4Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author pranavpatel Time : O(M*N) Space : O(n+m)
 * 
 *         implicit representation of edges. look at the live class notes
 *         here we are counting no of components
 */


public class A1_Numbers_Of_Island_alt {
  static int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, -1 }, { 1, -1 }, { 1, 1 }, { -1, 1 } };
  public static int count_islands(List<List<Integer>> matrix) {
    
    int m = matrix.size();
    int n = matrix.get(0).size();
    int islandCount = 0;// this is no of components in the graph
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix.get(i).get(j) == 1) {
          islandCount++;
          bfs(i, j, matrix);
        }
      }
    }
    return islandCount;
  }

  static void bfs(int row, int col, List<List<Integer>> matrix) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[] { row, col });
 
    matrix.get(row).set(col, -1); // make it visited

    while (!queue.isEmpty()) {
      int[] current = queue.poll();

      int rSize = matrix.size();
      int cSize = matrix.get(0).size();
      
      for (int i = 0; i < directions.length; i++) {
        int r = current[0] + directions[i][0];
        int c = current[1] + directions[i][1];

        if (r < 0 || r >= rSize || c < 0 || c >= cSize)
          continue;

        // if current point is not visited, visit and mark it visited  
        if (matrix.get(r).get(c) == 1) { 
          matrix.get(r).set(c, -1); 
          queue.add(new int[] { r, c });
        }
      }

    }
  }

  

  // this just a test method to check the neighbors
  static List<int[]> getNeighbors(int[] point, List<List<Integer>> matrix) {
    List<int[]> neighbors = new ArrayList<>();

    int rSize = matrix.size();
    int cSize = matrix.get(0).size();
    // up
    for (int i = 0; i < directions.length; i++) {
      int r = point[0] + directions[i][0];
      int c = point[1] + directions[i][1];

      if (r < 0 || r >= rSize || c < 0 || c >= cSize)
        continue;
      neighbors.add(new int[] { r, c });
    }

    return neighbors;
  }

}
