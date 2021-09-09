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
 *  
 *  https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
 */

// dry run for a code 
public class A3_Count_Connected_Components_In_Undirected_Graph {

  
  static  List<List<Integer>> adjList = new ArrayList<>();
  static int[] visited = null;
  public static int number_of_connected_components(int n, List<List<Integer>> edges) {
    // part-1 Building graph
    for (int i = 0; i < n; i++) {

      adjList.add(i, new ArrayList<>());
    }

    for (List<Integer> edge : edges) {
      // get the adjList for edge 1st value and add edge 2nd value in it.
      int src = edge.get(0);
      int dest = edge.get(1);
      
      // undirected graph
      adjList.get(src).add(dest);
      adjList.get(dest).add(src);
    }
    
    //System.out.println("adjList"+adjList);

    // part - 3 outer loop
    
    visited = new int[n];
    Arrays.fill(visited, -1);

    int connectedCount = 0;

    for (int i = 0; i < n; i++) {
      if (visited[i] == -1) {
        connectedCount++;
        bfs(i);
      }
    }

    return connectedCount;

  }

  // part - 2 bfs
  private static void bfs(int src) {

    Queue<Integer> queue = new LinkedList<>();
    queue.offer(src);
    visited[src] = 1;
    while (!queue.isEmpty()) {
      int currentVertex = queue.poll();
      // check neighbor
      for (int neighbor : adjList.get(currentVertex)) {

        // only visit neighbors if it is not visited
        if (visited[neighbor] == -1) {
          // mark visited
          visited[neighbor] = 1;
          // add to queue
          queue.offer(neighbor);
        }
      }
    }
  }

  public static void main(String[] args) {
    List<List<Integer>> ip = new ArrayList<>();

    List<Integer> l1 = new ArrayList<>();
    l1.add(0);
    l1.add(1);
    ip.add(l1);
    List<Integer> l2 = new ArrayList<>();
    l2.add(1);
    l2.add(2);
    ip.add(l2);
    List<Integer> l3 = new ArrayList<>();
    l3.add(0);
    l3.add(2);
    ip.add(l3);
    List<Integer> l4 = new ArrayList<>();
    l4.add(3);
    l4.add(4);
    ip.add(l4);

    System.out.println(number_of_connected_components(5, ip));
  }

}
