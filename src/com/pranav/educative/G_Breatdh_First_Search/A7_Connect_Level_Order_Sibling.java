/**
 * 
 */
package com.pranav.educative.G_Breatdh_First_Search;

import java.util.LinkedList;
import java.util.Queue;

class Node {
  public int val;
  public Node left;
  public Node right;
  public Node next;

  public Node() {
  }

  public Node(int _val) {
    val = _val;
  }

  public Node(int _val, Node _left, Node _right, Node _next) {
    val = _val;
    left = _left;
    right = _right;
    next = _next;
  }

  void printLevelOrder() {
    Node nextLevelRoot = this;
    while (nextLevelRoot != null) {
      Node current = nextLevelRoot;
      nextLevelRoot = null;
      while (current != null) {
        System.out.print(current.val + " ");
        if (nextLevelRoot == null) {
          if (current.left != null)
            nextLevelRoot = current.left;
          else if (current.right != null)
            nextLevelRoot = current.right;
        }
        current = current.next;
      }
      System.out.println();
    }
  }
};

/**
 * @author pranavpatel
 * 
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/submissions/
 * 
 * 
 *         time : O(N) where N is number of nodes in tree as we are traveling
 *         each node once.
 * 
 *         space : The space complexity of the above algorithm will be O(N) O(N)
 *         as we need to return a list containing the level order traversal. We
 *         will also need O(N) space for the queue. Since we can have a maximum
 *         of N/2 nodes at any level (this could happen only at the lowest
 *         level), therefore we will need O(N) space to store them in the queue.
 * 
 *
 */
public class A7_Connect_Level_Order_Sibling {
  public static Node connect(Node root) {

    if (root == null)
      return null;

    Queue<Node> queue = new LinkedList<>();
    // inserts the specified element into this queue if it is possible to do so
    // immediately without violating capacity restrictions.
    // When using a capacity-restricted queue, this method is generally preferable
    // to add, which can fail to insert an element only
    // by throwing an exception.
    queue.offer(root);

    while (!queue.isEmpty()) {

      Node previousNode = null;
      int levelSize = queue.size();

      for (int i = 0; i < levelSize; i++) {

        // Retrieves and removes the head of this queue, or returns null if this queue
        // is empty.
        Node currentNode = queue.poll();

        if (previousNode != null)
          previousNode.next = currentNode;
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
    Node root = new Node(12);
    root.left = new Node(7);
    root.right = new Node(1);
    root.left.left = new Node(9);
    root.right.left = new Node(10);
    root.right.right = new Node(5);
    A7_Connect_Level_Order_Sibling.connect(root);
    System.out.println("Level order traversal using 'next' pointer: ");
    root.printLevelOrder();
  }
}
