/**
 * 
 */
package com.pranav.lc.trees.Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author pranavpatel
 * https://leetcode.com/problems/n-ary-tree-preorder-traversal/
 * https://leetcode.com/problems/n-ary-tree-preorder-traversal/discuss/147955/Java-Iterative-and-Recursive-Solutions
 *
 */

class Node {
  public int val;
  public List<Node> children;

  public Node() {
  }

  public Node(int _val) {
    val = _val;
  }

  public Node(int _val, List<Node> _children) {
    val = _val;
    children = _children;
  }
};
public class B2_N_ary_Tree_Preorder_Traversal {

  List<Integer> list = new ArrayList<>();

  // input [1,null,3,2,4,null,5,6]
  // run this code directly in leetcode with custom input.
  
  // time O(2^n)
  // space O(N)
  public List<Integer> preorderRecursive(Node root) {
    // actually code will never go here if(root==null). when there is no children,
    // there is nothing to
    // iterate on for loop and it will simply return list;
    if (root == null)
      return list;
    list.add(root.val);

    for (Node node : root.children) {
      preorderRecursive(node);
    }
    return list;

  }

  // input [1,null,3,2,4,null,5,6]
  // run this code directly in leetcode with custom input.
  
  // time O(n)
  // space O(N)
  public List<Integer> preorderIterative(Node root) {

    if (root == null)
      return list;
    Stack<Node> stack = new Stack<>();
    stack.add(root);
    while (!stack.isEmpty()) {
      root = stack.pop();
      list.add(root.val);
      // adding a children of root in reverse as, we need the first children on left
      // at the top of stack children of above is 3,2,4 3 should be at top of stack 
      for (int i = root.children.size() - 1; i >= 0; i--) {
        stack.add(root.children.get(i));

      }

    }

    return list;

  }
}
