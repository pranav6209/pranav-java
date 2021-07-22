/**
 * 
 */
package com.pranav.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pranavpatel 
 * 
 * 2- main operations 
 * 1. push and pop O(1) operation for n nodes O(N) 
 * 2. looking at all the neighbor sum of O(Degree) which is
 *    equal to 2m (2 times no of edges as each node will be viewed twice
 *    for undirected graph) = O(m) 
 * Total time complexity : O(M+N) Total
 * space complexity : O(N) size of the queue if the source vertex is
 *                    connected to all other vertices of the graph
 * 
 *  Dry run around 50:00 in OD video
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
