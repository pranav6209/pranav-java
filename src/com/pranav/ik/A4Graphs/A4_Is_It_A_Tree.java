/**
 * 
 */
package com.pranav.ik.A4Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author pranavpatel
 * 
 *checking 2 condition
 * 
 *1. Graph has more than 1 component
 *2. Graph has a cycle. cross edge for BFS in case of BFS
 *
 *
 * 2- main operations
 *  
 * 1. push and pop O(1) operation for n nodes O(N) 
 * 2. looking at all the neighbor sum of O(Degree) which is
 *    equal to 2m (2 times no of edges as each node will be viewed twice
 *    for undirected graph) = O(m) 
 * Total time complexity : O(M+N) Total
 * space complexity : O(N) size of the queue if the source vertex is
 *                    connected to all other vertices of the graph
 * 
 *  Dry run around 2:13:00 in OD video
 */
public class A4_Is_It_A_Tree {
  static List<List<Integer>> adjList = new ArrayList<>();
  static int[] visited = null;
  static int[] parent = null;

  public static boolean is_it_a_tree(int node_count, List<Integer> edge_start, List<Integer> edge_end) {

    // phase -1 build graph

    for (int i = 0; i < node_count; i++) {
      adjList.add(i, new ArrayList<>());
    }

    for (int i = 0; i < edge_start.size(); i++) {
      int source = edge_start.get(i);
      int destination = edge_end.get(i);
      adjList.get(source).add(destination);
      adjList.get(destination).add(source);
    }

    System.out.println("adjList" + adjList);

    visited = new int [node_count];
    parent = new int [node_count];
    Arrays.fill(visited, -1);
    Arrays.fill(parent, -1);

    // Graph built

    // Phase -3 outer loop

    int component = 0;

    for (int i = 0; i < node_count; i++) {
      if (visited[i] == -1) {
        component++;
        if(hasCycle(i)) return false; // cond - 2
      }
    }

    if (component > 1) // cond -1
      return false;
    
     return true;
  }

  // phase - 2 BFS
  private static boolean hasCycle(int src) {

    Queue<Integer> queue = new LinkedList<>();
    queue.offer(src);
    visited[src] = 1;

    while (!queue.isEmpty()) {

      int currenVertex = queue.poll();

      for (int neighbor : adjList.get(currenVertex)) {

        if (visited[neighbor] == -1) {
          visited[neighbor] = 1; // update visited array
          parent[neighbor] = currenVertex; // update the parent array
          queue.offer(neighbor);
        } else {
          // visited neighbor is not parent means we have a cycle - cross edge 
          if (neighbor != parent[currenVertex])
            return true;
        }
      }
    }

    return false;
  }

}
