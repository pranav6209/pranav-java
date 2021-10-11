/**
 * 
 */
package com.pranav.ik.A3Trees.DFSTopDown;

/**
 * @author pranavpatel
 * https://leetcode.com/problems/binary-tree-upside-down/
 *
 */
public class D8_UpSide_Down {

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
   TreeNode globalRoot = null;

   public TreeNode upsideDownBinaryTree(TreeNode root) {

    if (root == null)
      return globalRoot;
    // initial root doesn't have parent and right so pass null
    dfs(root, null, null);

    return globalRoot;
  }
  
  // follow dfs template 1. process the data 2
  
  // each node gets parent and parentRight side from above. think abt node 2 in leetcode example 1 
  private void dfs(TreeNode node, TreeNode parent, TreeNode parentRightSide) {

    // 1. process the data
    TreeNode oldLeft = node.left_ptr;
    TreeNode oldRight = node.right_ptr;

    node.left_ptr = parentRightSide;
    node.right_ptr = parent;

    // 2. base case:  if we are at the leaf that is our new root. 
    // as we are only making DFS call for left, we ll have only one leaf from left
    if (oldLeft == null && oldRight == null) {
      globalRoot = node;
      return;
    }

    // 3 recursive case

    if (oldLeft != null) {

      dfs(oldLeft, node, oldRight);
    }

     //no call to right
  }
}
