
/**
 * 
 */
package com.pranav.ik.A3Trees;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pranavpatel
 *
 */
public class PP4_Print_All_Paths_Of_Tree {

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

  private static void dfs(TreeNode root, List<Integer> slate, List<List<Integer>> res) {

    if (root.left_ptr == null && root.right_ptr == null) {

      slate.add(root.val);
      res.add(new ArrayList<>(slate));
      slate.remove(slate.size() - 1);
      return;
    }

    if (root.left_ptr != null) {
      slate.add(root.val);
      dfs(root.left_ptr, slate, res);
      slate.remove(slate.size() - 1);

    }

    if (root.right_ptr != null) {
      slate.add(root.val);
      dfs(root.right_ptr, slate, res);
      slate.remove(slate.size() - 1);

    }

  }

}
