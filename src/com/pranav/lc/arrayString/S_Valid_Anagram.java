/**
 * 
 */
package com.pranav.lc.arrayString;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pranavpatel
 *
 */
public class S_Valid_Anagram {

  // time complexity 0(nlogn) for sorting and space 0(1)
  public static boolean isAnagram(String s, String t) {

    // Arrays.deepEquals(Arrays.sort(S.toCharArray()),
    // Arrays.sort(S.toCharArray()));

    if (s.length() == 0 || t.length() == 0)
      return true;
    if (s.length() != t.length())
      return false;
    if (s == null || t == null)
      return true;

    char[] ch1 = s.toCharArray();
    char[] ch2 = t.toCharArray();

    Arrays.sort(ch1);
    Arrays.sort(ch2);

    return Arrays.equals(ch1, ch2);

  }

  public static boolean isAnagram1(String s, String t) {

    Map<Character, Integer> map = new HashMap<>();
    
    if (s.length() == 0 || t.length() == 0)
      return true;
    if (s.length() != t.length())
      return false;
    if (s == null || t == null)
      return true;


    for (int i = 0; i < s.length(); i++) {
      int value;
      char cuurentCh = s.charAt(i);
      if (map.containsKey((cuurentCh))) {
        value = map.get(cuurentCh);
        value++;
      } else {
        value = 1;
      }
      map.put(cuurentCh, value);
    }

    for (int i = 0; i < t.length(); i++) {
      
      char cuurentCh = t.charAt(i);
      if (map.containsKey((cuurentCh))) {
        int value = map.get(cuurentCh);
        value--;
        map.put(cuurentCh, value);
      } else {
        return false;
      }
      if(map.get(cuurentCh)==0) map.remove(cuurentCh);

    }
    return map.isEmpty();
  }
  
  
  public static boolean isAnagram2(String s, String t) {
    if (s.length() != t.length()) {
        return false;
    }
    int[] counter = new int[26];
    for (int i = 0; i < s.length(); i++) {
        counter[s.charAt(i) - 'a']++;
        counter[t.charAt(i) - 'a']--;
    }
    for (int count : counter) {
        if (count != 0) {
            return false;
        }
    }
    return true;
}

  public static void main(String[] args) {

    String s = "anagram", t = "nagaram";

    System.out.println(isAnagram(s, t));
    System.out.println(isAnagram1(s, t));
    System.out.println(isAnagram2(s, t));

  }

}
