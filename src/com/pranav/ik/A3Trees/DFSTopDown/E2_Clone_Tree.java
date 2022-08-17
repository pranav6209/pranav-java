/**
 * 
 */
package com.pranav.ik.A3Trees.DFSTopDown;

/**
 * @author pranavpatel
 *
 */
public class E2_Clone_Tree {

  private static class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }

    TreeNode(int val) {
      this.val = val;

    }
  }

  public TreeNode cloneTree(TreeNode root) {

    if (root == null)
      return root;

    TreeNode root2 = new TreeNode(root.val);

     dfs(root, root2);

     return root2;

  }

  private static void dfs(TreeNode node1, TreeNode node2) {

    if (node1.left != null) {
      node2.left = new TreeNode(node1.left.val);
      dfs(node1.left, node2.left);
    }

    if (node1.right != null) {
      node2.right = new TreeNode(node1.right.val);
      dfs(node1.right, node2.right);
    }
  }
}
