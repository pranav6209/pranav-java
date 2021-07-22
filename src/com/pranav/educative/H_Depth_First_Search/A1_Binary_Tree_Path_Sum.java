/**
 * 
 */
package com.pranav.educative.H_Depth_First_Search;

import com.pranav.TreeNode;

/**
 * @author pranavpatel
 * 
 * Time : O(N) in case we have a skewed tree with. we are visiting all the node.
 * Space : O(N) if we do not have binary tree and a skewed tree
 * 
 * 
 * remember it is Binary Tree and not Binary Search Tree
 * 
 *
 */
public class A1_Binary_Tree_Path_Sum {
  public static boolean hasPath(TreeNode root, int sum) {

    // recursion base case.
    if (root == null)
      return false;

    // checking leaf node and sum value
    if (root.val == sum && root.left == null && root.right == null)
      return true;

    return hasPath(root.left, sum - root.val) || hasPath(root.right, sum - root.val);

  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    System.out.println("Tree has path: " + A1_Binary_Tree_Path_Sum.hasPath(root, 23));
    //System.out.println("Tree has path: " + A1_Binary_Tree_Path_Sum.hasPath(root, 16));
  }
}
