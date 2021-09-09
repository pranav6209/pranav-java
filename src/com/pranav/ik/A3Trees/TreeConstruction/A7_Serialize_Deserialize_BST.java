/**
 * 
 */
package com.pranav.ik.A3Trees.TreeConstruction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author pranavpatel
 * 
 *         serialize : depends on tree traversal pattern 
 *         deserialize : depends on a tree construction pattern
 *
 */
public class A7_Serialize_Deserialize_BST {
  private static class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int val) {
      this.val = val;
    }
  }

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    if (root == null)
      return "";
    List<Integer> res = new ArrayList<>();
    dfs(root, res);

    // converting res to string
    StringBuilder sb = new StringBuilder();
    for (int r : res) {
      sb.append(r);
      sb.append(",");
    }
    return sb.toString();
  }

  // pre order traversal
  private static void dfs(TreeNode root, List<Integer> res) {
    if (root == null)
      return;

    res.add(root.val);

    if (root.left != null)
      dfs(root.left, res);

    if (root.right != null)
      dfs(root.right, res);

  }

  // Decodes your encoded data to tree.
  // same as construct binary tree from preorder
  
  // only additional stuff is data so we have to split and build pre order and then in order array
  public TreeNode deserialize(String data) {

    if(data == null || data.isEmpty()) return null;
    
    String[] arr = data.split(",");
    int[] preOrder = new int[arr.length];
    int[] inOrder = new int[arr.length];

    for (int i = 0; i < arr.length; i++) {
      preOrder[i] = Integer.parseInt(arr[i]);
    }

    for (int i = 0; i < arr.length; i++) {
      inOrder[i] = preOrder[i];
    }

    Arrays.sort(inOrder);

    Map<Integer, Integer> inOrderMap = new HashMap<>();
    for (int i = 0; i < inOrder.length; i++) {
      inOrderMap.put(inOrder[i], i);
    }

    return helper(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1, inOrderMap);

  }

  private static TreeNode helper(int[] preorder, int pstart, int pend, int[] inorder, int istart, int iend,
  Map<Integer, Integer> inOrderMap) {

    // array of 0 size
    if (pstart > pend)
      return null;

    if (pstart == pend)
      return new TreeNode(preorder[pstart]);

    // recursive case

    // preorder first value is root always
    TreeNode root = new TreeNode(preorder[pstart]);
    // find index of the value in map. this will help us to break the array
    int rootIndex = inOrderMap.get(root.val);

    int numLeft = rootIndex - istart; // size of numLeft : rootIndex - 1 - istart + 1
    int numRight = iend - rootIndex; // size of numRight : iend - rootIndex -1 + 1

    // this will construct left side of the tree
    root.left = helper(preorder, pstart + 1, pstart + numLeft, inorder, istart, rootIndex - 1, inOrderMap);
    // this will construct right side of the tree
    root.right = helper(preorder, pstart + numLeft + 1, pend, inorder, rootIndex + 1, rootIndex + numRight, inOrderMap);

    return root;
  }
}
