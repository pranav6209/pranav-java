/**
 * 
 */
package com.pranav.lc.arrayString;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pranavpatel
 * 
 * https://leetcode.com/problems/jewels-and-stones/
 *
 */

// Time Complexity O(S+J)
// Space complexity O(J) for map
public class Z2_Jewels_And_Stones {

  public static int numJewelsInStones1(String J, String S) {

    if (J == null || J.isEmpty())
      return 0;
    if (S == null || S.isEmpty())
      return 0;
    int res = 0;
    Map<Character, Integer> jewels = new HashMap<>();
    // Map<Character, Integer> stones = new HashMap<>();

    // time complexity O(J)
    for (int i = 0; i < J.length(); i++) {
      //time complexity O(1)
      jewels.put(J.charAt(i), 1);

    }
    // time complexity O(J)
    for (int j = 0; j < S.length(); j++) {

      // time complexity O(1)
      if (jewels.containsKey(S.charAt(j))) {
        res++;
      }

    }
    return res;
  }

  public static int numJewelsInStones2(String J, String S) {

    if (J == null || J.isEmpty())
      return 0;
    if (S == null || S.isEmpty())
      return 0;
    int res = 0;

    for (int j = 0; j < S.length(); j++) {

      if (J.indexOf(S.charAt(j)) != -1)
        res++;

    }

    return res;
  }

  public static void main(String[] args) {
    // String J = "aA";
    // String S = "aAAbbbb";
    String J = "z";
    String S = "ZZ";
    System.out.println(numJewelsInStones2(J, S));
  }
}
