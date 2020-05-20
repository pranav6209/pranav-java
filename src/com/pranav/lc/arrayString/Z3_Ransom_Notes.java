/**
 * 
 */
package com.pranav.lc.arrayString;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pranavpatel
 * 
 * https://leetcode.com/problems/ransom-note/
 *
 */

// Time Complexity O(M+R)
// Space complexity O(M) for map
public class Z3_Ransom_Notes {

  public static boolean canConstruct(String ransomNote, String magazine) {

    if ((magazine == null || magazine.isEmpty()) && !(ransomNote == null || ransomNote.isEmpty()))
      return false;

    if ((magazine.isEmpty()) && ransomNote.isEmpty())
      return true;

    boolean res = true;
    
    // put magazine char and count in to map
    Map<Character, Integer> magazineMap = new HashMap<>();

    // time complexity O(M)
    for (int i = 0; i < magazine.length(); i++) {
      // time complexity O(1)
      char currentChar = magazine.charAt(i);
        //time complexity O(1)
      if (magazineMap.containsKey(currentChar))
        //time complexity O(1)
        magazineMap.put(currentChar, magazineMap.get(currentChar) + 1);

      else {
        //time complexity O(1)
        magazineMap.put(currentChar, 1);
      }

    }
    
    // iterate ransom note char and if found in magazine map decrease the count or if it is 0 remove it.
    // not found return false;
    
    // time complexity O(R)
    for (int j = 0; j < ransomNote.length(); j++) {
      char currentChar = ransomNote.charAt(j);

      // time complexity O(1)
      if (!magazineMap.containsKey(currentChar)) {
        return false;
      } else {

        int currentCharValue = magazineMap.get(currentChar);

        if (currentCharValue - 1 == 0)
          magazineMap.remove(currentChar);
        else
          magazineMap.put(currentChar, currentCharValue - 1);

      }
    }

    return res;

  }

  public static void main(String[] args) {
    // String ransomNote = "aa";
    // String magazie = "aab";
    // String ransomNote = "aa";
    // String magazie = "ab";
    String ransomNote = "a";
    String magazie = "b";
    System.out.println(canConstruct(ransomNote, magazie));
  }
}
