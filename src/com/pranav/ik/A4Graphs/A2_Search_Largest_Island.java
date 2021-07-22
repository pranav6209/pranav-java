/**
 * 
 */
package com.pranav.ik.A4Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author pranavpatel
 *  Time  : O(M*N)
 *  Space : O(n+m)
 *  
 *  implicit representation of edges. look at the live class notes 
 */
public class A2_Search_Largest_Island {

  private static int maxIslandSize =  0;
  static int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
  public static int max_island_size(List<List<Integer>> matrix) {
 
    int m = matrix.size();
    int n = matrix.get(0).size();
    
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        int value = matrix.get(i).get(j);
        if (value == 1) {
          bfs(i, j, matrix);
        }
      }
    }
    return maxIslandSize;
  }

  private static void bfs(int row, int col, List<List<Integer>> matrix) {
    int currentIslandSize = 1;
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[] { row, col });
 
    matrix.get(row).set(col, 3); // make it visited

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
          currentIslandSize++;
          matrix.get(r).set(c, 3); 
          queue.add(new int[] { r, c });
        }
      }

    }
    maxIslandSize = Math.max(maxIslandSize, currentIslandSize);
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

    System.out.println(max_island_size(ip));

  }
}
