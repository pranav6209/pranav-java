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

public class B8_Check_Completeness_Of_Binary_Tree {

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

  class QueueNode {
    TreeNode treeNode;
    int index;

    QueueNode(TreeNode treeNode, int index) {
      this.treeNode = treeNode;
      this.index = index;
    }
  }

  /*
   1. similar idea like a previous problem where we store each node with index
   2. if tree is complete, index for each node that we are polling from queue should increase sequentially. 
      failure in that means not a complete binary tree  
      
      if (expectedId == currentNode.index)
          expectedId += 1;
   */
  public boolean isCompleteTree(TreeNode root) {

    if (root == null)
      return true;

    Queue<QueueNode> queue = new LinkedList<>();

    queue.offer(new QueueNode(root, 1));

    int expectedId = 1;

    while (!queue.isEmpty()) {

      int levelSize = queue.size();

      for (int i = 0; i < levelSize; i++) {

        QueueNode currentNode = queue.poll();

        if (expectedId == currentNode.index)
          expectedId += 1;
        else
          return false;

        if (currentNode.treeNode.left != null)
          queue.offer(new QueueNode(currentNode.treeNode.left, 2 * currentNode.index));

        if (currentNode.treeNode.right != null)
          queue.offer(new QueueNode(currentNode.treeNode.right, 2 * currentNode.index + 1));

      }

    }
    return true;

  }
}
