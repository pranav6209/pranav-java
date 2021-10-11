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
 *         
 *         follow this approach 
 */


public class A1_Numbers_Of_Island_alt {
  static int[][] directions = new int [][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, -1 }, { 1, -1 }, { 1, 1 }, { -1, 1 } };
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
  
  public static void main(String[] args) {
    List<List<Integer>> ip = new ArrayList<>();

    List<Integer> l1 = new ArrayList<>();
    l1.add(1);
    l1.add(1);
    l1.add(0);
    l1.add(0);
    l1.add(0);
    ip.add(l1);

    List<Integer> l2 = new ArrayList<>();
    l2.add(0);
    l2.add(1);
    l2.add(0);
    l2.add(0);
    l2.add(1);
    ip.add(l2);

    List<Integer> l3 = new ArrayList<>();
    l3.add(1);
    l3.add(0);
    l3.add(0);
    l3.add(1);
    l3.add(1);
    ip.add(l3);

    List<Integer> l4 = new ArrayList<>();
    l4.add(0);
    l4.add(0);
    l4.add(0);
    l4.add(0);
    l4.add(0);
    ip.add(l4);

    List<Integer> l5 = new ArrayList<>();
    l5.add(1);
    l5.add(0);
    l5.add(1);
    l5.add(0);
    l5.add(1);
    ip.add(l5);

    System.out.println(count_islands(ip));

  }

}
