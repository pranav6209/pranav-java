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
 *         time and space O(V+E)
 *         
 *         https://leetcode.com/problems/course-schedule-ii/
 *
 */
public class A3_Task_Scheduling_Oredering {

  public static List<Integer> findOrder(int tasks, int[][] prerequisites) {

    List<Integer> sortedOrder = new ArrayList<Integer>();

    // 1. initiate graph
    HashMap<Integer, Integer> inDegree = new HashMap<>();
    HashMap<Integer, List<Integer>> graph = new HashMap<>();

    for (int i = 0; i < tasks; i++) {
      inDegree.put(i, 0);
      graph.put(i, new ArrayList<Integer>());
    }

    // 2. build the graph

    for (int i = 0; i < prerequisites.length; i++) {
      int parent = prerequisites[i][0], child = prerequisites[i][1];
      graph.get(parent)
        .add(child);
      // count how many time it is becoming child of a parent
      inDegree.put(child, inDegree.get(child) + 1);
    }

    // 3. find all the sources (vertices with 0 indegree)
    // https://www.java67.com/2016/05/keyset-vs-entryset-vs-values-in-java-map-example.html
    Queue<Integer> sources = new LinkedList<>();

    for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
      if (entry.getValue() == 0)
        sources.add(entry.getKey());

    }

    // d. For each source, add it to the sortedOrder and subtract one from all of
    // its children's in-degrees
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

    if (sortedOrder.size() != tasks)
      return new ArrayList<>();
    
    return sortedOrder;

  }

  public static void main(String[] args) {

    List<Integer> result = A3_Task_Scheduling_Oredering
      .findOrder(2, new int[][] { new int[] { 1, 0 }});
    System.out.println(result);

    result = A3_Task_Scheduling_Oredering
      .findOrder(4, new int[][] { new int[] { 1, 0 }, new int[] { 2, 0 }, new int[] { 3, 1 }, new int[] { 3, 2 } });
    System.out.println(result);

    result = A3_Task_Scheduling_Oredering.findOrder(
      6,
      new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 }, new int[] { 0, 4 }, new int[] { 1, 4 }, new int[] { 3, 2 },
          new int[] { 1, 3 } });
    System.out.println(result);
  }
}
