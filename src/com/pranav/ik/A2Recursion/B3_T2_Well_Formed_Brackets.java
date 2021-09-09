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
public class B3_T2_Well_Formed_Brackets {

  public static List<String> wellFormedBrackets(int nums) {

    List<String> res = new ArrayList<>();
    List<Character> slate = new ArrayList<>();

    helper(nums, nums,slate, res);
    return res;

  }

  // left remain and right remain is a sub problem definition and slate is a
  // partial solution
  private static void helper(int leftRemain, int rightRemain, List<Character> slate, List<String> res) {

    // if left count is more than right we do not have enough closing bracket to
    // match
    // with open bracket.
    if (leftRemain > rightRemain) {
      return;
    }

    // recursion base case
    if (leftRemain == 0 && rightRemain == 0) {

      StringBuffer sb = new StringBuffer();
      for (char ch : slate)
        sb.append(ch);
      res.add(sb.toString());
      return;
    }

    // if my manager passes me any left parentheses to work with
    if (leftRemain > 0) {
      slate.add('(');
      helper(leftRemain - 1, rightRemain, slate, res);
      slate.remove(slate.size() - 1);
    }

    // if my manager passes me any right parentheses to work with

    if (rightRemain > 0) {
      slate.add(')');
      helper(leftRemain, rightRemain - 1, slate, res);
      slate.remove(slate.size() - 1);
    }
  }

  public static void main(String[] args) {
    System.out.println(wellFormedBrackets(2));
  }

}
