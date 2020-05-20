/**
 * 
 */
package com.pranav.lc.trees.Easy;

import com.pranav.lc.trees.TreeNode;
import com.pranav.lc.trees.TreePrinter;

/**
 * @author pranavpatel
 * 
 * https://leetcode.com/problems/symmetric-tree/description/
 * 
 * 
 * assumin p and q are no of nodes in p and q tree.
 * time complexity : O(p+q) - as visiting each node once in both tree
 *         
 * space complexity : O(max(p,q)) - max recursion stack is max of tree node  present in either tree
 * 
 * 
 * as per leetcode 
 * 
 * 0(N) and space O(logn) in best and O(N) in worst 
 * 
 * 
 * more approaches 
 * https://leetcode.com/problems/same-tree/discuss/32687/Five-line-Java-solution-with-recursion
 *
 */
public class A2_Same_Tree {
  //the first 2 lines can be combined into 1 line: if (p == NULL || q == NULL) return (p == q);
  public static boolean isSameTree(TreeNode p, TreeNode q) {
    
    if(p==null && q == null) return true;
    if(p==null || q == null) return false;
    if(p.val!=q.val) return false;
    
    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    
  }

  public static void main(String[] args) {
    TreeNode p = new TreeNode(4);
    p.left = new TreeNode(2);
    p.right = new TreeNode(3);
    TreeNode q = new TreeNode(4);
    q.left = new TreeNode(2);
    q.right = new TreeNode(1);
    
    TreePrinter.printNode(p);
    TreePrinter.printNode(q);
    System.out.println(isSameTree(p, q));
  }

}
