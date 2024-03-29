/**
 * 
 */
package com.pranav.ik.A3Trees.BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author pranavpatel
 * 
 *https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *         look at the class note
 * 
 * 
 */

public class B7_Max_Width_Of_Binary_Tree {

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
    TreeNode node;
    int index;

    public QueueNode(TreeNode node, int index) {
      this.node = node;
      this.index = index;
    }
  }
  /*

  read the problem statement to understand how width is being calculated.

  1. Store the index of children when adding them to the queue. 
  2. Store the firstNode and currentNode of each level separately outside the "for" loop to keep track of width
     At the end their index difference is that level's width.consider we are finding a width of an array


  */
  public int widthOfBinaryTree(TreeNode root) {
    if (root == null)
      return 0;

    int maxWidth = Integer.MIN_VALUE;
    Queue<QueueNode> queue = new LinkedList<>();

    // root at index 1
    queue.offer(new QueueNode(root, 1));
    
    while (!queue.isEmpty()) {
      int levelSize = queue.size();

      // get the first node of the queue
      QueueNode first = queue.peek();

      // this will be the last node when we traverse that level
      QueueNode currentNode = null;
      
      int currentLevelWidth = 0;

      for (int i = 0; i < levelSize; i++) {

        currentNode = queue.poll();

        if (currentNode.node.left != null) {
          queue.offer(new QueueNode(currentNode.node.left, 2 * currentNode.index));
        }

        if (currentNode.node.right != null) {
          queue.offer(new QueueNode(currentNode.node.right, 2 * currentNode.index + 1));
        }
      }
      currentLevelWidth = currentNode.index - first.index + 1;
      maxWidth = Math.max(maxWidth, currentLevelWidth);
    }

    return maxWidth;
  }

}
