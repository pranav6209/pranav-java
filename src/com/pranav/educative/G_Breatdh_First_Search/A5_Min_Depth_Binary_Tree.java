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
 *        https://leetcode.com/problems/minimum-depth-of-binary-tree/submissions/
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
public class A5_Min_Depth_Binary_Tree {
  public static int findDepth(TreeNode root) {

    if (root == null)
      return 0;

    Queue<TreeNode> queue = new LinkedList<>();

    int minDepthTree = 1;
    // inserts the specified element into this queue if it is possible to do so
    // immediately without violating capacity restrictions.
    // When using a capacity-restricted queue, this method is generally preferable
    // to add, which can fail to insert an element only
    // by throwing an exception.
    queue.offer(root);

    while (!queue.isEmpty()) {

      int levelSize = queue.size();

      for (int i = 0; i < levelSize; i++) {

        // Retrieves and removes the head of this queue, or returns null if this queue
        // is empty.
        TreeNode currentNode = queue.poll();

        if (currentNode.right == null && currentNode.left == null) {
          return minDepthTree;
        }
        if (currentNode.left != null)
          queue.offer(currentNode.left);
        if (currentNode.right != null)
          queue.offer(currentNode.right);
      }

      minDepthTree++;
    }

    return minDepthTree;

  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    System.out.println("Tree Minimum Depth: " + A5_Min_Depth_Binary_Tree.findDepth(root));
    root.left.left = new TreeNode(9);
    root.right.left.left = new TreeNode(11);
    System.out.println("Tree Minimum Depth: " + A5_Min_Depth_Binary_Tree.findDepth(root));
  }
}
