/**
 * 
 */
package com.pranav.ik.A3Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Vector;

/**
 * @author pranavpatel
 * 
 * https://leetcode.com/problems/n-ary-tree-level-order-traversal/
 * 
 * Time : O(N) number of nodes in the tree as we are visiting each node once.(Think of what work is doing at each node rather while loop with for loop)
 * space : O(N) max number nodes are at the leaf and at most there can be N-1 nodes can be found in queue at max at one time so O(N-1)  
 *
 */
public class A2_Nary_Tree_Level_Order_Traversal {

  static class TreeNode {
    int label;
    Vector<TreeNode> children = new Vector<TreeNode>(0);

    TreeNode(int _label) {
      label = _label;
      children.clear();
    }
  };

  public static List<List<Integer>> level_order(TreeNode root) {

    List<List<Integer>> res = new ArrayList<>();
    if (root == null)
      return res;
    Queue<TreeNode> queue = new LinkedList<>();

    queue.offer(root);

    while (!queue.isEmpty()) {

      int levelSize = queue.size();
      List<Integer> currentList = new ArrayList<>();

      for (int i = 0; i < levelSize; i++) {

        TreeNode currentNode = queue.poll();
        currentList.add(currentNode.label);

        // get all the children if the current node and add it to queue
        for (TreeNode child : currentNode.children) {

          // if(child!=null)
          queue.offer(child);
        }

      }
      res.add(currentList);
    }
    return res;
  }

}
