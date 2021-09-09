/**
 * 
 */
package com.pranav.ik.A2Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pranavpatel
 * 
 * 
 *         This is a same problem as a subset problem. Only difference is we are
 *         adding a backtrack case
 * 
 *         https://leetcode.com/problems/combinations/
 * 
 *         extra from Omkar's Live Class
 * 
 *         Time and space complexity is same as a subset problem. Only
 *         difference here is we are pruning tree early because of backtracking
 *         case
 *
 */
public class A7_C3_Combinations_N_Choose_k {

  static List<List<Integer>> res = new ArrayList<>();

  public static List<List<Integer>> combine(int n, int k) {
    helper(n, k, 1, new ArrayList<>());

    return res;
  }

  private static void helper(int n, int k, int idx, List<Integer> slate) {

    // backtracking case
    if (slate.size() == k) {
      res.add(new ArrayList<>(slate));
      return;
    }

    // here instead of array we have n, when idx > n we have a subproblem def 0 so
    // we return
    if (idx > n) {
      return;
    }
    // if we are slate

    // include
    slate.add(idx);
    helper(n, k, idx + 1, slate);
    slate.remove(slate.size() - 1);

    // exclude
    helper(n, k, idx + 1, slate);

  }

  public static void main(String[] args) {
    System.out.println(combine(5, 2));
  }
}
