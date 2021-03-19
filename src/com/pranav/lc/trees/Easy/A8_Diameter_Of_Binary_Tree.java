
/**
 * 
 */
package com.pranav.lc.trees.Easy;

import com.pranav.lc.trees.TreeNode;
import com.pranav.lc.trees.TreePrinter;

/**
 * @author pranavpatel
 *         https://leetcode.com/problems/diameter-of-binary-tree/
 *         1. Tree Traversal https://www.youtube.com/watch?v=98AGQU0z2wg 
 *         2. BFS DFS
 *         https://www.youtube.com/watch?v=uWL6FJhq5fM&list=RDCMUCx-kFfzekMbhODaBss-ZnsA&index=2
 *         3. Height of tree https://www.youtube.com/watch?v=_O-mK2g_jhI 
 *         4. Dia of tree https://www.youtube.com/watch?v=ey7DYc9OANo
 *
 *
 *
 *         Time Complexity: O(N). We visit every node once.
 * 
 *         Space Complexity: O(N), the size of our implicit call stack during
 *         our depth-first search.
 */
public class A8_Diameter_Of_Binary_Tree {

  public static int diameterOfBinaryTree(TreeNode root) {

    if (root == null)
      return 0;
    int leftSubTreeHeight = heightOfBinaryTree(root.left);
    int rightSubTreeHeight = heightOfBinaryTree(root.right);
    int leftDia = diameterOfBinaryTree(root.left);
    int rightDia = diameterOfBinaryTree(root.right);

    return Math.max(leftSubTreeHeight + rightSubTreeHeight, Math.max(leftDia, rightDia));

  }

  // depth
  private static int heightOfBinaryTree(TreeNode root) {

    // base case
    if (root == null)
      return 0;

    //step 1
    int leftHeight = heightOfBinaryTree(root.left);
    // step 2
    int rightHeight = heightOfBinaryTree(root.right);
    // if (leftHeight > rightHeight) {
    //
    // h = 1+leftHeight;
    //
    // } else {
    //
    // h = 1+rightHeight;
    // }
    
    // step 3
    int h = Math.max(leftHeight, rightHeight) + 1;
    //return statement 
    return h;
  }

  public static void main(String[] args) {

    // Node is defined in A_Maximum_Depth_Of_Binary_Tree
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.right = new TreeNode(4);
    root.right.left = new TreeNode(5);
    root.right.right = new TreeNode(6);
    root.right.left.left = new TreeNode(7);
    root.right.left.right = new TreeNode(8);
    TreePrinter.printNode(root);
    System.out.println(diameterOfBinaryTree(root));

  }

}
