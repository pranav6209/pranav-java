/**
 * 
 */
package com.pranav.ik.A3Trees.BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author pranavpatel
 * 
 *         https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *         https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 * 
 *         This is common solution for both the problem. Leetcode test case
 *         passes. Only difference is one if full binary tree and other is not.
 *         We do not have a special case for full binary so, solution will work
 *         for both problems
 *
 *
 *         look at the class note
 * 
 * 
 */

class Node {
  public int val;
  public Node left;
  public Node right;
  public Node next;

  public Node() {
  }

  public Node(int _val) {
    val = _val;
    return;
  }

  public Node(int _val, Node _left, Node _right, Node _next) {
    val = _val;
    left = _left;
    right = _right;
    next = _next;
  }
};

public class B5_Populating_Next_Right_Pointers_in_Each_Node {

  // Definition for a Node.

  public static Node connect(Node root) {

    if (root == null)
      return null;

    Queue<Node> queue = new LinkedList<>();

    queue.offer(root);

    while (!queue.isEmpty()) {

      Node previousNode = null;
      int levelSize = queue.size();

      /*
       * initially all the next pointers are set to null (given) so after each level,
       * we do not have to set next to null we just have to worry about connecting
       * each level node, and do not worry about merging each level
       * 
       */
      for (int i = 0; i < levelSize; i++) {

        Node currentNode = queue.poll();

        // at each level previousNode starts null so previousNode = currentNode and then
        // once it is set, previousNode.next = currentNode;
        if (previousNode != null) {
          previousNode.next = currentNode;

        }
        // move previous pointer
        previousNode = currentNode;

        if (currentNode.left != null)
          queue.offer(currentNode.left);

        if (currentNode.right != null)
          queue.offer(currentNode.right);
      }
    }
    return root;
  }

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
    connect(root);
  }
}
