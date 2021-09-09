/**
 * 
 */
package com.pranav.ik.A4Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author pranavpatel
 *
 */
public class A6_Complete_All_Courses_With_Dependencies {
  static List<List<Integer>> adjList = new ArrayList<>();
  static int[] visited = null;
  static int[] arrival=null; // we really do not need arrival time here
  static int[] departure = null;
  static int time =0;

  public static boolean can_be_completed(int n, List<Integer> a, List<Integer> b) {
    // phase-1 build graph
    for (int i = 0; i < n; i++) {
      adjList.add(i, new ArrayList<>());
    }
    
    for(int i=0;i<a.size();i++) {
      int source = a.get(i);
      int dest = b.get(i);
      
      adjList.get(source).add(dest);
      
    }
    
    //System.out.println("adjList" + adjList);
    visited = new int[n];
    Arrays.fill(visited, -1);
    
    arrival = new int[n];
    Arrays.fill(arrival, -1);
    
    departure = new int[n];
    Arrays.fill(departure, -1);
    
    // Phase -3 outer loop
    for(int i=0;i<n;i++) {
      if(visited[i]==-1) {
        if(dfs(i)) return false; // if dfs returns true has a cycle return false;
      }    
    }
    return true;
  }

  // phase -2 dfs
  private static boolean dfs(int source) {
    arrival[source] = time++;
    visited[source] =1;
    
    for(int neighbor : adjList.get(source)) {   
      if(visited[neighbor]==-1) {
        if(dfs(neighbor)) return true;// if subordinate found cycle.
      } else {
        // if visited and departure for the neighbor is not set means it is a back edge and it has a cycle.
        // look at class note to understand
        if(departure[neighbor] == -1) return true; // if found cycle by self
      }  
    }
    
    departure[source] = time++;
    return false;
    
  }
  
  public static void main(String[] args) {
    List<Integer> a = new ArrayList<>();
    a.add(1);
    a.add(1);
    a.add(3);
    
    List<Integer> b = new ArrayList<>();
    b.add(0);
    b.add(2);
    b.add(1);
    can_be_completed(4, a, b);
  }

}
