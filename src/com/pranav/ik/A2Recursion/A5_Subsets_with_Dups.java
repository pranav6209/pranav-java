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
 * https://leetcode.com/problems/subsets-ii/
 * 
 * 
 *
 *
 */
public class A5_Subsets_with_Dups {

  static List<List<Integer>> res = new ArrayList<>();

  static List<List<Integer>> allSubsets(List<Integer> input) {

    // always sort the input if is not. so we have dups next to each other
    Collections.sort(input);

    List<Integer> slate = new ArrayList<>();
    helper(input, 0, slate);
    return res;
  }

  private static void helper(List<Integer> input, int index, List<Integer> slate) {

    // base case
    if (index == input.size()) {
      res.add(new ArrayList<>(slate));
      return;

    }

    int count = 0;
    // we ll always have counter to 1 as we are comparing same char.
    // we need that for exclude case as we just want to increment by 1
    
    // i starts from index as we want to count same numbers from that index we are working
    // on and not from the beginning
    
    for (int i = index; i < input.size(); i++) {
      if (input.get(index) == input.get(i)) {
        count++;
      } else {
        break;
      }
    }

    // include

    // add all repetitive entry to slate. so if we have 2 2s add all to slates and . in case of the count 1 
    // code will work as a subset 1
    for (int i = 0; i < count; i++) {
      //System.out.println(input.get(index));
      slate.add(input.get(index));
      helper(input, index + count, slate);
    }

    // remove what we have written to slate
    for (int i = 0; i < count; i++) {
      slate.remove(slate.size() - 1);
    }
    
    // exclude

    helper(input, index + count, slate);

  }

  public static void main(String[] args) {

    List<Integer> input = new ArrayList<>();
    input.add(1);
    input.add(2);
    input.add(2);

    System.out.println(allSubsets(input));

  }

}
