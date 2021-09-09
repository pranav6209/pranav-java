/**
 * 
 */
package com.pranav.ik.A3Trees.BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author pranavpatel
 *
 */

public class C3_Find_Bottom_Left_Tree_Value {
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

  // similar to right side view. here we treat like a left side view and instead of
  // res array, we keep updating res value.Last value, we return
  public int findBottomLeftValue(TreeNode root) {

    int res = 0;

    Queue<TreeNode> queue = new LinkedList<>();

    queue.offer(root);

    while (!queue.isEmpty()) {

      int levelSize = queue.size();

      for (int i = 0; i < levelSize; i++) {

        TreeNode currentNode = queue.poll();

        // append first element of the each level to res, last level first value to return
        if (i == 0) {
          res = currentNode.val;
        }

        if (currentNode.left != null) {
          queue.offer(currentNode.left);
        }

        if (currentNode.right != null) {
          queue.offer(currentNode.right);
        }

      }

    }

    return res;

  }

}
