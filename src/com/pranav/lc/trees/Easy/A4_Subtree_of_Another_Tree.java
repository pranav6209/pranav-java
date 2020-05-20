/**
 * 
 */
package com.pranav.lc.trees.Easy;

import com.pranav.lc.trees.TreeNode;
import com.pranav.lc.trees.TreePrinter;

/**
 * @author pranavpatel
 * 
 *         https://leetcode.com/problems/same-tree/description/
 * 
 *        // assuming s and t are no of nodes in s and t tree.
 *        
 *         time complexity : O(s+t) - as visiting each node once in both tree
 *         
 *         space complexity : O(max(s,t)) - max recursion stack is max of tree node  present in either tree
 * 
 *         more approaches
 *         https://leetcode.com/problems/subtree-of-another-tree/discuss/102724/Java-Solution-tree-traversal
 *
 */

/*
 * 1.Start with a node of tree s (lets call this s-node)
   2.Compare the trees forming with root s-node and root t
   3.If the trees match then return true
   4.Else go to step one and check for s->left || s->right
 * 
 * 
 */


public class A4_Subtree_of_Another_Tree {
  public static boolean isSubtree(TreeNode s, TreeNode t) {

    if(s==null) return false;
    // below 2 lines can also be written as 
    
    //return isSameTree(s,t) ||isSubtree(s.left, t) || isSubtree(s.right, t);
    if(isSameTree(s, t)) return true;
    return isSubtree(s.left, t) || isSubtree(s.right, t);
    
  }
  
  public static boolean isSameTree(TreeNode p, TreeNode q) {

    if (p == null && q == null)
      return true;
    if (p == null || q == null)
      return false;
    if (p.val != q.val)
      return false;

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
    System.out.println(isSubtree(p, q));
  }

}
