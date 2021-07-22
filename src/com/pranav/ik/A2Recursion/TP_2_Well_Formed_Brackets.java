/**
 * 
 */
package com.pranav.ik.A2Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pranavpatel
 * 
 *         https://leetcode.com/problems/generate-parentheses/
 * 
 *         Time : O( 2 2^N N^2) -- 2^N is the depth of the tree each level we
 *         have 2 calls. Making a string copy as string are immutable slate +
 *         "(" and slate + ")" == N^2
 * 
 *
 */
public class TP_2_Well_Formed_Brackets {

  public static List<String> wellFormedBrackets(int nums) {

    List<String> res = new ArrayList<>();
    List<Character> slate = new ArrayList<>();

    helper(slate, nums, nums, res);
    return res;

  }

  private static void helper(List<Character> slate, int left, int right, List<String> res) {

    // System.out.println("slate"+slate);

    /*
     * backtrack base case when the left count increase than right and left
     * decrements to less than 0 and right goes less than 0 ?? why left < 0 and
     * right < 0 and not left == 0 and right ==0 when left ==0 and right ==0 we want
     * to use it for a base case and we want to include that into res
     */

    if (left > right || left < 0 || right < 0) {
      return;
    }

    // recursion base case
    if (left == 0 && right == 0) {

      StringBuffer sb = new StringBuffer();
      for (char ch : slate)
        sb.append(ch);
      res.add(sb.toString());
      return;
    }
    slate.add('(');
    helper(slate, left - 1, right, res);
    slate.remove(slate.size()-1);
    slate.add(')');
    helper(slate, left, right - 1, res);
    slate.remove(slate.size()-1);
  }

  public static void main(String[] args) {
    System.out.println(wellFormedBrackets(2));
  }

}
