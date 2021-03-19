/**
 * 
 */
package com.pranav.educative.H_Depth_First_Search;

import com.pranav.TreeNode;

/**
 * @author pranavpatel
 *
 */
public class A4_Sum_Of_Path_Numbers3 {
  public static int findSumOfPathNumbers(TreeNode root) {
    return findRootToLeafPathNumbers(root, 0);
  }

  private static int findRootToLeafPathNumbers(TreeNode currentNode, int pathSum) {
    if (currentNode == null)
      return 0;

    // calculate the path number of the current node
    pathSum = 10 * pathSum + currentNode.val;

    // if the current node is a leaf, return the current path sum.
    if (currentNode.left == null && currentNode.right == null) {
      return pathSum;
    }

    // traverse the left and the right sub-tree
    return findRootToLeafPathNumbers(currentNode.left, pathSum) + findRootToLeafPathNumbers(currentNode.right, pathSum);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(7);
    root.right = new TreeNode(9);
    root.right.left = new TreeNode(2);
    root.right.right = new TreeNode(9);
    System.out.println("Total Sum of Path Numbers: " + A4_Sum_Of_Path_Numbers3.findSumOfPathNumbers(root));
  }

}
