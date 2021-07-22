/**
 * 
 */
package com.pranav.ik.A3Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author pranavpatel
 * 
 * https://leetcode.com/problems/binary-tree-right-side-view/
 * 
 * same time/space complexity as A1
 *
 */
public class A5_Right_Side_View_Of_Binary_Tree {

  private static class TreeNode {
    public int label;
    public TreeNode left_ptr;
    public TreeNode right_ptr;
  }

  static ArrayList<Integer> right_view(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offer(root);
    ArrayList<Integer> ret = new ArrayList<Integer>();

    while (!queue.isEmpty()) {
      
      int levelSize = queue.size();

      for (int i = 0; i < levelSize; i++) {
        TreeNode node = queue.poll();
        // instead of appending everything just append last
        if (i == levelSize - 1) {
          ret.add(node.label);
        }
        if (node.left_ptr != null) {
          queue.offer(node.left_ptr);
        }
        if (node.right_ptr != null) {
          queue.offer(node.right_ptr);
        }
      }
    }
    return ret;
  }

}
