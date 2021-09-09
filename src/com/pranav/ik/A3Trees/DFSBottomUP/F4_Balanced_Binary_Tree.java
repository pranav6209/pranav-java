/**
 * 
 */
package com.pranav.ik.A3Trees.DFSBottomUP;

/**
 * @author pranavpatel
 * 
 * 
 * 
 *         https://leetcode.com/problems/balanced-binary-tree/submissions/
 * 
 *         This is a decision problem.
 * 
 *         Global problem is determine whole tree is height balanced 
 *         local problem each node will determine whether it is balanced 
 *         local -> global if each node is height balanced then whole tree is height
 *         balanced
 * 
 *         to solve local problem, each node needs to know the heights of its
 *         left and right subtree
 * 
 *         each node will return height to its parent
 * 
 *         This tree is different from uni val as in unival, we have to check
 *         weather tree is uni val or not based on it subtree so if subtree
 *         under it not a unival that tree is not unival but here we are
 *         counting height and we are counting it each level
 *
 */

// bottom down dfs.
public class F4_Balanced_Binary_Tree {

  private static class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
  }

  public boolean isBalanced(TreeNode root) {

    if (root == null) {
      return true;
    }

    boolean[] globalResult = new boolean[] { true };
    dfs(root, globalResult);
    return globalResult[0];

  }

  static int dfs(TreeNode node, boolean[] globalResult) {

    // base case leaf node
    if (node.left == null && node.right == null) {

      return 0;
    }

    // recursive case. internal node

    // initialize as true
    // boolean amIBalance = true;
    int myHeight = 0;
    int leftSubTreeHeight = 0;
    int rightSubTreeHeight = 0;

    if (node.left != null) {
      leftSubTreeHeight = 1 + dfs(node.left, globalResult);

    }

    if (node.right != null) {
      rightSubTreeHeight = 1 + dfs(node.right, globalResult);
    }

    myHeight = Math.max(leftSubTreeHeight, rightSubTreeHeight);

    
    // here in a optimization problems we can return false as soon as we find it but not a good practice
    if (Math.abs(leftSubTreeHeight - rightSubTreeHeight) > 1) {
      globalResult[0] = false;
    }

    return myHeight;

  }

}
