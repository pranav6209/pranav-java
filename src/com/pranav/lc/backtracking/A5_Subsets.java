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
 * https://leetcode.com/problems/subsets/
 * 
 * time complexity 0(2^N) -- where is n is total no elements in array
 * space complexity (N) -- max no of stack in recursion call is equal to no of elements in array
 * 
 * https://medium.com/@vasanths294/permutation-combination-subset-time-complexity-eca924e00071
 * 
 * recursion tree here also in google doc
 * https://leetcode.com/problems/subsets/discuss/27281/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
 *
 */
public class A5_Subsets {

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

    //creating a new arrayList base on temp list as we do not want to modify templist
    list.add(new ArrayList<>(tempList));

    for (int i = start; i < nums.length; i++) {

      tempList.add(nums[i]);
      //making a recursive call from next index i+1;
      dfs(list, tempList, i + 1, nums);
      tempList.remove(tempList.size() - 1);
    }

  }

  public static void main(String[] args) {
    List<List<Integer>> res = subsets(new int[] {2,3,6,7 });

    for (List<Integer> nums : res) {

      System.out.println(nums);

    }

  }
}
