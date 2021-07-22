/**
 * 
 */
package com.pranav.ik.A4Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author pranavpatel
 *
 */
public class PP4_Course_SChedule {

  static List<List<Integer>> adjList = new ArrayList<>();
  static List<Integer> res = new ArrayList<>();
  static int[] visited = null;
  static int[] arrival = null;
  static int[] departure = null;
  static int time = 0;

  static List<Integer> course_schedule(int n, List<List<Integer>> prerequisites) {

    for (int i = 0; i < n; i++) {
      adjList.add(i, new ArrayList<>());
    }

    for (int i = 0; i < prerequisites.size(); i++) {

      int dest = prerequisites.get(i).get(0);
      int source = prerequisites.get(i).get(1);

      adjList.get(source).add(dest);

    }

    // System.out.println("adjList"+adjList);

    visited = new int[n];
    Arrays.fill(visited, -1);

    arrival = new int[n];
    Arrays.fill(arrival, -1);

    departure = new int[n];
    Arrays.fill(departure, -1);

    for (int i = 0; i < n; i++) {
      if (visited[i] == -1) {
        if (dfs(i)) {
          res.clear();
          res.add(-1);
          return res;
        }
      }

    }

    Collections.reverse(res);
    return res;

  }

  private static boolean dfs(int source) {

    visited[source] = 1;
    arrival[source] = time++;

    for (int neighbor : adjList.get(source)) {
      if (visited[neighbor] == -1) {
        if (dfs(neighbor))
          return true;
      } else {
        if (departure[neighbor] == -1)
          return true;
      }

    }

    departure[source] = time++;
    res.add(source);
    return false;

  }
}
