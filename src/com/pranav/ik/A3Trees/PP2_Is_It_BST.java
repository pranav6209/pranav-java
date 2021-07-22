/**
 * 
 */
package com.pranav.ik.A3Trees;

/**
 * @author pranavpatel
 *
 */

// top down DFS
public class PP2_Is_It_BST {

  private static class TreeNode {
    public int val;
    public TreeNode left_ptr;
    public TreeNode right_ptr;
  }

  private static boolean isBST = true;

  static boolean isBST(TreeNode root) {
    if(root == null) return isBST;
    helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    return isBST;
  }

  static void helper(TreeNode node, int minVal, int maxVal) {

    if (node == null)
      return;

    if (node.val < minVal || node.val > maxVal) {
      isBST = false;
      return;
    }

    helper(node.left_ptr, minVal, node.val);
    helper(node.right_ptr, node.val, maxVal);

  }
}
