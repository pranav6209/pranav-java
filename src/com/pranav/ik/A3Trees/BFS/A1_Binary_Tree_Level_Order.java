/**
 * 
 */
package com.pranav.ik.A3Trees.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.pranav.lc.trees.TreeNode;

/**
 * 
 * 
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * 
 * Time : O(node_count) number of nodes in the tree as we are visiting each node
 * once.(Think of what work is doing at each node rather while loop with for
 * loop)
 * 
 * space : O(node_count) max number nodes are at the leaf and at most there can be N/2
 * nodes can be found in queue at max at one time so O(N/2)
 * 
 * For storing the levels of each node: O(node_count).
 
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
      // 1. take a snapshot at the beginning of each level and iterate over it
      // 2. create tempList to add current level element
      int levelSize = queue.size();
      List<Integer> currentList = new ArrayList<>();

      /*
       * when we are in the for loop 
       * 1. for loop executes one time per level 
       * 2. we are pushing element for the next level by adding child of current level node
       * 3. Level Order Traversal = Traversal of the node in increasing order of distance from the root
       */
      for (int i = 0; i < levelSize; i++) {
        // 1. poll first element from the queue
        // 2. add it to tempList
        // 3. add its children to queue
        
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
