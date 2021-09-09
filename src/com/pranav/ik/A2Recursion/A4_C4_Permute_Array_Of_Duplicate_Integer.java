/**
 * 
 */
package com.pranav.ik.A2Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Time and Space complexity in book.
 * 
 * https://leetcode.com/problems/permutations-ii/
 * 
 */
public class A4_C4_Permute_Array_Of_Duplicate_Integer {

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
    
    Set<Integer> set = new HashSet<>();
    for (int pick = index; pick < arr.size(); pick++) {
      // if my current pick is in hashset means we already made same choice, skip it
      if (!set.contains(arr.get(pick))) {

        set.add(arr.get(pick));
        Collections.swap(arr, index, pick);
        slate.add(arr.get(index));
        helper(arr, index + 1, slate);
        slate.remove(slate.size() - 1);
        Collections.swap(arr, index, pick);
      }
      
      
      /*
      if (set.contains(arr.get(pick))) {
        continue;
      }
        
      set.add(arr.get(pick));
      System.out.println(set);
      Collections.swap(arr, index, pick);
      slate.add(arr.get(index));
      helper(arr, index + 1, slate);
      slate.remove(slate.size() - 1);
      Collections.swap(arr, index, pick);

       */
    }

  }

  public static void main(String[] args) {
    List<Integer> input = new ArrayList<>();
    input.add(1);
    input.add(2);
    input.add(1);
    System.out.println(get_permutations(input));
  }
}
