/**
 * 
 */
package com.pranav.ik.A3Trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author pranavpatel
 *
 */
public class PP3_PostOrder_Traversal_Without_Recursion {

  private static class TreeNode {
    public int val;
    public TreeNode left_ptr;
    public TreeNode right_ptr;
  }

  // Complete the function below
  static List<Integer> postorder_traversal(TreeNode root) {

    List<Integer> res = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();

    stack.add(root);

    while (!stack.isEmpty()) {

      TreeNode node = stack.pop();

      res.add(node.val);

      if (node.left_ptr != null)
        stack.add(node.left_ptr);

      if (node.right_ptr != null)
        stack.add(node.right_ptr);

    }
    Collections.reverse(res);

    return res;

  }
}
