/**
 * 
 */
package com.pranav.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pranavpatel 
 * 
 *  Dry run around 56:00 in OD video
 *
 *  Time : 0(V+E)
 *  Time : O(V)
 *
 */
public class O_Graph_DFS {
  static int[] visited = new int[5];// some random no
  static List<List<Integer>> adjList = new ArrayList<>();

  public static void dfs(int source) {

    // flag the source with visited
    visited[source] = 1;

    // get all the neighbor for adjList
    for (int neighbor : adjList.get(source)) {

      // if neighbor not visited, launch dfs on it
      if (visited[neighbor] == -1) {
        dfs(neighbor);
      }
    }

  }
}
