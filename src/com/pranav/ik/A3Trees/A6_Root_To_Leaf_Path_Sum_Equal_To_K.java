/**
 * 
 */
package com.pranav.ik.A3Trees;

/**
 * @author pranavpatel
 * 
 *         Time : O(N) each worker do the work mentioned in DFS which is
 *         constant and for N worker O(N) 
 *         
 *         space : O(N) for DFS height of the
 *         tree skewed tree O(N) Binary Tree O(logN)
 *         
 *         https://leetcode.com/problems/path-sum/
 *
 */



/*
 * lazy manager approach as higher level roots are subtracting there value from
 * target and then leaving work to their sub ordinate.
 */

/*
 * information is passing from top to bottom.So, recursive function is not returning anything as Nothing returns back from leaf to
 * top. as soon as leaf level node confirms that there is a target sum, they are going to update the global result
 */
 
//top-down DFS
public class A6_Root_To_Leaf_Path_Sum_Equal_To_K {

  private static class TreeNode {
    public int val;
    public TreeNode left_ptr;
    public TreeNode right_ptr;
  }

  private static boolean isPathValid;

  static Boolean path_sum(TreeNode root, int k) {

    if (root == null)
      return false;
    dfs(root, k);
    return isPathValid;
  }

  /*
   * 
   * DFS template 1. process the data 2. base case 3. recursive case
   * 
   * each roots get node and remaining target value to work on from parent.Think this function
   * as what work each node will do
   * 
   * 
   */
  private static void dfs(TreeNode node, long target) {

    if(isPathValid) return;
    
    // base case leaf node
    if (node.left_ptr == null && node.right_ptr == null) {
      // node value is equal to remaining target
      if (node.val == target) {
        isPathValid = true;
      }
      return;
    }

    if (node.left_ptr != null)
      // as information is passing down we need to subtract node.val from target
      dfs(node.left_ptr, target - node.val);

    if (node.right_ptr != null)
      dfs(node.right_ptr, target - node.val);

  }

}
