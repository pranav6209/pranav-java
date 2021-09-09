/**
 * 
 */
package com.pranav.ik.A2Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pranavpatel
 * 
 *         https://leetcode.com/problems/generalized-abbreviation/
 * 
 *         This is similar to subset problem. Time and space is also same
 * 
 *         https://www.educative.io/courses/grokking-the-coding-interview/NEOZDEg5PlN
 *
 */
public class B7_Unique_Generalized_Abbreviations {

  static List<String> res = new ArrayList<String>();

  public static List<String> generateGeneralizedAbbreviation(String word) {

    helper(word, 0, 0, new ArrayList<Character>());

    return res;
  }

  private static void helper(String word, int index, int count, List<Character> slate) {

    if (index == word.length()) {
      StringBuilder sb = new StringBuilder();
      for (char ch : slate) {
        sb.append(ch);
      }

      if (count != 0) {
        sb.append(count);
      }

      res.add(sb.toString());
      return;
    }

    // exclude

    // when exclude increase the count
    helper(word, index + 1, count + 1, slate);

    // include
    // while including if count is not zero, add it to slate first

    char ch = word.charAt(index);
    if (count != 0)
      // converting int count to char count
      slate.add((char) (count + '0'));
    slate.add(ch);
    // when include pass count 0 for that round as we are including that element

    helper(word, index + 1, 0, slate);

    // removing ch added
    slate.remove(slate.size() - 1);

    // removing count if we have added
    if (count != 0)

      slate.remove(slate.size() - 1);
  }

  public static void main(String[] args) {
    System.out.println(generateGeneralizedAbbreviation("BAT"));
  }
}