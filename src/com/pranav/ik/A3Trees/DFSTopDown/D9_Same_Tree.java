/**
 * 
 */
package com.pranav.ik.A3Trees.DFSTopDown;

/**
 * @author pranavpatel
 *
 */
public class D9_Same_Tree {

  private static class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
  }

  public boolean isSameTree(TreeNode p, TreeNode q) {

    if (p == null && q == null)
      return true;

    // if one of the null return false
    if (p == null || q == null)
      return false;

    boolean[] res = new boolean[] { true };

    dfs(p, q, res);

    return res[0];

  }

  private static void dfs(TreeNode node1, TreeNode node2, boolean[] res) {

    if (node1.val != node2.val)
      res[0] = false;

    // if p has a left and q doesn't have left or p doesn't have left and q have
    // left in that case return fasle
    if ((node1.left != null && node2.left == null) || (node1.left == null && node2.left != null))
      res[0] = false;

    if (node1.left != null && node2.left != null)

      dfs(node1.left, node2.left, res);

    // if p has a right and q doesn't have right or p doesn't have right and q have
    // right in that case return fasle

    if ((node1.right != null && node2.right == null) || (node1.right == null && node2.right != null))
      res[0] = false;

    if (node1.right != null && node2.right != null)
      dfs(node1.right, node2.right, res);

  }
}
