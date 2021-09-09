/**
 * 
 */
package com.pranav.ik.A2Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pranavpatel
 * 
 * this problem is same as subset sum to target no dups but here we can use 
 * same no unlimited time so when we do the include case, instead of doing 
 * index + 1, we ll do index
 * 
 * https://leetcode.com/problems/combination-sum/
 *  
 *
 */
public class  B1_Combination_Sum {

  static List<List<Long>> res = new ArrayList<>();

  static List<List<Long>> check_if_sum_possible(long[] arr, long k) {

    helper(arr, k, 0, new ArrayList<>(), 0);
    return res;
  }

  private static void helper(long[] arr, long target, int idx, List<Long> slate, long sumSlate) {
   
    if (sumSlate > target)
      return;

    // backtracking case -2
    if (sumSlate == target) {
      res.add(new ArrayList<>(slate));
      return;
    }

    // recursive base case. if we are here means we slate < target. other cases would have
    // caught above
    
    if (idx == arr.length) {
      return;
    }

    // include
    long element = arr[idx];
    slate.add(element);
    helper(arr, target, idx, slate, sumSlate + element); // instead of idx+1 as we are allowed to use same element just do idx
    slate.remove(slate.size() - 1);
    
    // exclude
    helper(arr, target, idx + 1, slate, sumSlate);

  }

  public static void main(String[] args) {
    long[] arr = { 2, 3, 5};
    System.out.println(check_if_sum_possible(arr, 8));
  }
}
