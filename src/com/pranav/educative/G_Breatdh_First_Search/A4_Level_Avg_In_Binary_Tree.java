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
 *         https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/submissions/
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
public class A4_Level_Avg_In_Binary_Tree {
  public static List<Double> findLevelAverages(TreeNode root) {

    List<Double> result = new ArrayList<>();

    if (root == null)
      return result;

    Queue<TreeNode> queue = new LinkedList<>();

    // inserts the specified element into this queue if it is possible to do so
    // immediately without violating capacity restrictions.
    // When using a capacity-restricted queue, this method is generally preferable
    // to add, which can fail to insert an element only
    // by throwing an exception.
    queue.offer(root);

    while (!queue.isEmpty()) {

      int levelSize = queue.size();
      double levelTotal=0;

      for (int i = 0; i < levelSize; i++) {

        // Retrieves and removes the head of this queue, or returns null if this queue
        // is empty.
        TreeNode currentNode = queue.poll();

        levelTotal += currentNode.val;
        
        if (currentNode.left != null)
          queue.offer(currentNode.left);
        if (currentNode.right != null)
          queue.offer(currentNode.right);
      }
      result.add(levelTotal/levelSize);
    }

    return result;

  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.left.right = new TreeNode(2);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    List<Double> result = A4_Level_Avg_In_Binary_Tree.findLevelAverages(root);
    System.out.print("Level averages are: " + result);
  }
}
