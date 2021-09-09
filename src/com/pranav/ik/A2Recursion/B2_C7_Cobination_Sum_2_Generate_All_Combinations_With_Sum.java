/**
 * 
 */
package com.pranav.ik.A2Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author pranavpatel
 * 
 * 
 *         time : O(2^N N!) space : O(N)
 *         
 *         https://leetcode.com/problems/combination-sum-ii/
 *         
 *        combination of 2 problems 
 *        1. Subset with dups 
 *        2. possible to achieve target sum
 *
 */
public class B2_C7_Cobination_Sum_2_Generate_All_Combinations_With_Sum {

  static List<List<Integer>> res = new ArrayList<>();

  public static List<List<Integer>> generate_all_combinations(List<Integer> arr, int target) {
    Collections.sort(arr);
    List<Integer> slate = new ArrayList<>();
    helper(arr, 0, slate, 0, target);
    return res;
  }

  private static void helper(List<Integer> input, int index, List<Integer> slate, int sumSlate , int target) {

    // backtracking case -1
    if (sumSlate > target) {
      return;
    }
    // backtracking case -2
    if (sumSlate == target) {
      res.add(new ArrayList<>(slate));
      return;
    }

    // base case
    if (index == input.size()) {
       //res.add(new ArrayList<>(slate));
      return;
    }

    int count = 0;
    // we ll always have counter to 1 as we are comparing same char.
    // we need that for exclude case as we just want to increment by 1
    for (int i = index; i < input.size(); i++) {
      if (input.get(index) == input.get(i)) {
        count++;
      } else {
        break;
      }
    }

    // include

    // add all repetitive entry to slate. so if we have 2 2s add all to slates and .
    // incase of the count 1
    // code will work as a subset 1
    for (int i = 0; i < count; i++) {
      int element = input.get(index);
      slate.add(element);
      helper(input, index + count, slate, sumSlate + element * (i+1), target);
    }

    // remove what we have written to slate
    for (int i = 0; i < count; i++) {
      slate.remove(slate.size() - 1);
    }

    // exclude

    helper(input, index + count, slate, sumSlate, target);

  }

  public static void main(String[] args) {

    List<Integer> input = new ArrayList<>();
    input.add(1);
    input.add(1);
    input.add(1);
    input.add(2);

    System.out.println(generate_all_combinations(input, 2));

  }
}
