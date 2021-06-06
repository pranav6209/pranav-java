/**
 * 
 */
package com.pranav.educative.K_Top_K_Elements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author pranavpatel
 * 
 * https://leetcode.com/problems/sort-characters-by-frequency/
 * https://leetcode.com/problems/sort-array-by-increasing-frequency/
 * https://www.youtube.com/watch?v=hLR5aMzYGGk&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=8&ab_channel=AdityaVerma
 *
 */
public class A6_Frquency_Sort {
  public static String sortCharacterByFrequency(String s) {
    
    char[] ch = s.toCharArray();
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < ch.length; i++) {
      map.put(ch[i], map.getOrDefault(ch[i], 0) + 1);
    }
    System.out.println(map);
    PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<Map.Entry<Character, Integer>>((n1,
    n2) -> n2.getValue() - n1.getValue());

    maxHeap.addAll(map.entrySet());

    StringBuffer sb = new StringBuffer();

    while (!maxHeap.isEmpty()) {

      Map.Entry<Character, Integer> entry = maxHeap.poll();
      // if value of m is 2, we want to append m twice
      for (int i = 0; i < entry.getValue(); i++) {
        sb.append(entry.getKey());
      }

    }

    return sb.toString();
  }

  public static void main(String[] args) {
    String result = A6_Frquency_Sort.sortCharacterByFrequency("programming");
    System.out.println("Here is the given string after sorting characters by frequency: " + result);

    result = A6_Frquency_Sort.sortCharacterByFrequency("abcbab");
    System.out.println("Here is the given string after sorting characters by frequency: " + result);

  }
}
