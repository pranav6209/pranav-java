/**
 * 
 */
package com.pranav.ik.A3Trees.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author pranavpatel
 * 
 *         https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 *         time and space same as A1
 *
 */

class TreeNode {
  public int label;
  public TreeNode left_ptr;
  public TreeNode right_ptr;
}

public class A4_Zigzag_Level_Order_Traversal_Binary_Tree {

  public static List<List<Integer>> zigzag_level_order_traversal(TreeNode root) {

    List<List<Integer>> res = new ArrayList<>();
    if (root == null)
      return res;

    Queue<TreeNode> queue = new LinkedList<>();

    queue.offer(root);

    boolean flip = false;

    while (!queue.isEmpty()) {

      int levelSize = queue.size();
      LinkedList<Integer> currentList = new LinkedList<>();

      for (int i = 0; i < levelSize; i++) {

        TreeNode currentNode = queue.poll();

        if (!flip)
          currentList.addLast(currentNode.label);
        else
          currentList.addFirst(currentNode.label);

        if (currentNode.left_ptr != null)
          queue.offer(currentNode.left_ptr);
        if (currentNode.right_ptr != null)
          queue.offer(currentNode.right_ptr);

      }
      res.add(currentList);
      // flip the flag before going it to next level
      flip = !flip;
    }

    return res;

  }

}
