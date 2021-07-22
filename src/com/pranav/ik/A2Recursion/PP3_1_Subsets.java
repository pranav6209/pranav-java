/**
 * 
 */
package com.pranav.ik.A2Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pranavpatel
 * 
 * Time Complexity: O(2^n * n).
 * As we will generate 2^n strings of length O(n).
 * Auxiliary Space Used:
 * O(2^n * n).
 * As we will store 2^n strings of length O(n) in the output array to be returned.
 *
 */
public class PP3_1_Subsets {

  static String[] generate_all_subsets(String s) {

    List<String> res = new ArrayList<String>();
    List<Character> slate = new ArrayList<>();
    int index = 0;
    helper(s, index, slate, res);
    System.out.println(res);
    return res.toArray(new String[res.size()]);

  }

  private static void helper(String s, int index, List<Character> slate, List<String> res) {

    if (index == s.length()) {
      StringBuilder sb = new StringBuilder();
      for(char ch : slate) {
        sb.append(ch);
      }
      res.add(sb.toString());
      return;

    }

    // include

    char ch = s.charAt(index);
    slate.add(ch);
    helper(s, index + 1, slate, res);
    slate.remove(slate.size()- 1);

    // exclude
    helper(s, index + 1, slate, res);
  }

  public static void main(String[] args) {

    generate_all_subsets("xyz");

  }

}
