/**
 * 
 */
package com.pranav.ik.A2Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pranavpatel
 *
 */
public class A9_T1_Possible_To_Achieve_Target_Boolean {
  static boolean check_if_sum_possible(long[] arr, long k) {

    // here LC doesn't allow declaring global variable, so we are passing one
    // Dimensional
    // array by reference
    boolean[] res = new boolean[] { false };
    helper(arr, k, 0, new ArrayList<>(), 0, res);
    return res[0];
  }

  private static void helper(long[] arr, long target, int idx, List<Long> slate, long sumSlate, boolean[] res) {

    // backtrack case-1

    if (sumSlate > target)
      return;

    // backtrack case-2
    // sumSlate == target, we want to make sure slate it not empty, we are not
    // considering empty set as a valid answer here
    if (sumSlate == target && !slate.isEmpty()) {

      res[0] = true;
      return;
    }

    // base case
    if (idx == arr.length) {
      return;
    }

    // include
    long element = arr[idx];
    slate.add(element);
    helper(arr, target, idx + 1, slate, sumSlate + element, res);
    slate.remove(slate.size() - 1);

    // exclude
    helper(arr, target, idx + 1, slate, sumSlate, res);

  }

  public static void main(String[] args) {
    long[] arr = { 1 };
    System.out.println(check_if_sum_possible(arr, 0));
  }
}
