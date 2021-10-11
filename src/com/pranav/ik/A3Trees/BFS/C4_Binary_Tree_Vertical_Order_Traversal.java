/**
 * 
 */
package com.pranav.ik.A3Trees.BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author pranavpatel
 * 
 *
 */
public class C4_Binary_Tree_Vertical_Order_Traversal {
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
    int vertlevel;

    public QueueNode(TreeNode root, int vertlevel) {
      this.root = root;
      this.vertlevel = vertlevel;
    }
  }

  
  /*
   * 1. queue stores node and its level which is x cordinate of the node
   * 2. we are traversing level order so we do not have to keep track of y coordinate 
   * 3. every time we traverse, if we go left if decrement x coordiate and going right increment x coordinate 
   * 4. keeping track of each vertlevel in a hashMap, if we vertlevel accessed before add current node to it else
   * create a new list and add it to that level
   * 
   * if not given ask what if there is a collision at particular level, see leetcode example 2
   * 
   * 
   * 
   */
  public List<List<Integer>> verticalOrder(TreeNode root) {
    final List<List<Integer>> result = new ArrayList<>();

    if (root == null) {
      return result;
    }
    // track the min and max x coordinate so we can iterate over it later to
    // generate res
    int minX = Integer.MAX_VALUE;
    int maxX = Integer.MIN_VALUE;

    // queue which holds treeNode and its x coordinate
    final Queue<QueueNode> queue = new LinkedList<>();

    // map holds x coordinate as a key and all the values at that coordinate as an
    // arrayList
    final Map<Integer, List<Integer>> map = new HashMap<>();

    queue.offer(new QueueNode(root, 0));

    while (!queue.isEmpty()) {

      QueueNode node = queue.poll();

      // if x coordinate we found it is not in map, add it to map
      if (!map.containsKey(node.vertlevel)) {
        List<Integer> temp = new ArrayList<>();
        temp.add(node.root.val);
        map.put(node.vertlevel, temp);
      } else { // if found add it to existing list
        map.get(node.vertlevel).add(node.root.val);
      }
      
      // update min and max
      minX = Math.min(minX, node.vertlevel);
      maxX = Math.max(maxX, node.vertlevel);

      if (node.root.left != null) {
        queue.offer(new QueueNode(node.root.left, node.vertlevel - 1));
      }
      if (node.root.right != null) {
        queue.offer(new QueueNode(node.root.right, node.vertlevel + 1));
      }

    }

    // iterate over a map and collect all the values
    for (int i = minX; i <= maxX; i++) {
      // we can do result.add(map.get(i)) but best practice is to copy
      result.add(new ArrayList<>(map.get(i)));
    }

    return result;
  }
}
