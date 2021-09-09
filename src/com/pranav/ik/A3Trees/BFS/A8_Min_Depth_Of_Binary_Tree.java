/**
 * 
 */
package com.pranav.ik.A3Trees.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author pranavpatel
 *
 *         same time/space complexity as A1
 *
 */
public class A8_Min_Depth_Of_Binary_Tree {

  private static class TreeNode {
    public int label;
    public TreeNode left_ptr;
    public TreeNode right_ptr;
  }

  // return the closest child from root
  public int minDepth(TreeNode root) {

    // initiate it 0 so root == null return it
    int height = 0;

    if (root == null)
      return height;

    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      // as soon as we encounter node we have to increase the counter
      height++;
      int levelSize = queue.size();

      for (int i = 0; i < levelSize; i++) {

        TreeNode currentNode = queue.poll();

        if (currentNode.left_ptr == null & currentNode.right_ptr == null)
          return height;

        if (currentNode.left_ptr != null)
          queue.offer(currentNode.left_ptr);

        if (currentNode.right_ptr != null)
          queue.offer(currentNode.right_ptr);

      }
    }
    return height;
  }

}
