/**
 * 
 */
package com.pranav.ik.A3Trees.DFSBottomUP;

/**
 * @author pranavpatel
 * 
 * 
 * 
 *  https://leetcode.com/problems/largest-bst-subtree/
 *  
 *  This is same problem as validate Binary search tree. only additional thing we are children are passing to root is height
 *
 */

// bottom down dfs.
public class F6_Largest_BST_SubTree {

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
    int size;

    DFSNode(TreeNode node, int largestValue, int smallestValue, boolean amIBst, int size) {

      this.node = node;
      this.largestValue = largestValue;
      this.smallestValue = smallestValue;
      this.amIBst = amIBst;
      this.size = size;
    }

  }

  public int largestBSTSubtree(TreeNode root) {

    if (root == null) {
      return 0;
    }

    int[] globalResult = new int[] { 0 };
    dfs(root, globalResult);
    return globalResult[0];

  }

  static DFSNode dfs(TreeNode node, int[] globalResult) {

    // size initialize to 1 considering that particular node is not null and we are
    // making DFS call for non null nodes
    int mySize = 1;
    boolean amIBst = true;
    int largestValue = node.val;
    int smallestValue = node.val;
    DFSNode dfsNode = null;
    TreeNode treeNode = null;

    // base case leaf node nothing special for leaf so avoid
    // if (node.left == null && node.right == null) {
    //
    // return 0;
    // }

    // recursive case. internal node

    if (node.left != null) {
      mySize = mySize++;
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
      mySize = mySize++;
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

    if (amIBst && mySize > globalResult[0]) {
      globalResult[0] = mySize;
    }

    return new DFSNode(treeNode, largestValue, smallestValue, amIBst, mySize);
  }
}