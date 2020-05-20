/**
 * 
 */
package com.pranav.lc.trees.hard;

import com.pranav.lc.trees.TreeNode;
import com.pranav.lc.trees.TreePrinter;

/**
 * @author pranavpatel
 *
 */
public class R1_Binary_Tree_Max_Path_Sum {
  public static int maxPathSum(TreeNode root) {

    return calculateMaxPathSum(root);

  }

  public static int calculateMaxPathSum(TreeNode root) {

    int maxPathSum = Integer.MIN_VALUE;
    
    if(root==null) return 0;
    
    int left_max =Math.max(0,calculateMaxPathSum(root.left));
    int right_max =Math.max(0,calculateMaxPathSum(root.right));
    
    maxPathSum = Math.max(maxPathSum,Math.max(left_max, right_max+root.val));

    return maxPathSum;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(0);
    root.left.left = new TreeNode(0);
    root.left.right = new TreeNode(2);
    root.left.right.left = new TreeNode(0);

    root.right = new TreeNode(0);
    root.right.left = new TreeNode(1);
    
    TreePrinter.printNode(root);
    System.out.println(maxPathSum(root));

  }

}
