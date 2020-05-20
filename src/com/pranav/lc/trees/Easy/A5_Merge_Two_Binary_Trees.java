/**
 * 
 */
package com.pranav.lc.trees.Easy;

import com.pranav.lc.trees.TreeNode;
import com.pranav.lc.trees.TreePrinter;

/**
 * @author pranavpatel
 * 
 *         https://leetcode.com/problems/merge-two-binary-trees/
 * 
 *        // assuming s and t are no of nodes in s and t tree.
 *        
 *        when tree overlaps, both left and right makes a recursive call, else either left or right
 *       
 *        I think the time and space complexity of Algorithm 1 (Recursion) is O(m) where m stands for 
 *        "the number of overlapping nodes between the two trees", not "the minimum" number of nodes 
 *        between the two, as stated in the solution. Think of an example: tree 1 extends to the left for 10 times, 
 *        tree 2 extends to the right for 10 times. The algorithm only takes 2 recursion to complete the merge,
 *        which is the number of overlapping nodes between the two.
 *       
 *         time complexity : O(m) - the number of overlapping nodes between the two trees
 *         
 *         space complexity : O(m) - the number of overlapping nodes between the two trees
 *
 *         https://www.youtube.com/watch?v=Lt6V_2BeZWI&feature=youtu.be
 *
 */


// here we are updating t1 and not creating new DS
public class A5_Merge_Two_Binary_Trees {
  public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    
    if(t1==null && t2== null) return null;
    if(t1==null) return t2;
    if(t2==null) return t1;
    
    t1.val= t1.val+t2.val;
    
    t1.left =mergeTrees(t1.left, t2.left);
    t1.right =mergeTrees(t1.right, t2.right);
    return t1;
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
    System.out.println(mergeTrees(p, q));
  }

}
