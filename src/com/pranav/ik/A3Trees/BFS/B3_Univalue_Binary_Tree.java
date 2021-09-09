/**
 * 
 */
package com.pranav.ik.A3Trees.BFS;

import java.util.LinkedList;
import java.util.Queue;

import com.pranav.ik.A3Trees.BFS.B2_Maximum_Level_Sum_Of_Binary_Tree.TreeNode;

/**
 * @author pranavpatel
 *
 */

// Get the node val and compare it with all the node. as soon find difference return false end of the loop return true

public class B3_Univalue_Binary_Tree {

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

  public boolean isUnivalTree(TreeNode root) {

    if (root == null)
      return true;

    Queue<TreeNode> queue = new LinkedList<>();

    queue.offer(root);
    int uniValue = root.val;
    while (!queue.isEmpty()) {
      TreeNode curretNode = queue.poll();
      if (curretNode.val != uniValue)
        return false;
      if (curretNode.left != null)
        queue.offer(curretNode.left);

      if (curretNode.right != null)
        queue.offer(curretNode.right);
    }
    return true;
  }
}
