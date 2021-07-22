/**
 * 
 */
package com.pranav.ik.A3Trees;

/**
 * @author pranavpatel
 * https://leetcode.com/problems/diameter-of-binary-tree/
 * Time : O(N)
 * Space : O(N) - Height of the tree
 * 
 * Each Node find the longest inverted V-path through itself. Lazy manager approach 
 * will not work here.Manager will collect all the info. We ll find all the possible 
 * solution and then keep updating global variable with max 
 *
 */


// bottom up DFS
public class A8_Diameter_Binary_Tree {

  private static class TreeNode {
    public int label;
    public TreeNode left_ptr;
    public TreeNode right_ptr;
  }

  static int treeDia = 0;
  static Integer binary_tree_diameter(TreeNode root) {

    if (root == null)
      return 0;
    helper(root);
    return treeDia;

  }

  /*
   * Each Node find the longest inverted V-path through itself and return node
   * above no information coming from above so just pass root each node is
   * computing local dia. if the local dia is bigger update the global answer
   * 
   * 1. compute my own height and pass it upto my parent 
   * 2. compute the local dia from LH and RH
   */
  
  // think this function as what each node will do
  private static int helper(TreeNode root) {

    int leftTreeHeight = 0;
    int rightTreeHeight = 0;

    // leaf level node
    if (root.left_ptr == null && root.right_ptr == null)
      return 0;

    // Recursive call for internal node, they will have either left or right  
    if (root.left_ptr != null) {
      
      // once the height is calculated add your self
      leftTreeHeight = helper(root.left_ptr) + 1;

    }

    if (root.right_ptr != null) {

      rightTreeHeight = helper(root.right_ptr) + 1;

    }
    
    // each node is computing local dia. if the local dia is bigger 
    // update the global answer
    int dia = leftTreeHeight + rightTreeHeight;

    treeDia = Math.max(dia, treeDia);
    
    // each node is computing it's own height and returning it to parent
    return Math.max(leftTreeHeight, rightTreeHeight);

  }

}
