/**
 * 
 */
package com.pranav.ik.A3Trees.DFSBottomUP;

/**
 * @author pranavpatel
 * 
 *         https://leetcode.com/problems/longest-univalue-path/submissions/
 * 
 *         here think problem in 2 parts.
 * 
 *         Global find longest unival path 
 *         local - per node find longest inverted V-shaped path through each node 
 *         Local -> Global Global solution will be max of all local solution
 * 
 *         to compute local solution, each node should know(from it left and
 *         right subtree..) what is the length of the longest unival path from
 *         the root down to some leaf this is the return value from each node to
 *         its parent
 *
 */
public class F3_2_Lonegest_UniValue_Path {
  private static class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
  }

  // path == no of edges between nodes
  public int longestUnivaluePath(TreeNode root) {

    if (root == null) {
      return 0;
    }

    int[] globalResult = new int[] { 0 };
    dfs(root, globalResult);
    return globalResult[0];

  }

  static int dfs(TreeNode node, int[] globalResult) {

    int myLongestVpath = 0;
    int myLongestpath = 0; // this is not v path. longest straight path from leaf to any node in tree

    // pass
    // if(node.left== null && node.right== null) return 0;

    if (node.left != null) {

      int leftPath = dfs(node.left, globalResult);

      // only update myLongestpath if node.val == node.left.val, as keep it zero
      if (node.val == node.left.val) {
        myLongestpath = 1 + leftPath;
        // if there is only left subtree longestVpath for that subtree ll be only
        // myLongestpath as there is no right subtree
        myLongestVpath = 1 + leftPath;
      }

    }

    if (node.right != null) {

      int rightPath = dfs(node.right, globalResult);

      if (node.val == node.right.val) {
        // if there is a right subtree,myLongestpath ll be max of left and right path
        myLongestpath = Math.max(myLongestpath, 1 + rightPath);
        // myLongestVpath path will be myLongestVpath(calculated using left + path
        // calulated using right)
        myLongestVpath = myLongestVpath + rightPath + 1;
      }

    }

    if (myLongestVpath > globalResult[0]) {
      globalResult[0] = myLongestVpath;
    }

    return myLongestpath;
  }

}
