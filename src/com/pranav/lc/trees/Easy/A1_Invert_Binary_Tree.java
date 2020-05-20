/**
 * 
 */
package com.pranav.lc.trees.Easy;

import com.pranav.lc.trees.TreeNode;
import com.pranav.lc.trees.TreePrinter;

/**
 * @author pranavpatel
 * 
 * https://leetcode.com/problems/invert-binary-tree/  
 * 
 * time complexity : O(N) - as visiting each node once
 * space complexity : O(h) - height if binary tree  basically O(N)
 * 
 * more approaches 
 * https://leetcode.com/problems/invert-binary-tree/discuss/62707/Straightforward-DFS-recursive-iterative-BFS-solutions
 *
 */
public class A1_Invert_Binary_Tree {

  public static TreeNode invertTree(TreeNode root) {

    if (root == null)
      return null; // base case

    TreeNode left = invertTree(root.left);
    TreeNode right = invertTree(root.right);
    root.left = right;
    root.right = left;

    return root;

  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.right = new TreeNode(7);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(9);
   
    
    TreePrinter.printNode(root);
    TreePrinter.printNode(invertTree(root));
  }

}
