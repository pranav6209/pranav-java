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
 *         https://leetcode.com/problems/binary-tree-right-side-view/
 * 
 *         same time/space complexity as A1
 *
 */
public class A7_Right_Side_View_Of_Binary_Tree {

  private static class TreeNode {
    public int label;
    public TreeNode left_ptr;
    public TreeNode right_ptr;
  }

  static ArrayList<Integer> right_view(TreeNode root) {

    ArrayList<Integer> res = new ArrayList<Integer>();
    
    if (root == null)
      return res;
    
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offer(root);

    while (!queue.isEmpty()) {

      int levelSize = queue.size();
      TreeNode node = null;  //-- approach -2

      for (int i = 0; i < levelSize; i++) {
        TreeNode currentNode = queue.poll();
       
        /*

         approach -1 instead of appending everything just append last
         approach -2 we can also initialize treenode = null at each level and keep appending i          it. Once we complete a level, last element will be right

        /* approach -1
        if (i == levelSize - 1) {
          res.add(currentNode.val);
        }
        */


        if (currentNode.left_ptr != null) {
          queue.offer(currentNode.left_ptr);
        }
        if (currentNode.right_ptr != null) {
          queue.offer(currentNode.right_ptr);
        }
      }
      res.add(node.val);
    }
    return res;
  }

}
