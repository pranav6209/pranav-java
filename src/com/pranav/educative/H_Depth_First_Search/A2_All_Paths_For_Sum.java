/**
 * 
 */
package com.pranav.educative.H_Depth_First_Search;

import java.util.ArrayList;
import java.util.List;

import com.pranav.TreeNode;

/**
 * @author pranavpatel
 * https://leetcode.com/problems/path-sum-ii/submissions/
 * 
 * time space read from educative 
 *
 */
public class A2_All_Paths_For_Sum {
  public static List<List<Integer>> findPaths(TreeNode root, int sum) {
    List<List<Integer>> allPaths = new ArrayList<>();
    List<Integer> currentPath = new ArrayList<>();

    findPathsRecursive(root, sum, currentPath, allPaths);

    return allPaths;

  }

  public static void findPathsRecursive(TreeNode root, int sum, List<Integer> currentPath,
  List<List<Integer>> allPaths) {

    // recursion base case.
    if (root == null)
      return;

    currentPath.add(root.val);

    if (root.val == sum && root.left == null && root.right == null) {
      
      // put it in arraylist O(N) operation 
      allPaths.add(new ArrayList<>(currentPath));

    } else {

      findPathsRecursive(root.left, sum - root.val, currentPath, allPaths);
      findPathsRecursive(root.right, sum - root.val, currentPath, allPaths);

    }

    currentPath.remove(currentPath.size() - 1);

  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    System.out.println("Tree has path: " + A2_All_Paths_For_Sum.findPaths(root, 23));
    System.out.println("Tree has path: " + A2_All_Paths_For_Sum.findPaths(root, 16));
  }
}
