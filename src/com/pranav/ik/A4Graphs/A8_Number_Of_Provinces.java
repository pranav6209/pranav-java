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
public class A8_Number_Of_Provinces {
  static boolean[] visited = null;

  public int findCircleNum(int[][] isConnected) {

    visited = new boolean[isConnected.length];
    int connectedComp = 0;
    for (int i = 0; i < isConnected.length; i++) {

      if (visited[i] == false) {
        connectedComp++;
        bfs(i, isConnected);
      }
    }
    return connectedComp;
  }

  private static void bfs(int src, int[][] isConnected) {

    Queue<Integer> queue = new LinkedList<>();
    queue.offer(src);
    visited[src] = true;

    while (!queue.isEmpty()) {

      int current = queue.poll();

      for (int j = 0; j < isConnected.length; j++) {
        if (visited[j] == false && isConnected[current][j] == 1) {
          bfs(j, isConnected);
          visited[j] = true;
        }

      }
    }
  }
}
