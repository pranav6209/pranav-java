/**
 * 
 */
package com.pranav.lc.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author pranavpatel
 * 
 *         https://leetcode.com/problems/combination-sum/submissions/
 * 
 * 
 *         time complexity : O(N!+N) where n is the no elements. additional N
 *         for tempList.contains()
 *
 *         space complexity : O(N) where n is the no elements
 * 
 * 
 *         https://medium.com/@vasanths294/permutation-combination-subset-time-complexity-eca924e00071
 *
 */
public class A9_Combination_Sum {
  public static List<List<Integer>> combinationSum(int[] nums, int target) {

    List<List<Integer>> res = new ArrayList<>();

    if (nums == null || nums.length == 0)
      return res;
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    dfs(list, new ArrayList<>(), nums, target, 0);
    return list;
  }

  private static void dfs(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {

    if (remain == 0)
      list.add(new ArrayList<>(tempList));

    for (int i = start; i < nums.length; i++) {

      // remain - current number is less that 0 skip that number
      if (remain - nums[i] < 0) continue;
      
      tempList.add(nums[i]);
      
      // here we are passing i as the start index again as we want consider same element
      dfs(list, tempList, nums, remain - nums[i], i);

      tempList.remove(tempList.size()-1);

    }

  }

  public static void main(String[] args) {
    List<List<Integer>> res = combinationSum(new int[] { 2, 3, 5 }, 8);

    for (List<Integer> nums : res) {

      System.out.println(nums);

    }

  }
}
