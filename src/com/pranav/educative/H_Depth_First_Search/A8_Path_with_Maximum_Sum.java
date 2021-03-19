
/**
 * 
 */
package com.pranav.educative.H_Depth_First_Search;

import com.pranav.lc.trees.TreeNode;
import com.pranav.lc.trees.TreePrinter;

/**
 * @author pranavpatel
 *         https://leetcode.com/problems/binary-tree-maximum-path-sum/
 * 
 *         Time Complexity: O(N). We visit every node once.
 * 
 *         Space Complexity: O(N), the size of our implicit call stack during
 *         our depth-first search.
 */
public class A8_Path_with_Maximum_Sum {

  private static int globalMaximumSum;

  public static int findMaximumPathSum(TreeNode root) {
    globalMaximumSum = Integer.MIN_VALUE;
    findMaximumPathSumRecursive(root);
    return globalMaximumSum;
  }

  // depth
  private static int findMaximumPathSumRecursive(TreeNode currentNode) {

    if (currentNode == null)
      return 0;

    int maxPathSumFromLeft = findMaximumPathSumRecursive(currentNode.left);
    int maxPathSumFromRight = findMaximumPathSumRecursive(currentNode.right);

    // ignore paths with negative sums, since we need to find the maximum sum we
    // should
    // ignore any path which has an overall negative sum.
    maxPathSumFromLeft = Math.max(maxPathSumFromLeft, 0);
    maxPathSumFromRight = Math.max(maxPathSumFromRight, 0);

    // maximum path sum at the current node will be equal to the sum from the left
    // subtree +
    // the sum from right subtree + val of current node
    int localMaximumSum = maxPathSumFromLeft + maxPathSumFromRight + currentNode.val;

    // update the global maximum sum
    globalMaximumSum = Math.max(globalMaximumSum, localMaximumSum);

    // maximum sum of any path from the current node will be equal to the maximum of
    // the sums from left or right subtrees plus the value of the current node
    return Math.max(maxPathSumFromLeft, maxPathSumFromRight) + currentNode.val;
  }

  public static void main(String[] args) {

    TreeNode root = new TreeNode(-1);
    root.left = new TreeNode(-3);
    System.out.println("Maximum Path Sum: " + A8_Path_with_Maximum_Sum.findMaximumPathSum(root));

  }

}
