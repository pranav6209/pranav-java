/**
 * 
 */
package com.pranav.educative.H_Depth_First_Search;

import java.util.ArrayList;
import java.util.List;

import com.pranav.TreeNode;

/**
 * @author pranavpatel
 * 
 * https://leetcode.com/problems/binary-tree-paths/
 *
 */
public class A3_All_Paths_For_Sum {
  public static List<String> findPaths(TreeNode root) {
    List<String> allPaths = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    findPathsRecursive(root, sb, allPaths);

    return allPaths;

  }

  public static void findPathsRecursive(TreeNode root, StringBuilder sb, List<String> allPaths) {

    // recursion base case.
    if (root == null)
      return;

    int len = sb.length();
    sb.append(root.val);

    if (root.left == null && root.right == null) {

      allPaths.add(sb.toString());

    } else

    {
      sb.append("->");
      findPathsRecursive(root.left, sb, allPaths);
      findPathsRecursive(root.right, sb, allPaths);

    }

    // this will remove char (for backtracking)
    sb.setLength(len);

  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    System.out.println("Tree has path: " + A3_All_Paths_For_Sum.findPaths(root));
  }
}
