/**
 * 
 */
package com.pranav.ctci.arrayString;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author pranavpatel
 *
 */
public class A_isUnique {

  private static boolean isUnique(String str) {

    if (str.length() > 128)
      return false;

    boolean[] char_set = new boolean[128];

    for (int i = 0; i < str.length(); i++) {

      int value = str.charAt(i);

      if (char_set[value])
        return false;

      char_set[value] = true;

    }

    return true;
  }

  private static boolean isUniqueUsingMap(String str) {

    Map<Character, Integer> charMap = new HashMap<>();

    for (int i = 0; i < str.length(); i++) {

      char ch = str.charAt(i);

      if (charMap.containsKey(ch))
        return false;

      charMap.put(ch, 1);

    }
    
    Set<Character> char_set = charMap.keySet();
    
    for(char ch: char_set) {
      
      System.out.println("Key: "+ch + " Value: "+charMap.get(ch));
      
    }
    

    return true;

  }

  public static void main(String[] args) {
    System.out.println("isUnique: " + isUnique("Prnav"));
    System.out.println("isUniquesUsingMap: " + isUniqueUsingMap("Prnav"));
  }
}
