/**
 * 
 */
package com.pranav.ik.A4Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author pranavpatel
 *
 */

public class TP1_Order_Of_Characters_From_Alien_Dictionary {
  static Map<Character, HashSet<Character>> adjList = new HashMap<>();
  static int[] visited = new int[26];
  static int[] departure = new int[26];
  static int[] arrival = new int[26];
  static Set<Character> letter = new HashSet<>();
  static int count = 0;
  static StringBuilder sb = new StringBuilder();

  static String find_order(String[] words) {

    // if we have just one word first char is a result
    if(words.length ==1 ) return String.valueOf(words[0].charAt(0));
    
    // build AdjList
    for (int i = 0; i < words.length - 1; i++) {

      for (int j = 0; j < Math.min(words[i].length(), words[i + 1].length()); j++) {
        
        // we want to add it to letter here to handle scenario 'g','g','g','g' we want to add it to letter 
        // and call dfs with just g and print result g
        letter.add(words[i].charAt(j));
        letter.add(words[i + 1].charAt(j));
        
        if (words[i].charAt(j) != words[i + 1].charAt(j)) {
          HashSet<Character> tempList;
          // we can use adjList.getorDefault but this is more readable
          if (adjList.containsKey(words[i].charAt(j))) {
            tempList = adjList.get(words[i].charAt(j));
          } else {
            tempList = new HashSet<>();
          }
          tempList.add(words[i + 1].charAt(j));
          adjList.put(words[i].charAt(j), tempList);
          break;
        }

      }
    }

    // System.out.println("AdjList" + adjList);
    // System.out.println("Leeters" + letter);

    for (Character ch : letter) {
      // ascii value logic
      if (visited[ch - 'a'] == 0) {
        if (dfs(ch))
          return new String("");
      }
    }
    return sb.reverse().toString();
  }

  // dfs will check if it has a cycle or not also ll construct the res
  static boolean dfs(Character source) {
    visited[source - 'a'] = 1;
    arrival[source - 'a'] = count++;

    // System.out.println("source" + source);

    if (adjList.get(source) != null) {
      for (char neighbor : adjList.get(source)) {
        if (visited[neighbor - 'a'] == 0) {
          if (dfs(neighbor))
            return true;
        } else {
          if (departure[neighbor - 'a'] == 0) {
            return true;
          }

        }
      }
    }

    departure[source - 'a'] = count++;
    sb.append(source);
    return false;

  }

  public static void main(String[] args) {

//    String[] words = { "baa", "abcd", "abca", "cab", "cad" };
    String[] words = { "g", "g", "g", "g" };
    System.out.println(find_order(words));
  }
}
