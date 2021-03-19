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
 *         https://leetcode.com/problems/subsets-ii/
 * 
 *        Time complexity
 *        
 *        https://www.educative.io/courses/grokking-the-coding-interview/7npk3V3JQNr
 * 
 *         https://medium.com/@vasanths294/permutation-combination-subset-time-complexity-eca924e00071
 * 
 *         recursion tree here also in google doc
 *         https://leetcode.com/problems/subsets/discuss/27281/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
 *
 */
public class A6_Subsets2 {

  public static List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    
    if(nums==null || nums.length==0) return res;

    // ask interviewer, is array sorted ? if not add this line. if we are adding,
    // include time complexity of sort
    Arrays.sort(nums);

    dfs(res, new ArrayList<>(), 0, nums);

    return res;
  }



  public static void dfs(List<List<Integer>> list, List<Integer> tempList, int start, int[] nums) {

    // creating a new arrayList base on temp list as we do not want to modify
    // templist
    list.add(new ArrayList<>(tempList));

    for (int i = start; i < nums.length; i++) {

      // Avoid index out of bound for getting nums[i-1] operation.
      
      // only skip the iteration when the duplicated elements has been counted.
      // (only two cases exist, i == index and i > index, the case when i == index
      // will only happen once and this time, it will be considered,
      // otherwise, it will not be considered. )
      
      if (i > start && nums[i] == nums[i - 1])
        continue;

      tempList.add(nums[i]);

      // making a recursive call from next index i+1;
      dfs(list, tempList, i + 1, nums);
      tempList.remove(tempList.size() - 1);
    }

  }

  public static void main(String[] args) {
    List<List<Integer>> res = subsets(new int[] { 1, 2, 2 });

    for (List<Integer> nums : res) {

      System.out.println(nums);

    }

  }
}
