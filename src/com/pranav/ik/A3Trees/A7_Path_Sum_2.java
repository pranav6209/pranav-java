/**
 * 
 */
package com.pranav.ik.A3Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author pranavpatel
 * 
 *        https://leetcode.com/problems/path-sum-ii/
 * 
 *         Explanation 2:40:00 OD video
 *          
 *         Time : O(NLogN) N workers do constant work plus work done for copying
 *         
 *         making a copy 
 *         
 *         space : O(NLogN) for DFS height of the
 *         tree skewed tree O(N) Binary Tree O(logN)
 *
 */


// top-down DFS
public class A7_Path_Sum_2 {

  private static class TreeNode {
    public int val;
    public TreeNode left_ptr;
    public TreeNode right_ptr;
  }
  private static List<List<Integer>> res = new ArrayList<>();
  static List<List<Integer>> all_paths_sum_k(TreeNode root, int k) {
    List<Integer> slate = new ArrayList<>();
    if (root == null)
      return null;
    DFS(root, k, slate);
    if (res.isEmpty())
      res.add(new ArrayList<>(Arrays.asList(-1)));
    return res;

  }

  
  
  public static void DFS(TreeNode root, int sum, List<Integer> slate) {

    if (root.val == sum && root.left_ptr == null) {
      if (root.right_ptr == null) {
        // put it in arraylist O(N) operation
        slate.add(root.val);
        // make a copy and add it to global box
        res.add(new ArrayList<>(slate));
        // here slate is mutable so we have to revert changes
        slate.remove(slate.size() - 1);
        return;
      }
    
    }

    // inclusion case
    if (root.left_ptr != null) {
      slate.add(root.val);
      DFS(root.left_ptr, sum - root.val, slate);
      slate.remove(slate.size() - 1);
    }

    // inclusion case no exclusion case here
    if (root.right_ptr != null) {
      slate.add(root.val);
      DFS(root.right_ptr, sum - root.val, slate);
      slate.remove(slate.size() - 1);
    }
  }

}
