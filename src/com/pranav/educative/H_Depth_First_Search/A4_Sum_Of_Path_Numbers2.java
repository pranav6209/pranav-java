/**
 * 
 */
package com.pranav.educative.H_Depth_First_Search;

import com.pranav.TreeNode;

/**
 * @author pranavpatel
 *
 */
public class A4_Sum_Of_Path_Numbers2 {
  static int ans = 0;

  public static int findSumOfPathNumbers(TreeNode root) {
    findRootToLeafPathNumbers(root, 0);
    return ans;
  }

  private static void findRootToLeafPathNumbers(TreeNode currentNode, int pathSum) {
    
    // base case
    if (currentNode == null)
      return;

    // calculate the path number of the current node
    pathSum = 10 * pathSum + currentNode.val;

    // if the current node is a leaf, return the current path sum.
    if (currentNode.left == null && currentNode.right == null) {
      ans = ans+pathSum;
    }

    // traverse the left and the right sub-tree
    findRootToLeafPathNumbers(currentNode.left, pathSum) ;
    findRootToLeafPathNumbers(currentNode.right, pathSum);

  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(0);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(1);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(5);
    System.out.println("Total Sum of Path Numbers: " + A4_Sum_Of_Path_Numbers2.findSumOfPathNumbers(root));
  }

}
