/**
 * 
 */
package com.pranav.ik.A3Trees.BFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author pranavpatel
 *
 *         same time/space complexity as A1
 *
 */
public class B2_Maximum_Level_Sum_Of_Binary_Tree {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  /*
   * 1. At each level keep track of the sum
   * 2.sum at that level greater than the max
   * sum, update the max sum and update the level where found
   */
  public int maxLevelSum(TreeNode root) {

    int level = 0;// this will keep track of height of 
    int maxLevelSum = Integer.MIN_VALUE;
    int minLevel = 0;

    if (root == null)
      return level;

    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      // as soon as we encounter node we have to increase the counter

      level++;
      int levelSum = 0;
      int levelSize = queue.size();

      for (int i = 0; i < levelSize; i++) {

        TreeNode currentNode = queue.poll();
        levelSum = levelSum + currentNode.val;

        if (currentNode.left != null) {
          queue.offer(currentNode.left);
        }

        if (currentNode.right != null) {
          queue.offer(currentNode.right);
        }

      }
      
      
      // if we have asked to return largest level, 
      // levelSum >= maxLevelSum
      if (levelSum > maxLevelSum) {
        maxLevelSum = levelSum;
        minLevel = level;
      }

    }
    return minLevel;
  }

}
