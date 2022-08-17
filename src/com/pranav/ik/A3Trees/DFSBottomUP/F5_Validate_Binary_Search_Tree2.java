/**
 * 
 */
package com.pranav.ik.A3Trees.DFSBottomUP;

/**
 * @author pranavpatel
 * 
 * 
 * 
 *         https://leetcode.com/problems/balanced-binary-tree/submissions/
 * 
 *         This is a decision problem.
 * 
 *         Global problem is determined if the tree is BST
 * 
 *         local problem, sub tree rooted at each node is a BST
 * 
 *         Local -> Global all local problem must return true for global
 *         solution to be true so if any local solution is false global will
 *         become false
 *
 *         Read through Leetcode solution approach - 1
 * 
 *
 *
 */

// top down dfs.
public class F5_Validate_Binary_Search_Tree2 {

  private static class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
  }

  public boolean isValidBST(TreeNode root) {

    if (root == null) {
      return true;
    }

    boolean[] globalResult = new boolean[] { true };
    dfs(root, globalResult, Integer.MIN_VALUE, Integer.MAX_VALUE);
    return globalResult[0];

  }

  
  static void dfs(TreeNode node, boolean[] globalResult, int minVal, int maxVal) {


    if (node.val >= maxVal || node.val <= minVal) {
      globalResult[0] = false;
      return;
    }
    if (node.left != null) {
      dfs(node.left, globalResult, minVal, node.val);
    }

    if (node.right != null) {
      dfs(node.right, globalResult, node.val, maxVal);
    }
  }
}