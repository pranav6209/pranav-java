/**
 * 
 */
package com.pranav.lc.trees.medium;

import com.pranav.lc.trees.TreeNode;
import com.pranav.lc.trees.TreePrinter;

/**
 * @author pranavpatel
 * 
 *         solution -1 O(N^2) as every time starting from root node
 *         https://www.youtube.com/watch?v=9sw8RRsBw6s&t=322s
 * 
 * 
 *         Solution -2
 * 
 *         Below solution using this code
 *         https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/discuss/589059/JAVA-EASIEST-SOLUTION-WITH-CLEAR-EXPLANATION-OF-LOGIC!
 * 
 * 
 *         Try using this one much better
 *         https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/discuss/252232/JavaC%2B%2BPython-O(N)-Solution
 * 
 *         solution with stack
 *         https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/discuss/252754/Java-Stack-Iterative-Solution
 *
 */

// solution1
public class M2_Construct_Binary_Search_Tree_From_preorder_Traversal {

  public static TreeNode bstFromPreorder1(int[] preorder) {
    TreeNode root = new TreeNode(preorder[0]);
    for (int i = 1; i < preorder.length; i++) {
      FindTreeNode(root, preorder[i]);
    }
    return root;
  }

  public static TreeNode FindTreeNode(TreeNode root, int preVal) {
    if (root == null) {
      return root = new TreeNode(preVal);
    }
    if (root.val > preVal)
      root.left = FindTreeNode(root.left, preVal);
    else
      root.right = FindTreeNode(root.right, preVal);
    return root;
  }

  // solution2
  private static TreeNode helper(int[] preorder, int start, int end) {
    if (start > end)
      return null;

    TreeNode node = new TreeNode(preorder[start]);
    int i;
    for (i = start; i <= end; i++) {
      if (preorder[i] > node.val)
        break;
    }

    node.left = helper(preorder, start + 1, i - 1);
    node.right = helper(preorder, i, end);
    return node;

  }

  public static TreeNode bstFromPreorder2(int[] preorder) {
    return helper(preorder, 0, preorder.length - 1);
  }

  
  
  public static void main(String[] args) {

    int[] A = { 8, 5, 1, 7, 10, 12 };
    TreePrinter.printNode(bstFromPreorder2(A));
  }

}
