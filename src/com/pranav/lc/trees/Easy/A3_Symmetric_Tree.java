/**
 * 
 */
package com.pranav.lc.trees.Easy;

import com.pranav.lc.trees.TreeNode;
import com.pranav.lc.trees.TreePrinter;

/**
 * @author pranavpatel
 * 
 *         https://leetcode.com/problems/symmetric-tree/description/
 * 
 *         time complexity : O(N) - as visiting each node once space complexity:
 *         O(h) - height if binary tree basically O(N)
 * 
 *
 */
public class A3_Symmetric_Tree {
  public static boolean isSymmetric(TreeNode root) {

    if (root == null)
      return true;

    TreeNode left = root.left;
    TreeNode right = root.right;

    return isSameTree(left, right);

  }

  public static boolean isSameTree(TreeNode p, TreeNode q) {

    if (p == null && q == null)
      return true;
    if (p == null || q == null)
      return false;
    if (p.val != q.val)
      return false;

    return isSameTree(p.left, q.right) && isSameTree(p.right, q.left);

  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.right = new TreeNode(2);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(4);
    root.right.left = new TreeNode(4);
    root.right.right = new TreeNode(3);

    TreePrinter.printNode(root);
    System.out.println(isSymmetric(root));
  }

}
