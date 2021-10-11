/**
 * 
 */
package com.pranav.ik.A3Trees.DFSTopDown;

import java.util.ArrayList;
import java.util.List;

// explanation 3:20:00 Tree series 2

// top-down DFS
public class D6_Invert_Binary_Tree {

  private static class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
  }

  public TreeNode invertTree(TreeNode root) {

    if (root == null)
      return root;
    DFS(root);

    return root;

  }

  // 3:50:00
  public static TreeNode DFS(TreeNode node) {

    // nothing special here for leaf node,can pass
    // if (node.left == null && node.right == null)
    // return node;

    // what if we have either left is null or right is null or both null for leaf
    
    // in sum of the cases we might assign null value to node.left and node.right as old left
    // and oldRight might be null we are not tracking null in first 4 lines.
    // But when we ll execute recursive case it will stop

    TreeNode oldLeft = node.left;
    TreeNode oldRight = node.right;
    node.left = oldRight;
    node.right = oldLeft;

    if (node.left != null) {
      DFS(node.left);
    }

    if (node.right != null) {
      DFS(node.right);
    }

    return node;
  }
}
