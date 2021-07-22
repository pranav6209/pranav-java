/**
 * 
 */
package com.pranav.ik.A4Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author pranavpatel
 * 
 *         This problem is similar to connected component in a graph
 *
 */


public class PP5_Zombie_Cluster {
  static boolean[] visited = null;
  public static int zombieCluster(List<String> zombies) {
    // times no of zombies
    visited = new boolean[zombies.size()];

    int component = 0;

    for (int i = 0; i < zombies.size(); i++) {
      if (visited[i] == false) {
        component++;
        bfs(i, zombies);
      }
    }

    return component;

  }

  static void bfs(int source, List<String> zombies) {

    Queue<Integer> queue = new LinkedList<>();
    visited[source] = true;
    queue.add(source);

    while (!queue.isEmpty()) {
      int cur = queue.poll();
      // more like checking each column with an adjacency list
      // 
      for (int j = 0; j < zombies.size(); j++) {
        if (visited[j] == false && zombies.get(cur).charAt(j) == '1') {
          visited[j] = true;
          queue.add(j);
        }
      }
    }
  }

  public static void main(String[] args) {

    List<String> input = new ArrayList<>();

    input.add("1100");
    input.add("1110");
    input.add("0110");
    input.add("0001");
    System.out.println(zombieCluster(input));

  }

}
