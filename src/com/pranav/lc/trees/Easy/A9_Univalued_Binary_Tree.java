/**
 * 
 */
package com.pranav.lc.trees.Easy;

import com.pranav.lc.trees.TreeNode;
import com.pranav.lc.trees.TreePrinter;

/**
 * @author pranavpatel
 * 
 *        https://leetcode.com/problems/univalued-binary-tree/
 * 
 *         https://leetcode.com/problems/univalued-binary-tree/discuss/211397/JavaPython-3-BFS-and-DFS-clean-codes-w-brief-analysis.
 *         https://leetcode.com/problems/univalued-binary-tree/submissions/
 *
 */
public class A9_Univalued_Binary_Tree {

  // Time & space: O(n), where n is the total number of nodes in the tree.
  public static boolean isUnivalTree1(TreeNode root) {
    return dfs(root, root.val);

  }

  static boolean dfs(TreeNode node, int value) {
    if (node == null)
      return true;
    if (node.val != value)
      return false;
    return dfs(node.left, value) && dfs(node.right, value);

  }

  // Time & space: O(n), where n is the total number of nodes in the tree.like this cleaner code. Above is just for  better coding
  public static boolean isUnivalTree2(TreeNode root) {

    if (root == null)
      return true;

    // STEP - 1
    boolean left = isUnivalTree2(root.left);
    // STEP - 2
    boolean right = isUnivalTree2(root.right);
    // STEP - 3
    if (root != null) {
      if (root.left != null && root.val != root.left.val)
        return false;
      if (root.right != null && root.val != root.right.val)
        return false;
    }
    return left && right;
  }

  public static void main(String[] args) {

    // Node is defined in A_Maximum_Depth_Of_Binary_Tree
    TreeNode root = new TreeNode(2);
    root.left = new TreeNode(2);
    root.right = new TreeNode(2);
    root.left.right = new TreeNode(2);
    root.left.left = new TreeNode(1);
    TreePrinter.printNode(root);
    System.out.println(isUnivalTree2(root));
  }

}
