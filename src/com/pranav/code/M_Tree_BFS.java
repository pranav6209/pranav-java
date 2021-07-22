/**
 * 
 */
package com.pranav.code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author pranavpatel
 *
 */
public class M_Tree_BFS {
  class TreeNode {
    public int label;
    public TreeNode left_ptr;
    public TreeNode right_ptr;
  }

  public static List<Integer> level_order_traversal(TreeNode root) {

    List<Integer> res = new ArrayList<>();

    // no need to check this as in the constrain it says 1 <= number of nodes in the
    // binary tree <= 20000
    if (root == null)
      return res;

    Queue<TreeNode> queue = new LinkedList<>();

    queue.offer(root);

    while (!queue.isEmpty()) {

      TreeNode currentNode = queue.poll();
      res.add(currentNode.label);
      if (currentNode.left_ptr != null)
        queue.offer(currentNode.left_ptr);
      if (currentNode.right_ptr != null)
        queue.offer(currentNode.right_ptr);

    }

    return res;

  }
}
