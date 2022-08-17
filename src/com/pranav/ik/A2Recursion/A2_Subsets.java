/**
 * 
 */
package com.pranav.ik.A2Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author pranavpatel
 * leetcode version
 * https://leetcode.com/problems/subsets/
 *
 */
public class A2_Subsets {

  static List<List<Integer>> allSubsets(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> slate = new ArrayList<>(); 
    helper(nums, 0, slate, res);
    return res;
  }

  private static void helper(int[] input, int index, List<Integer> slate, List<List<Integer>> res) {


    if (index == input.length) {
      // every recursive call is modifying list so if we do not make a copy, we ll end up with empty sets
      res.add(new ArrayList<>(slate));
      return;

    }

    // inclusion
    int element = input[index];
    slate.add(element); // here we are modifying global slate
    helper(input, index + 1, slate, res);
    // undo modification to global slate
    slate.remove(slate.size() - 1);// remove last element from the list

    // exclusion
    helper(input, index + 1, slate, res);
  }
  
  public static void main(String[] args) {
    
    int[] nums = new int[3];

    nums[0] = 1;
    nums[1] = 2;
    nums[2] = 3;

    
    System.out.println(allSubsets(nums));
    
    
  }

}
