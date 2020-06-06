/**
 * 
 */
package com.pranav.lc.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pranavpatel
 * 
 * https://leetcode.com/problems/permutations/
 * 
 * 
 * time complexity : O(N!+N) where n is the no elements. additional N for tempList.contains()
 *
 * space complexity : O(N) where n is the no elements  
 * 
 * 
 * https://medium.com/@vasanths294/permutation-combination-subset-time-complexity-eca924e00071
 *
 */
public class A7_Permute {
  public static List<List<Integer>> permute(int[] nums) {

    List<List<Integer>> res = new ArrayList<>();
    
    if(nums==null || nums.length==0) return res;
    
    // if required
    //Arrays.sort(nums);
    dfs(res, new ArrayList<>(), nums);

    return res;

  }

  public static void dfs(List<List<Integer>> list, List<Integer> tempList, int[] nums) {

    if (tempList.size() == nums.length) {

      list.add(new ArrayList<>(tempList));

      return;

    }

    for (int i = 0; i < nums.length; i++) {

      // if list has the element skip
      // O(N) operation. we can convert to map for constant time operation. just tell interviewer don't have to do it
      if (tempList.contains(nums[i]))
        continue;
      tempList.add(nums[i]);

      dfs(list, tempList, nums);

      tempList.remove(tempList.size() - 1);

    }

  }

  public static void main(String[] args) {
    List<List<Integer>> res = permute(new int[] { 1, 2, 3 });

    for (List<Integer> nums : res) {

      System.out.println(nums);

    }

  }
}
