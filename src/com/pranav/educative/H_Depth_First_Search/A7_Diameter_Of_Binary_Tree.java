
/**
 * 
 */
package com.pranav.educative.H_Depth_First_Search;

import com.pranav.lc.trees.TreeNode;
import com.pranav.lc.trees.TreePrinter;

/**
 * @author pranavpatel
 * 
 *         https://leetcode.com/problems/diameter-of-binary-tree/ 1.Tree
 *         Traversal https://www.youtube.com/watch?v=98AGQU0z2wg 2. BFS DFS
 *         https://www.youtube.com/watch?v=uWL6FJhq5fM&list=RDCMUCx-kFfzekMbhODaBss-ZnsA&index=2
 *         3. Height of tree https://www.youtube.com/watch?v=_O-mK2g_jhI 4. Dia
 *         of tree https://www.youtube.com/watch?v=ey7DYc9OANo
 *
 *
 *
 *         Time Complexity: O(N). We visit every node once.
 * 
 *         Space Complexity: O(N), the size of our implicit call stack during
 *         our depth-first search.
 */
public class A7_Diameter_Of_Binary_Tree {

  private static int treeDiameter = 0;

  public static int diameterOfBinaryTree(TreeNode root) {
    if (root == null)
      return 0;
    helper(root);
    return treeDiameter;

  }

  // we are not passing anything from top to bottom instead information is coming
  // from bottom to top
  public static int helper(TreeNode currentNode) {

    // either this or check before calling currenNode.left and CurrentNode.right
    if (currentNode.left == null && currentNode.right == null)
      return 0;

    int leftTreeHeight = 0;
    if (currentNode.left != null) {

      // lazy manager adding a distance between my self and the node
      leftTreeHeight = helper(currentNode.left) + 1;
    }
    int rightTreeHeight = 0;
    if (currentNode.right != null) {
      rightTreeHeight = helper(currentNode.right) + 1;
    }
    int diameter = leftTreeHeight + rightTreeHeight;

    treeDiameter = Math.max(treeDiameter, diameter);

    return treeDiameter;

  }

  public static void main(String[] args) {

    // Node is defined in A_Maximum_Depth_Of_Binary_Tree
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.right.left = new TreeNode(5);
    root.right.right = new TreeNode(6);
    System.out.println("Tree Diameter: " + A7_Diameter_Of_Binary_Tree.diameterOfBinaryTree(root));
    root.left.left = null;
    root.right.left.left = new TreeNode(7);
    root.right.left.right = new TreeNode(8);
    root.right.right.left = new TreeNode(9);
    root.right.left.right.left = new TreeNode(10);
    root.right.right.left.left = new TreeNode(11);
    System.out.println("Tree Diameter: " + A7_Diameter_Of_Binary_Tree.diameterOfBinaryTree(root));

  }

}
