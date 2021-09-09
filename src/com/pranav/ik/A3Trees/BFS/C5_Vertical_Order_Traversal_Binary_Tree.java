/**
 * 
 */
package com.pranav.ik.A3Trees.BFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author pranavpatel
 *
 */
public class C5_Vertical_Order_Traversal_Binary_Tree {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }

  }

  static class QueueNode {
    TreeNode root;
    int level;

    public QueueNode(TreeNode root, int level) {
      this.root = root;
      this.level = level;// x coordinate
    }
  }

  public List<List<Integer>> verticalTraversal(TreeNode root) {
    final List<List<Integer>> result = new ArrayList<>();

    if (root == null) {
      return result;
    }

    int minRow = Integer.MAX_VALUE;
    int maxRow = Integer.MIN_VALUE;

    final Queue<QueueNode> queue = new LinkedList<>();
    final Map<Integer, List<Integer>> map = new HashMap<>();

    queue.offer(new QueueNode(root, 0));

    while (!queue.isEmpty()) {

      QueueNode node = queue.poll();
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        
        if (!map.containsKey(node.level)) {
          map.put(node.level, new ArrayList<>());
        }  
        
        map.get(node.level).add(node.root.val);

        minRow = Math.min(minRow, node.level);
        maxRow = Math.max(maxRow, node.level);

        if (node.root.left != null) {
          queue.offer(new QueueNode(node.root.left, node.level - 1));
        }
        if (node.root.right != null) {
          queue.offer(new QueueNode(node.root.right, node.level + 1));
        }
      }
    }

    for (int i = minRow; i <= maxRow; i++) {
      // we can do result.add(map.get(i)) but best practice is to copy
      System.out.println(map.get(i));
      Collections.sort(map.get(i));
      System.out.println(map.get(i));
      result.add(map.get(i));
    }

    return result;
  }
}
