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
 * 
 * 
 *   time complexity : O(N!)
 *
 *   space complexity : O(N) where n is the no elements
 *   https://medium.com/@vasanths294/permutation-combination-subset-time-complexity-eca924e00071
 * 
 * 
 * 
 *    https://leetcode.com/problems/permutations-ii/discuss/18594/Really-easy-Java-solution-much-easier-than-the-solutions-with-very-high-vote
 *    
 *         
 *    I have implemented recursion tree using both the conditions :
 *         
      for Condition one - if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1] ) continue; .... Check this link - https://ibb.co/k4zv00
      
      
      // this solution 
      for condition two - if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] ) continue;....Check this link - https://ibb.co/ncMm7f
 *         
 *         
 *    both above solutions are valid but !used[i - 1] is more efficient compare to used[i-1]. with used[i-1]we get answer at almost end of the recursion.
 *    
 *    
 *   
 *    
 *    The basic idea is using DFS to put possible numbers to each i position, use boolean visited[] to flag the visited nodes, so that avoid accessing the same node many times. 
 *    
 *    more intuitive solution is user(i > 0 && nums[i] == nums[i - 1] && used[i - 1] ), means if the  nums[i] == nums[i - 1] and the same no is used before avoid.


 *         
 *
 */
public class A8_Permute2 {
  public static List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    if (nums == null || nums.length == 0)
      return res;

    // only if required
    Arrays.sort(nums);
    dfs(res, new ArrayList<>(), nums, new boolean[nums.length]);
    return res;
  }

  private static void dfs(List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] used) {
    if (tempList.size() == nums.length) {
      list.add(new ArrayList<>(tempList));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      
      if(used[i]) continue;
      if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])continue;
      
      used[i] = true;
      tempList.add(nums[i]);
      dfs(list, tempList, nums, used);
      used[i] = false;
      tempList.remove(tempList.size() - 1);

    }
  }

  public static void main(String[] args) {
    List<List<Integer>> res = permute(new int[] { 1, 2, 2 });

    for (List<Integer> nums : res) {

      System.out.println(nums);

    }

  }
}
