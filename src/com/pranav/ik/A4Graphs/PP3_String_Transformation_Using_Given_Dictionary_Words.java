/**
 * 
 */
package com.pranav.ik.A4Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author pranavpatel
 *
 */

public class PP3_String_Transformation_Using_Given_Dictionary_Words {

  static String[] string_transformation(String[] words, String start, String stop) {

    if ((start == stop && words.length == 0) || start == null || stop == null)
      return new String[] { "-1" };

    Set<String> dict = new HashSet<>();
    for (String word : words) {
      dict.add(word);
    }

    dict.add(start);
    dict.add(stop);

    Map<String, String> parent = new HashMap<>();
    parent.put(start, null);

    Set<String> visited = new HashSet<>();
    visited.add(start);

    Queue<String> queue = new LinkedList<>();
    queue.offer(start);
    // why not make visited here ??

    while (!queue.isEmpty()) {

      // int size = queue.size();
      String currentWord = queue.poll();
      List<String> neighbors = new ArrayList<>();

      if (words.length < 26 * currentWord.length()) {
        neighbors = findNeighborUsingGivenWords(currentWord, dict);
      } else {
        neighbors = findNeighborsUsingRecursiveTranformation(currentWord, dict);
      }

      for (String neighbor : neighbors) {
        if (neighbor.equals(stop)) {
          List<String> res = new ArrayList<>();
          res.add(neighbor);

          String temp = currentWord;

          while (temp != null) {
            res.add(temp);
            temp = parent.get(temp);
          }

          Collections.reverse(res);
          return res.toArray(new String[res.size()]);
        } else {
          if (!visited.contains(neighbor)) {
            queue.add(neighbor);
            visited.add(neighbor);
            parent.put(neighbor, currentWord);

          }

        }

      }

    }
    return new String[] { "-1" };
  }

  private static List<String> findNeighborUsingGivenWords(String word, Set<String> dict) {

    List<String> neighbors = new ArrayList<>();
    List<String> wordsList = new ArrayList<String>(dict); 
    for (String eachWord : wordsList) {
      int diff = 0;
      for (int i = 0; i < word.length(); i++) {
        if (eachWord.charAt(i) != word.charAt(i)) {
          diff++;
        }
      }

      if (diff == 1)
        neighbors.add(eachWord);
    }
    return neighbors;
  }

  private static List<String> findNeighborsUsingRecursiveTranformation(String word, Set<String> dict) {
    List<String> neighbors = new ArrayList<>();

    char[] wordArr = word.toCharArray();

    for (int i = 0; i < wordArr.length; i++) {

      char currChar = wordArr[i];

      for (char c = 'a'; c < 'z'; c++) {

        if (currChar == c)
          continue;

        wordArr[i] = c;
        String newString = wordArr.toString();
        if (dict.contains(newString)) {
          neighbors.add(newString);
        }

      }

      wordArr[i] = currChar;
    }

    return neighbors;
  }
}
