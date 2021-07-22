/**
 * 
 */
package com.pranav.code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * @author pranavpatel 
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
public class N_Graph_BFS {

  static int[] visited = new int[5];// some random no
  static List<List<Integer>> adjList = new ArrayList<>();

  public static void bfs(int source) {

    Queue<Integer> queue = new LinkedList<>();
    queue.add(source);
    visited[source] = 1;

    while (!queue.isEmpty()) {

      int current = queue.poll();

      // get neighbor of current node
      for (int neighbor : adjList.get(current)) {
        
        // if neighbor is not visited
        if (visited[neighbor] == -1) {
          visited[neighbor] = 1;
          queue.offer(neighbor);
        }

      }

    }

  }
}
