/**
 * 
 */
package com.pranav.ik.A3Trees.DFSTopDown;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author pranavpatel
 * 
 *         https://leetcode.com/problems/path-sum-ii/
 * 
 *         Explanation live class 2:40:00 OD video
 * 
 *         Time : O(NLogN) N workers do constant work plus work done for copying
 * 
 *         making a copy
 * 
 *         space : O(NLogN) for DFS height of the tree skewed tree O(N) Binary
 *         Tree O(logN)
 *
 */

// top-down DFS
public class D3_Path_Sum_2 {

  private static class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
  }

  static List<List<Integer>> all_paths_sum_k(TreeNode root, int targateSum) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> slate = new ArrayList<>();
    if (root == null)
      return res;
    DFS(root, targateSum, 0, slate, res);

    // for IK test case
    // if (res.isEmpty())
    // res.add(new ArrayList<>(Arrays.asList(-1)));
    return res;

  }

  public static void DFS(TreeNode node, int targateSum, int sumSlate, List<Integer> slate, List<List<Integer>> res) {

    // common to root and leaf node
    slate.add(node.val);
    sumSlate = sumSlate + node.val;

    if (node.left == null && node.right == null) {
      if (sumSlate == targateSum) {
        res.add(new ArrayList<>(slate));
      }
    }

    if (node.left != null) {
      DFS(node.left, targateSum, sumSlate, slate, res);
    }

    if (node.right != null) {
      DFS(node.right, targateSum, sumSlate, slate, res);
    }

    // common to root and leaf node
    slate.remove(slate.size() - 1);
  }

}
