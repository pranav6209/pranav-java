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
 * 
 *         time and space same as A1
 *
 */

public class A5_Average_Of_Level_In_Binary_Tree {

  public static List<Double> zigzag_level_order_traversal(TreeNode root) {

    List<Double> res = new ArrayList<>();
    if (root == null)
      return res;

    Queue<TreeNode> queue = new LinkedList<>();

    queue.offer(root);

    while (!queue.isEmpty()) {

      int levelSize = queue.size();
      double sum = 0;
      for (int i = 0; i < levelSize; i++) {

        TreeNode currentNode = queue.poll();
        sum = sum + currentNode.label;
        if (currentNode.left_ptr != null)
          queue.offer(currentNode.left_ptr);
        if (currentNode.right_ptr != null)
          queue.offer(currentNode.right_ptr);

      }

      res.add(sum / levelSize);

    }

    return res;

  }

}
