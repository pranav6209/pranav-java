/**
 * 
 */
package com.pranav.ik.A3Trees.DFSTopDown;

// explanation 2:10:00 Tree series 2
// top-down DFS
public class D4_Binary_Tree_Longest_Consecutive_Sequence {

  private static class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
  }

  //to determine if we can extend, need to know parent value and track running length, so each node passes that to child
  
  static int longestConsSeq(TreeNode root) {

    // as we can not pass by value adding it in to array and passing it as a
    // reference this is a trick for not declaring global variable

    int[] res = new int[] { 0 };
    if (root == null)
      return res[0];
    
    // for a safety, we ll pass root.val as parentval, in the dfs. so in dfs call, it will skip the if and ll go to else and have 
    // lenghtSoFar =1 
    DFS(root, root.val, 0, res);

    return res[0];

  }

  public static void DFS(TreeNode node, int parentVal, int lenghtSoFar, int[] res) {

    // common to leaf and non leaf node

    // extend the sequence by 1
    if (node.val == parentVal + 1) {
      lenghtSoFar = lenghtSoFar + 1;
    } else { // reset sequence
      lenghtSoFar = 1;
    }

    if (lenghtSoFar > res[0]) {
      res[0] = lenghtSoFar;
    }

    // nothing special here for leaf node, we can remove this
    //if (node.left == null && node.right == null)
    //  return;

    if (node.left != null) {
      DFS(node.left, node.val, lenghtSoFar, res);
    }

    if (node.right != null) {
      DFS(node.right, node.val, lenghtSoFar, res);
    }
  }
}
