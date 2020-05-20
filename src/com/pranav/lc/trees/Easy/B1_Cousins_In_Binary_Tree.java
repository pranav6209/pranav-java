
/**
 * 
 */
package com.pranav.lc.trees.Easy;

import com.pranav.lc.trees.TreeNode;
import com.pranav.lc.trees.TreePrinter;

/**
 * @author pranavpatel
 * 
 *         https://leetcode.com/problems/cousins-in-binary-tree/submissions/
 * 
 *         solution
 *         https://leetcode.com/problems/cousins-in-binary-tree/discuss/618795/JavaC%2B%2BPython-DFS-Clean-code
 * 
 *         https://www.youtube.com/watch?v=PyfLrJvoC_s
 *
 */

// time complexity O(N)
// space complexity O(H) where height of binary tree.
public class B1_Cousins_In_Binary_Tree {

  static TreeNode xParent = null;
  static TreeNode yParent = null;
  static TreeNode parent = null;

  // initialize with some random no as root is 0, initialize with -1;
  static int xdepth = -1;
  static int ydepth = -1;
  static int depth = 0;

  public static boolean isCousins(TreeNode root, int x, int y) {

    dfs(root, parent, x, y, depth);
    return xdepth == ydepth && xParent != yParent;

  }

  public static void dfs(TreeNode root, TreeNode parent, int x, int y, int depth) {

    // Recursion base
    if (root == null)
      return;
    if (root.val == x) {
      xParent = parent;
      xdepth = depth;
    }
    if (root.val == y) {
      yParent = parent;
      ydepth = depth;
    }
    // Recursion step-1
    dfs(root.left, root, x, y, depth + 1);
    // Recursion step-2
    dfs(root.right, root, x, y, depth + 1);

    // here no return statement as we do not want to go back to the root of tree.we
    // are not returning anything to parent node.
    // just iterating tree once.

  }

  public static void main(String[] args) {
    // Node is defined in A_Maximum_Depth_Of_Binary_Tree
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    // root.left.right = new TreeNode(2);
    root.left.left = new TreeNode(4);
    TreePrinter.printNode(root);

    int x = 4;
    int y = 3;
    System.out.println(isCousins(root, x, y));
  }

}
