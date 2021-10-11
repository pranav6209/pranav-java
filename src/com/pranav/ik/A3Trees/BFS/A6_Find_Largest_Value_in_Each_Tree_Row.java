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
 */

public class A6_Find_Largest_Value_in_Each_Tree_Row {

  public List<Integer> largestValues(TreeNode root) {

    List<Integer> res = new ArrayList<>();

    if (root == null)
      return res;

    Queue<TreeNode> queue = new LinkedList<>();

    queue.offer(root);

    while (!queue.isEmpty()) {

      int levelSize = queue.size();
      int max = Integer.MIN_VALUE;// here node.val could be negative so initiate with Integer.MIN_VALUE

      for (int i = 0; i < levelSize; i++) {

        TreeNode currentNode = queue.poll();
        max = Math.max(max, currentNode.label);

        if (currentNode.left_ptr != null) {
          queue.offer(currentNode.left_ptr);
        }

        if (currentNode.right_ptr != null) {
          queue.offer(currentNode.right_ptr);
        }

      }

      res.add(max);

    }
    return res;
  }
}
