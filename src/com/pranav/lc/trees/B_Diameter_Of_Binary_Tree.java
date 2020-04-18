/**
 * 
 */
package com.pranav.lc.trees;

/**
 * @author pranavpatel
 * 
 * 1. Tree Traversal
 * https://www.youtube.com/watch?v=98AGQU0z2wg
 * 2. BFS DFS
 * https://www.youtube.com/watch?v=uWL6FJhq5fM&list=RDCMUCx-kFfzekMbhODaBss-ZnsA&index=2
 * 3. Height of tree
 * https://www.youtube.com/watch?v=_O-mK2g_jhI
 * 4. Dia of tree
 * https://www.youtube.com/watch?v=ey7DYc9OANo
 *
 *
 *
 *Time Complexity: O(N). We visit every node once.

  Space Complexity: O(N), the size of our implicit call stack during our depth-first search.
 */
public class B_Diameter_Of_Binary_Tree {

  static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      this.val = x;
    }

  }

  public static int diameterOfBinaryTree(TreeNode root) {

    if(root==null) return 0;
    int leftSubTreeHeight = heightOfBinaryTree(root.left);
    int rightSubTreeHeight = heightOfBinaryTree(root.left);
    int leftDia = diameterOfBinaryTree(root.left);
    int rightDia = diameterOfBinaryTree(root.right);

    return Math.max(leftSubTreeHeight + rightSubTreeHeight, Math.max(leftDia,rightDia));

  }

  // depth
  private static int heightOfBinaryTree(TreeNode root) {

    int h = 0;
    if (root == null)
      return h;

    int leftHeight = heightOfBinaryTree(root.left);
    int rightHeight = heightOfBinaryTree(root.right);
    if (leftHeight > rightHeight) {

      h = 1+leftHeight;

    } else {

      h = 1+rightHeight;
    }
    return h;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.right = new TreeNode(4);
    root.right.left = new TreeNode(5);
    root.right.right = new TreeNode(6);
    root.right.left.left = new TreeNode(7);
    root.right.left.right = new TreeNode(8);

    System.out.println(heightOfBinaryTree(root));

  }

}
