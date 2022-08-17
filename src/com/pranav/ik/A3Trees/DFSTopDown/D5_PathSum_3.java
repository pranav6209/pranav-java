/**
 * 
 */
package com.pranav.ik.A3Trees.DFSTopDown;

import java.util.ArrayList;
import java.util.List;

// explanation 3:20:00 Tree series 2

// top-down DFS
public class D5_PathSum_3 {

  private static class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
  }

  public int pathSum(TreeNode root, int targetSum) {

    int[] res = new int[] { 0 };
    if (root == null)
      return res[0];
    DFS(root, new ArrayList<>(), targetSum, res);

    return res[0];

  }

  public static void DFS(TreeNode node, List<Integer> slate, int targetSum, int[] res) {

    // common to leaf and non leaf node
    // slate has all the values from root to leaf
    slate.add(node.val);

    // here in slate, starting from slate.size()-1 and then going till size 0 to check if targetSum exists.
    // basically, We want to count no of path that ends at this node

    // based on leetcode example -1, we are traversing 10 -> 5 -> 3 . when we are @ 3,we want to calculate
    // (3 + 5) 8. That can only be done when we are 3 and counting upward. if we keep adding next element we
    // go into sumslate (10 + 5 + 3)  that logic will not make sense here as we ll never be evaluate 8 easily.

    // explanation 3:43:00 Tree Series 2
    
    int suffixSum = 0;
    for (int i = slate.size() - 1; i >= 0; i--) {

      suffixSum = suffixSum + slate.get(i);
      if (suffixSum == targetSum) {
        res[0] = res[0] + 1;
      }

    }

    // nothing special here for leaf node, we can remove this
    //if (node.left == null && node.right == null)
    //  return;

    if (node.left != null) {
      DFS(node.left, slate, targetSum, res);
    }

    if (node.right != null) {
      DFS(node.right, slate, targetSum, res);
    }

    slate.remove(slate.size() - 1);
  }
}
