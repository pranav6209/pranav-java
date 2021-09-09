
/**
 * 
 */
package com.pranav.ik.A3Trees.DFSTopDown;

/**
 * @author pranavpatel
 * 
 *         time : input O(N) + call space
 *         
 *         ask interviewer if we can use global variable ??
 *         
 *         solution with global variable 
 *         https://leetcode.com/problems/path-sum/
 *
 */
public class D2_Path_Sum {

  private static class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
  }

  public boolean hasPathSum(TreeNode root, int targetSum) {

    // this edge case is subjective
    if (root == null)
      return false;

    // here LC doesn't allow declaring global variable, so passing one
    // dimensional array by reference as we can not pass it by value

    // here we are doing top down dfs so child node doesn't return anything to
    // parent. either they write down to a global variable
    // but as declaring global variable is not allowed or not a best practice for
    // interview, passing global res by reference
    
    boolean[] res = new boolean[] { false };
    dfs(root, 0, targetSum, res);

    return res[0];
  }

  // TreeNode root is subproblem definition
  // slate is Partial solution
  // for any arbitary worker
  // top down dfs
  private static void dfs(TreeNode node, int sumSlate, int targetSum, boolean[] res) {

    
    // common to leaf and internal node
    sumSlate = sumSlate + node.val;

    // base case leaf node
    if (node.left == null && node.right == null) {

      if (sumSlate == targetSum)
        res[0] = true;
      // return;
    }

    // internal node
    if (node.left != null) {

      dfs(node.left, sumSlate, targetSum, res);

    }

    if (node.right != null) {

      dfs(node.right, sumSlate, targetSum, res);

    }
  }

}
