/**
 * 
 */
package com.pranav.ik.A3Trees.DFSBottomUP;

/**
 * @author pranavpatel
 * 
 * 
 *         read initial notes from slides tree series 2 Time : O(N) Space :O(N)
 *         height of the tree
 * 
 *         https://leetcode.com/problems/count-univalue-subtrees/
 * 
 *         explanation 4:48:00 tree series 2
 *         
 *         counting problem
 *
 */

// bottom down dfs.
public class F3_1_Uni_Value_SubTree {

  private static class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
  }

  
  /*
   * Global problem : count unival subtree
   * Local(per-node) problem : find subtree rooted under me is unival or not.if it is add 1 to global count.
   * to determine subtree is unival root node need to determine if 2 children are unival. so that is the info need to return by child to
   * parent 
   * Local -> Global: Global solution is the count of all the local solution

   * 
   * 
   */
  
  // Here each node returns weather it is unival or not and globally we are counting no of unival
  static int findSingleValueTrees(TreeNode root) {

    if (root == null) {
      return 0;
    }

    int[] globalCount = new int[] { 0 };
    dfs(root, globalCount);
    return globalCount[0];

  }

  // return true if subtree rooted at node is unival and false otherwise
  static boolean dfs(TreeNode node, int[] globalCount) {

    // base case leaf node
    if (node.left == null && node.right == null) {
      globalCount[0]++;
      return true;
    }

    // recursive case. internal node

    // initialize as true
    boolean amIUnival = true;

    if (node.left != null) {
      // leftUnival is true if left subtree is unival false otherwise.

      // if left side tree is not unival or node.val is not node.left_ptr.val,I am not unival
      boolean leftUnival = dfs(node.left, globalCount);
      if (!leftUnival || node.left.val != node.val)
        amIUnival = false;
    }

    if (node.right != null) {
      boolean rightUnival = dfs(node.right, globalCount);
      
      if (!rightUnival || node.right.val != node.val)
        amIUnival = false;
    }
    
    // if I am unival add it to global counter and return my value to my parent
    if (amIUnival)
      globalCount[0]++;
    return amIUnival;

  }

}
