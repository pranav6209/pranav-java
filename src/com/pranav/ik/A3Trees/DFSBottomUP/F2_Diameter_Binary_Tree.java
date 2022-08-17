/**
 * 
 */
package com.pranav.ik.A3Trees.DFSBottomUP;

/**
 * @author pranavpatel https://leetcode.com/problems/diameter-of-binary-tree/
 *         Time : O(N) Space : O(N) - Height of the tree
 * 
 *         topdown dfs will not work as we can not keep track of 2 individual
 *         longest path.
 * 
 *         Read the notes from Tree series 2 pdfs
 */

// bottom up DFS
public class F2_Diameter_Binary_Tree {

  private static class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
  }

  /*
   * Global problem : find dia of a whole tree.
   * Local(per-node) problem : find the longest inverted v-shaped path through the node 
   * Local -> Global: Global solution is the max of all the local solution
   * 
   * To get the local solution, each node needs to know from its two subtree what
   * their height are
   * 
   * 
   */

  static Integer diameterOfBinaryTree(TreeNode root) {

    int[] res = new int[] { 0 };
    if (root == null)
      return 0;
    helper(root, res);
    return res[0];

  }

  // this type of problems each node return some data(Height in this case) but then global we are calculating 
  // something else(Dia in the case). So before each node return height it will calculate dia and keep updating 
  // global variable if needed.
  private static int helper(TreeNode root, int[] res) {

    int myHeight = 0, myDia = 0;

    // leaf level node
    if (root.left == null && root.right == null)
      return 0;

    // Recursive call for internal node, they will have either left or right
    if (root.left != null) {

      int leftTreeHeight = helper(root.left, res);
      myHeight = 1 + leftTreeHeight;
      myDia = 1 + leftTreeHeight; // = myHeight

    }

    if (root.right != null) {

      int rightTreeHeight = helper(root.right, res);
      // as here leftTreeHeight height is calculated myHeight will be max of left and
      // right
      myHeight = Math.max(myHeight, 1 + rightTreeHeight);
      myDia = myDia + 1 + rightTreeHeight;

    }

    res[0] = Math.max(myDia, res[0]);

    return myHeight;

  }

}
