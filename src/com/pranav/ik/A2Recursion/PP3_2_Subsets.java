/**
 * 
 */
package com.pranav.ik.A2Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pranavpatel
 * 
 * Time Complexity: O(2^n * n).
 * As we will generate 2^n strings of length O(n).
 * Auxiliary Space Used:
 * O(2^n * n).
 * As we will store 2^n strings of length O(n) in the output array to be returned.
 *
 */
public class PP3_2_Subsets {

  static List<List<Integer>> allSubsets(List<Integer> input) {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> slate = new ArrayList<>(); 
    helper(input, 0, slate, res);
    return res;
  }

  private static void helper(List<Integer> input, int index, List<Integer> slate, List<List<Integer>> res) {


    if (index >= input.size()) {
      // every recursive call is modifying list so if we do not make a copy, we ll end up with empty sets
      res.add(new ArrayList<>(slate));
      return;

    }

    // inclusion
    int element = input.get(index);
    slate.add(element); // here we are modifying global slate
    helper(input, index + 1, slate, res);
    // undo modification to global slate
    slate.remove(slate.size() - 1);// remove last element from the list

    // exclusion
    helper(input, index + 1, slate, res);
  }
  
  public static void main(String[] args) {
    
    List<Integer> input = new ArrayList<>();
    input.add(1);
    input.add(2);
    input.add(3);
    
    System.out.println(allSubsets(input));
    
    
  }

}
