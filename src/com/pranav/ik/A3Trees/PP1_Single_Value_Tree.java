/**
 * 
 */
package com.pranav.ik.A3Trees;

/**
 * @author pranavpatel
 * 
 * Time : O(N)
 * Space :O(N) hegith of the tree
 * 
 * https://leetcode.com/problems/count-univalue-subtrees/
 * 
 * Tree with n node will have n sub tree
 *
 */

// bottom down dfs. if we need info from sub tree it has to come from below
public class PP1_Single_Value_Tree {

  private static class TreeNode {
    public int val;
    public TreeNode left_ptr;
    public TreeNode right_ptr;
  }

  private static int count=0;
  static int findSingleValueTrees(TreeNode root) {

    if (root == null) {
      return 0;
    }

    int[] count = new int[1];
    dfs(root);
    return count[0];

  }

  /*
   * each node computes subtree rooted at it is univalue global soln is sum of all
   * local unival
   * 
   * 1. compute weather I am unival and return that to parent 
   * 2. Based on I am unival or not add 1 to the global count
   */
  
  //think this function as what each node will do
  static boolean dfs(TreeNode node) {

    // base case leaf node
    if (node.left_ptr == null && node.right_ptr == null) {
      count++; //2
      return true; // 1
    }

    // recursive case. interal node
    int nodeVal = node.val;
    
    // if we are not sure that tree has left or right child assume here that it is unival
    boolean amIUnival = true;
    
    if (node.left_ptr != null) {
      boolean leftUnival = dfs(node.left_ptr);
      amIUnival = amIUnival && leftUnival && (node.left_ptr.val == nodeVal);
    }

    if (node.right_ptr != null) {
      boolean rightUnival = dfs(node.right_ptr);
      amIUnival = amIUnival && rightUnival && (node.right_ptr.val == nodeVal);
    }
    if(amIUnival) count++;//2
    return amIUnival;//1

  }

}
