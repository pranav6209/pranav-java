/**
 * 
 */
package com.pranav.educative.H_Depth_First_Search;

import java.util.ArrayList;
import java.util.List;

import com.pranav.TreeNode;

/**
 * @author pranavpatel https://leetcode.com/problems/path-sum-ii/submissions/
 * 
 *         time : O(N^2)  for skewed tree and for if it is Binary tree O(nlogN) n additional for copying
 *         space :O(N) for skewed and O(logn) for binary tree
 *
 */
public class A2_All_Paths_For_Sum {
  public static List<List<Integer>> findPaths(TreeNode root, int sum) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> slate = new ArrayList<>();

    findPathsRecursive(root, sum, slate, res);

    if(res.isEmpty()) {
      
    }else {
      res.add(new ArrayList<>(-1));
    }

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

  // IK approach
  public static void findPathsRecursive2(TreeNode root, int sum, List<Integer> slate, List<List<Integer>> res) {

    /*
     * recursion base case.
     * we do not need it as if root = null we are checking
     * above and before recursive call, we are checking root.left !=null and
     * root.right!=null so we are guaranteed that we ll not have root == null
     * 
     */
    if (root == null)
      return;

    //slate.add(root.val);

    if (root.val == sum && root.left == null && root.right == null) {

      // put it in arraylist O(N) operation
      slate.add(root.val);
      res.add(new ArrayList<>(slate));
      slate.remove(slate.size() - 1);
      return;
    }

    // inclusion case
    if (root.left != null) {
      slate.add(root.val);
      findPathsRecursive2(root.left, sum - root.val, slate, res);
      slate.remove(slate.size() - 1);
    }
    
    //inclusion case no exclusion case here
    if (root.right != null) {
      slate.add(root.val);
      findPathsRecursive2(root.right, sum - root.val, slate, res);
      slate.remove(slate.size() - 1);
    }
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
