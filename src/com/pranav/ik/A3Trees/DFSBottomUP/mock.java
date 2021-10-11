/**
 * 
 */
package com.pranav.ik.A3Trees.DFSBottomUP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author pranavpatel
 *
 */
public class mock {

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public static List<Integer> mostFrequent(TreeNode root) {

    Map<Integer, Integer> map = new HashMap<>();

    List<Integer> res = new ArrayList<>();

    if (root == null)
      return new ArrayList<>();

    dfs(root, map);

    System.out.println(map);

    int max = Integer.MIN_VALUE;

    for (int key : map.keySet()) {

      System.out.println(max);

      if (map.get(key) > max) {

        res.clear();
        res.add(key);
        max = map.get(key);

      } else if (map.get(key) == max) {

        res.add(key);

      }

    }

    return res;
  }

  private static int dfs(TreeNode root, Map<Integer, Integer> map) {

    // 1. leaf level
    // 2 intermedate level

    if (root.left == null && root.right == null) {

      if (map.containsKey(root.val)) {

        map.put(root.val, map.get(root.val) + 1);

      }

      else {

        map.put(root.val, 1);

      }

      return root.val;

    }

    int leftSum = 0;
    int rightSum = 0;
    int mySum = 0;

    if (root.left != null) {

      leftSum = dfs(root.left, map);

      mySum = root.val + leftSum;

    }

    if (root.right != null) {

      rightSum = dfs(root.right, map);

      mySum = mySum + rightSum;

    }

    if (map.containsKey(mySum)) {

      map.put(mySum, map.get(mySum) + 1);
    } else {

      map.put(mySum, 1);

    }

    return mySum;

  }
}
