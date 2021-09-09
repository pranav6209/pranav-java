/**
 * 
 */
package com.pranav.code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author pranavpatel
 *
 */
public class M_Tree_DFs {
  class TreeNode {
    public int label;
    public TreeNode left_ptr;
    public TreeNode right_ptr;
  }

  public static List<Integer> dfs(TreeNode root) {

    // base case for leaf node
    if(root.left_ptr == null && root.right_ptr== null) return;
    
    // internal node
    if (root.left_ptr != null)
      dfs(root.left_ptr);
    if (root.right_ptr != null)
      dfs(root.right_ptr);

  }
}
