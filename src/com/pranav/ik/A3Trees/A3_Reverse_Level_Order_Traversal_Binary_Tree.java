/**
 * 
 */
package com.pranav.ik.A3Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author pranavpatel
 * 
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 * 
 * same time/space complexity as A1
 *
 */
public class A3_Reverse_Level_Order_Traversal_Binary_Tree {

  private static class TreeNode {
    public int label;
    public TreeNode left_ptr;
    public TreeNode right_ptr;
  }

  public static List<List<Integer>> reverse_level_order_traversal(TreeNode root) {

    LinkedList<List<Integer>> res = new LinkedList<>();
    if (root == null)
      return res;

    Queue<TreeNode> queue = new LinkedList<>();

    queue.offer(root);

    while (!queue.isEmpty()) {

      int levelSize = queue.size();
      List<Integer> currentList = new ArrayList<>();

      for (int i = 0; i < levelSize; i++) {

        TreeNode currentNode = queue.poll();
        currentList.add(currentNode.label);

        if (currentNode.left_ptr != null)
          queue.offer(currentNode.left_ptr);
        if (currentNode.right_ptr != null)
          queue.offer(currentNode.right_ptr);

      }

      res.addFirst(currentList);

    }

    return res;

  }
}
