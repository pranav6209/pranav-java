
/**
 * 
 */
package com.pranav.ik.A3Trees.DFSTopDown;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pranavpatel
 * 
 *         time : input O(N) + call space
 *         
 *         In top-down DFS, as information was passed top-down from parent to child, that
           information was packaged inside the arguments of the dfs function.
 *
 */
public class D1_Print_All_Paths_Of_Tree {

  private static class TreeNode {
    public int val;
    public TreeNode left_ptr;
    public TreeNode right_ptr;
  }

  static List<List<Integer>> allPathsOfABinaryTree(TreeNode root) {

    List<List<Integer>> res = new ArrayList<>();
    if (root == null)
      return res;
    List<Integer> slate = new ArrayList<>();

    dfs(root, slate, res);
    return res;
  }

  // TreeNode root is subproblem definition
  // slate is Partial solution
  // for any arbitrary worker
  private static void dfs(TreeNode node, List<Integer> slate, List<List<Integer>> res) {

    /*
     * we can write slate.add(node.val) and slate.remove(slate.size()-1)
     * inside base leaf node code and intermediate node. But writing outside
     * as a common is a best practice.
     */
    
    // common for leaf and intermediate node writing it outside.
    slate.add(node.val);

    // base case leaf node
    if (node.left_ptr == null && node.right_ptr == null) {

      res.add(new ArrayList<>(slate));
      // here we can avoid writing return statement as below code has  a if (node.left_ptr != null),  if (node.right_ptr != null)
      // that ll not execute for leaf and code will return automatically after poping an element
      // return;
    }

    // intermediate node
    if (node.left_ptr != null) {

      dfs(node.left_ptr, slate, res);

    }

    if (node.right_ptr != null) {

      dfs(node.right_ptr, slate, res);

    }

    // common for leaf and intermediate node writing it outside
    slate.remove(slate.size() - 1);

  }

}
