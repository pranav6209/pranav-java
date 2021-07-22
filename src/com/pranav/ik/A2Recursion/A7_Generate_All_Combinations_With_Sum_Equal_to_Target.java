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
 *  time : O(2^N N!)
 *  space : O(N)
 *
 */
public class A7_Generate_All_Combinations_With_Sum_Equal_to_Target {
  public static List<List<Integer>> generate_all_combinations(List<Integer> arr, int target) {

    Collections.sort(arr);
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> slate = new ArrayList<>();
    helper(arr, 0, slate, res, 0, target);
    return res;
  }

  private static void helper(List<Integer> input, int index, List<Integer> slate, List<List<Integer>> res, int sumSlate,
  int target) {

    // backtracking base case
    if (sumSlate > target) {
      return;
    }

    // recursive base case
    if (index == input.size()) {
      // System.out.println(slate);
      if (sumSlate == target) {
        res.add(new ArrayList<>(slate));
      }
      return;
    }

    // inclusion
    int element = input.get(index);
    slate.add(element); // here we are modifying global slate
    helper(input, index + 1, slate, res, sumSlate + element, target);
    // undo modification to global slate
    slate.remove(slate.size() - 1);// remove last element from the list

    // exclusion
    int newIndex = index + 1;
    while (newIndex < input.size() && input.get(index) == (input.get(newIndex))) {
      newIndex++;
    }

    helper(input, newIndex, slate, res, sumSlate, target);

  }

  public static void main(String[] args) {

    List<Integer> input = new ArrayList<>();
    input.add(7);
    input.add(3);
    input.add(4);

    System.out.println(generate_all_combinations(input, 7));

  }
}
