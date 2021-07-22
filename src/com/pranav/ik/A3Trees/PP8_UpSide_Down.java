/**
 * 
 */
package com.pranav.ik.A3Trees;

/**
 * @author pranavpatel
 *
 */
public class PP8_UpSide_Down {

  private static class TreeNode {
    public int val;
    public TreeNode left_ptr;
    public TreeNode right_ptr;
  }

  /*
   * Global problem is turn tree upside down 
   * 
   * locally speaking each node needs to redirect its right child pointer to point to its parent and to redirect its 
   * left pointer to parent's right sibling 
   * 
   *  before we do so we should store old left and old right else we ll loose track of it. 
   */

  //Top down dfs
  private static TreeNode globalRoot = null;

  static TreeNode flipUpsideDown(TreeNode root) {

    if (root == null)
      return globalRoot;

    dfs(root, null, null);

    return globalRoot;
  }
  
  // follow dfs template 1. process the data 2
  
  // each node gets parent and parentRight side from above
  private static void dfs(TreeNode node, TreeNode parent, TreeNode parentRightSide) {

    // 1. process the data
    TreeNode oldLeft = node.left_ptr;
    TreeNode oldRight = node.right_ptr;

    node.left_ptr = parentRightSide;
    node.right_ptr = parent;

    // 2. base case:  if we are at the leaf that is our new root
    if (oldLeft == null && oldRight == null) {
      globalRoot = node;
      return;
    }

    // 3 recursive case

    if (oldLeft != null) {

      dfs(oldLeft, node, oldRight);
    }

  }
}
