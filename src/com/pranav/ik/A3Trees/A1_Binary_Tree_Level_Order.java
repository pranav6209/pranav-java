/**
 * 
 */
package com.pranav.ik.A3Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.pranav.lc.trees.TreeNode;

/**
 * @author pranavpatel
 * 
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * 
 * Time : O(N) number of nodes in the tree as we are visiting each node once.(Think of what work is doing at each node rather while loop with for loop)
 * space : O(N) max number nodes are at the leaf and at most there can be N/2 nodes can be found in queue at max at one time so O(N/2)  
 *
 *
 */


// BFS approach
public class A1_Binary_Tree_Level_Order {

  class TreeNode {
    public int label;
    public TreeNode left_ptr;
    public TreeNode right_ptr;
  }

  public static List<List<Integer>> level_order_traversal(TreeNode root) {

    List<List<Integer>> res = new ArrayList<>();
    if (root == null)
      return res;

    Queue<TreeNode> queue = new LinkedList<>();

    queue.offer(root);

    while (!queue.isEmpty()) {
      // Explanation 29:00 OD video
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

      res.add(currentList);

    }

    return res;

  }
}
