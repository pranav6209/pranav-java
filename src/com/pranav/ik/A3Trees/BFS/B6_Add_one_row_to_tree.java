/**
 * 
 */
package com.pranav.ik.A3Trees.BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author pranavpatel
 */

public class B6_Add_one_row_to_tree {

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

  public TreeNode addOneRow(TreeNode root, int val, int depth) {

    if (depth == 1) {
      TreeNode newNode = new TreeNode(val);
      newNode.left = root;
      root = newNode;

    }

    if (root == null)
      return null;

    int treeDepth = 0;
    Queue<TreeNode> queue = new LinkedList<>();

    queue.offer(root);

    while (!queue.isEmpty()) {

      treeDepth++;

      int levelSize = queue.size();

      for (int i = 0; i < levelSize; i++) {

        TreeNode currentNode = queue.poll();
        // if depth 2 is given, ultimately we want to add new row at level 1
        // optimization will be once the level is added, we can stop no need to add more
        // node to queue
        if (treeDepth == depth - 1) {

          TreeNode newLeft = new TreeNode(val);
          TreeNode newRight = new TreeNode(val);

          newLeft.left = currentNode.left;
          newRight.right = currentNode.right;

          currentNode.left = newLeft;
          currentNode.right = newRight;
        }
        if (currentNode.left != null)
          queue.offer(currentNode.left);

        if (currentNode.right != null)
          queue.offer(currentNode.right);

      }
    }
    return root;
  }

}
