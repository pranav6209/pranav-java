package com.pranav.company;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 * same as https://leetcode.com/problems/first-unique-character-in-a-string/submissions/
 * @author pranavpatel
 * 
 * 
 * 
 * 
 * 
 *         To find the First non-repeating word in the given String. The input
 *         will not be empty or null
 * 
 *         Input 1: Hello how are you. I am good how are you
 *         Output: Hello
 * 
 * 
 * 
 *         Input 2: Hello how are you hi hello I am good how are you
 *         Output: hi
 * 
 * 
 * 
 *         Input 3: Hello how are you hello how are you Output: ""
 *
 */
public class I_Uniphore {

  public static String firstNonRepating(String str) {

    // https://stackoverflow.com/questions/2889777/difference-between-hashmap-linkedhashmap-and-treemap
    Map<String, Integer> freqMap = new LinkedHashMap<>();// maintain insertion order

    // Map<String, Integer> postionMap = new HashMap<>();

    String[] array = str.split(" ");

    for (int i = 0; i < array.length; i++) {

      if (freqMap.containsKey(array[i])) {

        freqMap.put(array[i], freqMap.get(array[i]) + 1);

      } else {
        freqMap.put(array[i], 1);
      }

    }

    System.out.println(freqMap);

    for (String s : freqMap.keySet()) {

      if (freqMap.get(s) == 1)
        return s;

    }
    return "";

  }

  public static void main(String[] args) {
    System.out.println(firstNonRepating("Hello how are you. I am good how are you Output"));
  }

}
