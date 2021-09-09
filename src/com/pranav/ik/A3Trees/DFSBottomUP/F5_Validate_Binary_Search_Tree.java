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
 *         Global problem is determine if the tree is BST
 *         
 *         local problem, sub tree rooted at each node is a BST
 * 
 *          Local -> Global all local problem must return true for global solution to be true
 *          so if any local solution is false global will become false
 *          
 *          
 *          Node will determine if it is a BST by looking at its left and right subtrees 
 *          The largest value in left subtree should be smaller than the root value.
 *          The smallest value on the right subtree should be larget than the root value. 
 *          Both subtrees should be BST
 *          so each node should return (smalles,largest,isBST) value in its subtree back to its parent
 *
 */

// bottom down dfs.
public class F5_Validate_Binary_Search_Tree {

  private static class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
  }

  private static class DFSNode {
    TreeNode node;
    int largestValue;
    int smallestValue;
    boolean amIBst;

    DFSNode(TreeNode node, int largestValue, int smallestValue, boolean amIBst) {

      this.node = node;
      this.largestValue = largestValue;
      this.smallestValue = smallestValue;
      this.amIBst = amIBst;
    }

  }


  
  
  public boolean isValidBST(TreeNode root) {

    if (root == null) {
      return true;
    }

    boolean[] globalResult = new boolean[] { true };
    dfs(root, globalResult);
    return globalResult[0];

  }
  
  static DFSNode dfs(TreeNode node, boolean[] globalResult) {

    boolean amIBst = true;
    int largestValue = Integer.MIN_VALUE;
    int smallestValue = Integer.MAX_VALUE;
    DFSNode dfsNode = null;
    TreeNode treeNode = null;

    // base case leaf node nothing special for leaf so avoid
    // if (node.left == null && node.right == null) {
    //
    // return 0;
    // }

    // recursive case. internal node

    if (node.left != null) {
      dfsNode = dfs(node.left, globalResult);
      // update smallest and largest value we are getting from the subtree
      smallestValue = Math.min(dfsNode.smallestValue, smallestValue);
      largestValue = Math.max(dfsNode.largestValue, largestValue);

      // check BST condition,

      // if left subtree is not BST or largest Value of the node is greater than or
      // equal to current node val - I am not a BST

      if (!dfsNode.amIBst || largestValue >= node.val)
        amIBst = false;
      treeNode = node.left;
    }

    if (node.right != null) {
      dfsNode = dfs(node.right, globalResult);
      // update smallest and largest value we are getting from the subtree
      smallestValue = Math.min(dfsNode.smallestValue, smallestValue);
      largestValue = Math.max(dfsNode.largestValue, largestValue);

      // check BST condition,

      // if left subtree is not BST or largest Value of the node is greater than or
      // equal to current node val - I am not a BST

      if (!dfsNode.amIBst || smallestValue <= node.val)
        amIBst = false;
      treeNode = node.right;
    }

    if (!amIBst) {
      globalResult[0] = false;
    }

    return new DFSNode(treeNode, largestValue, smallestValue, amIBst);
  }
}