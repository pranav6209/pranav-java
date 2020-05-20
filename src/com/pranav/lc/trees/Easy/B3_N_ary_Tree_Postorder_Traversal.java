/**
 * 
 */
package com.pranav.lc.trees.Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author pranavpatel
 *          https://leetcode.com/problems/n-ary-tree-postorder-traversal/
 *         https://leetcode.com/problems/n-ary-tree-postorder-traversal/discuss/174665/Java-Iterative-Solution-Using-Two-Stacks.
 *
 */

public class B3_N_ary_Tree_Postorder_Traversal {

  List<Integer> list = new ArrayList<>();

  // input [1,null,3,2,4,null,5,6]
  // run this code directly in leetcode with custom input.

  // time O(2^n)
  // space O(N)
  public List<Integer> postOrderRecursive(Node root) {
    // actually code will never go here if(root==null). when there is no children,
    // there is nothing to
    // iterate on for loop and it will simply return list;
    if (root == null)
      return list;

    for (Node node : root.children) {
      postOrderRecursive(node);
    }

    list.add(root.val);
    return list;

  }

  // input [1,null,3,2,4,null,5,6]
  // run this code directly in leetcode with custom input.

  // time O(n)
  // space O(N)
  public List<Integer> postOrderIterative(Node root) {

    
    if (root == null)
      return list;
    Stack<Node> stack1 = new Stack<>();
    Stack<Node> stack2 = new Stack<>();
    stack1.push(root);
    
    while (!stack1.isEmpty()) {
      Node top = stack1.pop();
      stack2.push(top);  
      for (int i = 0; i < top.children.size(); i++) {
        stack1.push(top.children.get(i));
      }
    }
        
    while (!stack2.isEmpty()){
       list.add(stack2.pop().val); 
    }

    return list;

  }
}
