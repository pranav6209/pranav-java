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

  public boolean isSymmetric(TreeNode root) {
    
    if(root == null) return true;
    
    boolean[] res = new boolean[]{true};
    
    // imp
    dfs(root,root,res);
    
    return res[0];
    
}

  private static void dfs(TreeNode p, TreeNode q, boolean[] res) {

    if (p.val != q.val)
      res[0] = false;

    // if p has a left and q doesn't have left or p doesn't have left and q have
    // left in that case return fasle
    if ((p.left != null && q.right == null) || (p.left == null && q.right != null))
      res[0] = false;

    if (p.left != null && q.right != null)

      dfs(p.left, q.right, res);

    // if p has a right and q doesn't have right or p doesn't have right and q have
    // right in that case return fasle

    if ((p.right != null && q.left == null) || (p.right == null && q.left != null))
      res[0] = false;

    if (p.right != null && q.left != null)
      dfs(p.right, q.left, res);

  }
}
