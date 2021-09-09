/**
 * 
 */
package com.pranav.ik.A3Trees.DFSTopDown;

/**
 * @author pranavpatel
 *
 */
public class E1_Symmetric_Tree {

  private static class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
  }

  public boolean isSameTree(TreeNode node1, TreeNode q) {

    if (node1 == null && q == null)
      return true;

    // if one of the null return false
    if (node1 == null || q == null)
      return false;

    boolean[] res = new boolean[] { true };

    dfs(node1, q, res);

    return res[0];

  }

  private static void dfs(TreeNode p, TreeNode q, boolean[] res) {

    if (p.val != q.val)
      res[0] = false;

    // if p has a left and q doesn't have left or p doesn't have left and q have
    // left in that case return fasle
    if ((p.left != null && q.left == null) || (p.left == null && q.left != null))
      res[0] = false;

    if (p.left != null && q.left != null)

      dfs(p.left, q.left, res);

    // if p has a right and q doesn't have right or p doesn't have right and q have
    // right in that case return fasle

    if ((p.right != null && q.right == null) || (p.right == null && q.right != null))
      res[0] = false;

    if (p.right != null && q.right != null)
      dfs(p.right, q.right, res);

  }
}
