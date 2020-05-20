/**
 * 
 */
package com.pranav.lc.arrayString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author pranavpatel
 * 
 * https://leetcode.com/problems/group-anagrams/
 * 
 * as in anagram sorted string is same if there is valid anagram
 * 
 * 1. add a sorted string as a key and all the other strings which is same in sorted order as a value;
 * 
 *
 */
public class T_Group_Anagram {

  public static List<List<String>> groupAnagrams(String[] strs) {

    if (strs.length == 0) return new ArrayList();
    Map<String, List<String>> map = new HashMap<>();
    
    for (int i = 0; i < strs.length; i++) {
      
      char[] ch = strs[i].toCharArray();
      Arrays.sort(ch);
      String sortedString = String.valueOf(ch);

      if (map.containsKey(sortedString)) {

        List<String> list1 = map.get(sortedString);
        list1.add(strs[i]);
        map.put(sortedString, list1);
      }

      else {
        List<String> list2 = new ArrayList<>();
        list2.add(strs[i]);
        map.put(sortedString, list2);
      }

    }

    List<List<String>> list3 = new ArrayList<>();
    
    map.forEach((k,v)->{
      
      list3.add(v);
      
    });

    return list3;
  }

  public static void main(String[] args) {

    String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };

    System.out.println(groupAnagrams(strs));
  }

}
