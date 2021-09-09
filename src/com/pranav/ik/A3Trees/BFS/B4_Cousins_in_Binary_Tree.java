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
public class B4_Cousins_in_Binary_Tree {

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

  public boolean isCousins(TreeNode root, int x, int y) {

    if (root == null)
      return false;

    Queue<TreeNode> queue = new LinkedList<>();

    queue.offer(root);

    while (!queue.isEmpty()) {

      // we are checking parentx and parenty at each level. if any one of them is set at particular level we ll 
      // unwind the changes and check again
      
      TreeNode parentx = null;
      TreeNode parenty = null;
      
      int levelSize = queue.size();

      for (int i = 0; i < levelSize; i++) {

        TreeNode currentElement = queue.poll();

        if (currentElement.left != null) {

          queue.offer(currentElement.left);

          if (currentElement.left.val == x) {
            parentx = currentElement;
          }

          if (currentElement.left.val == y) {
            parenty = currentElement;
          }

        }

        if (currentElement.right != null) {

          queue.offer(currentElement.right);

          if (currentElement.right.val == x) {
            parentx = currentElement;
          }

          if (currentElement.right.val == y) {
            parenty = currentElement;
          }

        }

        // if at a particular level parentx and patenty are set and they are different return true
        if (parentx != null && parenty != null && parentx.val != parenty.val)
          return true;
      }

    }
    return false;
  }
}
