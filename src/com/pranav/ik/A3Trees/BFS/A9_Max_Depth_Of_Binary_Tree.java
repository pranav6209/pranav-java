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
public class A9_Max_Depth_Of_Binary_Tree {

  private static class TreeNode {
    public int label;
    public TreeNode left_ptr;
    public TreeNode right_ptr;
  }

  // return the farthest child from root. Just iterate through each level
  public int minDepth(TreeNode root) {

    int depth = 0;

    if (root == null)
      return depth;

    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offer(root);

    while (!queue.isEmpty()) {

      depth++;
      int levelSize = queue.size();

      for (int i = 0; i < levelSize; i++) {

        TreeNode currentNode = queue.poll();

        if (currentNode.left_ptr != null) {
          queue.offer(currentNode.left_ptr);
        }
        if (currentNode.right_ptr != null) {
          queue.offer(currentNode.right_ptr);
        }
      }
    }
    return depth;
  }

}
