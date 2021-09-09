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
 * Time and space complexity same as A4
 * 
 * along with OD. also read explanation from editorial
 *
 */
public class A5_Friendly_Groups {

  static List<List<Integer>> adjList = new ArrayList<>();
  static int[] visited = null;
  static int[] distance = null;
  static int[] parent = null;

  public static boolean can_be_divided(int num_of_people, List<Integer> dislike1, List<Integer> dislike2) {

    // build graph

    for (int i = 0; i < num_of_people; i++) {
      adjList.add(i, new ArrayList<>());
    }

    for (int i = 0; i < dislike1.size(); i++) {
      int source = dislike1.get(i);
      int destination = dislike2.get(i);
      adjList.get(source).add(destination);
      adjList.get(destination).add(source);
    }

    System.out.println("adjList" + adjList);
    
    visited = new int[num_of_people];
    distance = new int[num_of_people];
    parent = new int [num_of_people];
    
    Arrays.fill(visited, -1);
    Arrays.fill(distance, -1);
    Arrays.fill(parent, -1);

    for(int i =0 ; i<num_of_people;i++) {
      if(visited[i]==-1) {
        if(!isBipartite(i)) return false;
        // even if single bfs call return false 
        //  if one component is bipartite whole graph is not bipartite 
      }
    }
    return true;// at this point all components are bipartite so return true 
  }
  
  private static boolean isBipartite(int source ) {
    
    Queue<Integer> queue = new LinkedList<>();
    
    queue.offer(source);
    visited[source] = 1;
    distance[source] = 0;
    
    while(!queue.isEmpty()) {
      int currentVertex = queue.poll();   
      for(int neighbor : adjList.get(currentVertex)) {
        
        if(visited[neighbor]==-1) {
          visited[neighbor] = 1;
          distance[neighbor] = distance[currentVertex] +1 ;
          parent[neighbor] = currentVertex;
          queue.offer(neighbor);
        }else {
          // cycle --
          if(neighbor !=parent[currentVertex])
         // odd length cycle
          if(distance[neighbor]==distance[currentVertex]) 
            return false; 
        }       
      }
 
    }
    // no cycle found means it is a tree and trees are bipartite return true 
    return true;
    
  }
}
