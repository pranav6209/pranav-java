/**
 * 
 */
package com.pranav.educative.G_Breatdh_First_Search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.pranav.TreeNode;

/**
 * @author pranavpatel
 * 
 *         https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
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
public class A8_Connect_All_Level_Order_Siblings {
  public static Node traverse(Node root) {

    if (root == null)
      return null;

    Queue<Node> queue = new LinkedList<>();

    // inserts the specified element into this queue if it is possible to do so
    // immediately without violating capacity restrictions.
    // When using a capacity-restricted queue, this method is generally preferable
    // to add, which can fail to insert an element only
    // by throwing an exception.
    queue.offer(root);

    Node previousNode = null;
    while (!queue.isEmpty()) {

      int levelSize = queue.size();

      // we can avoid for loop here as we do not want to go by level
      for (int i = 0; i < levelSize; i++) {
        Node currentNode = queue.poll();
        if (previousNode != null) {
          previousNode.next = currentNode;
        }

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
    A8_Connect_All_Level_Order_Siblings.traverse(root);
    Node current = root;
    System.out.println("Traversal using 'next' pointer: ");
    while (current != null) {
      System.out.print(current.val + " ");
      current = current.next;
    }
  }
}
