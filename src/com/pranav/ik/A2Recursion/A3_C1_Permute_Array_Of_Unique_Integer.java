/**
 * 
 */
package com.pranav.ik.A2Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author pranav
 *   
 *   https://leetcode.com/problems/permutations/
 *
 */
public class A3_C1_Permute_Array_Of_Unique_Integer {

  static List<List<Integer>> res = new ArrayList<List<Integer>>();

  static List<List<Integer>> get_permutations(List<Integer> arr) {
    List<Integer> slate = new ArrayList<>();
    helper(arr, 0, slate);
    return res;

  }

  private static void helper(List<Integer> arr, int index, List<Integer> slate) {
    if (index == arr.size()) {
      res.add(new ArrayList<>(slate));
      return;
    }
    
    // have a choice to pick the number from current index to arr.size()
    // live class 3:00:00 dry run 3:15:00
    
    for (int pick = index; pick < arr.size(); pick++) {
      // swap it with the beginning and that is index 
      Collections.swap(arr, pick, index);
      // and as the pick no is swapped with index we are, adding index to slate
      slate.add(arr.get(index));
      helper(arr, index + 1, slate);
      slate.remove(slate.size() - 1);
      Collections.swap(arr, pick, index);
    }

  }

  public static void main(String[] args) {
    List<Integer> input = new ArrayList<>();
    input.add(1);
    input.add(2);
    input.add(3);
    System.out.println(get_permutations(input));
  }
}
