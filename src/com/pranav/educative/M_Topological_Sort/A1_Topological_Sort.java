/**
 * 
 */
package com.pranav.educative.M_Topological_Sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author pranavpatel
 * 
 *  time and space O(V+E)
 *
 */
public class A1_Topological_Sort {

  public static List<Integer> sort(int vertices, int[][] edges) {
    List<Integer> sortedOrder = new ArrayList<Integer>();

    // 1. initiate graph
    HashMap<Integer, Integer> inDegree = new HashMap<>();
    HashMap<Integer, List<Integer>> graph = new HashMap<>();

    for (int i = 0; i < vertices; i++) {
      inDegree.put(i, 0);
      graph.put(i, new ArrayList<Integer>());
    }

    //2.  build the graph

    for (int i = 0; i < edges.length; i++) {
      int parent = edges[i][0], child = edges[i][1];
      graph.get(parent)
        .add(child);
      // count how many time it is becoming child of a parent
      inDegree.put(child, inDegree.get(child) + 1);
    }

    //3. find all the sources (vertices with 0 indegree)
    // https://www.java67.com/2016/05/keyset-vs-entryset-vs-values-in-java-map-example.html
    Queue<Integer> sources = new LinkedList<>();

    for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
      if (entry.getValue() == 0)
        sources.add(entry.getKey());

    }

    // d. For each source, add it to the sortedOrder and subtract one from all of its children's in-degrees
    // if a child's in-degree becomes zero, add it to the sources queue
    while (!sources.isEmpty()) {

      int vertex = sources.poll();

      sortedOrder.add(vertex);

      List<Integer> children = graph.get(vertex);

      for (int child : children) {

        inDegree.put(child, inDegree.get(child) - 1);
        if (inDegree.get(child) == 0)
          sources.add(child);

      }

    }

    if(sortedOrder.size()!=vertices) return new ArrayList<>();// topological sort is not possible as the graph has a cycle
    
    return sortedOrder;
  }

  public static void main(String[] args) {
    List<Integer> result = A1_Topological_Sort
      .sort(4, new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
    System.out.println(result);

    result = A1_Topological_Sort.sort(
      5,
      new int[][] { new int[] { 4, 2 }, new int[] { 4, 3 }, new int[] { 2, 0 }, new int[] { 2, 1 },
          new int[] { 3, 1 } });
    System.out.println(result);

    result = A1_Topological_Sort.sort(
      7,
      new int[][] { new int[] { 6, 4 }, new int[] { 6, 2 }, new int[] { 5, 3 }, new int[] { 5, 4 }, new int[] { 3, 0 },
          new int[] { 3, 1 }, new int[] { 3, 2 }, new int[] { 4, 1 } });
    System.out.println(result);
  }
}
