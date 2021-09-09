/**
 * 
 */
package com.pranav.ik.A4Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author pranavpatel
 *
 */
public class A7_Topological_Sort {

  static List<List<Integer>> adjList = new ArrayList<>();
  static int[] visited = null;
  static int[] departure = null;
  static int time = 0;

  public static List<Integer> sort(int vertices, int[][] edges) {
    List<Integer> sortedOrder = new ArrayList<>();

    for (int i = 0; i < vertices; i++) {
      adjList.add(i, new ArrayList<>());
    }

    for (int[] edge : edges) {

      int src = edge[0];
      int dest = edge[1];

      adjList.get(src).add(dest);

    }

    System.out.println(adjList);

    visited = new int[vertices];
    Arrays.fill(visited, -1);
    

    departure = new int[vertices];
    Arrays.fill(departure, -1);

    for (int i = 0; i < vertices; i++) {
      if (visited[i] == -1) {
        if (dfs(i, sortedOrder)) {
          return sortedOrder;
        }
      }
    }

    Collections.reverse(sortedOrder);
    return sortedOrder;

  }

  private static boolean dfs(int src, List<Integer> sortedOrder) {

    visited[src] = 1;
    for (int neighbor : adjList.get(src)) {
      if (visited[neighbor] == -1) {
        if (dfs(neighbor, sortedOrder))
          return true;
      } else {
        if (departure[neighbor] == -1) {
          return true;
        }
      }

    }
    departure[src] = time++;
    sortedOrder.add(src);
    return false;
  }
  
  public static void main(String[] args) {
//    List<Integer> result = A7_Topological_Sort.sort(4,
//        new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
//    System.out.println(result);
//
//    List<Integer> result1 = A7_Topological_Sort.sort(5, new int[][] { new int[] { 4, 2 }, new int[] { 4, 3 }, new int[] { 2, 0 },
//        new int[] { 2, 1 }, new int[] { 3, 1 } });
//    System.out.println(result1);

    List<Integer> result2 = A7_Topological_Sort.sort(7, new int[][] { new int[] { 6, 4 }, new int[] { 6, 2 }, new int[] { 5, 3 },
        new int[] { 5, 4 }, new int[] { 3, 0 }, new int[] { 3, 1 }, new int[] { 3, 2 }, new int[] { 4, 1 } });
    System.out.println(result2);
  }

}
