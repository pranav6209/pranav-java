/**
 * 
 */
package com.pranav.ik.A3Trees.TreeConstruction;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pranavpatel
 * 
 *         https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 *
 *         Top down tree construction template
 *
 *         1. Figure out and create a root node 2. Recursively construct the
 *         left subtree 3. Recursively construct the right subtree
 *
 *         1. here root node will be always postorder array last value so we ll
 *         construct a root from that 2. then we ll find the rootindex in
 *         hashmap, this will help us to break inorder array.purspose of
 *         breaking an array is to determine what goes into left array and what
 *         in right.Needed for recursively constructing the tree
 * 
 *         Time : O(N) each worker is doing constant amt work for n node it will
 *         O(N) space : O(heightOfTree) O(N)
 */
public class A6_Construct_Binary_Tree_from_Inorder_Postorder_Traversal {

  private static class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int val) {
      this.val = val;
    }

  }

  public TreeNode buildTree(int[] inorder, int[] postorder) {

    // store index of every number in inorder into hashmap, this will help to find
    // rootIndex

    // Guaranteed we do have dups so no collision in HashMap
    Map<Integer, Integer> inOrderMap = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      inOrderMap.put(inorder[i], i);
    }

    return helper(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, inOrderMap);
  }

  // this function will return subtree root of the binary tree constructed from
  // preorder subarray and inorder subarray
  private static TreeNode helper(int[] postorder, int pstart, int pend, int[] inorder, int istart, int iend,
  Map<Integer, Integer> inOrderMap) {

    // array of 0 size
    if (pstart > pend)
      return null;

    if (pstart == pend)
      // postorder last value is root always
      return new TreeNode(postorder[pend]);

    // recursive case

    // postorder last value is root always
    TreeNode root = new TreeNode(postorder[pend]);
    // find index of the value in map. this will help us to break the array
    int rootIndex = inOrderMap.get(root.val);

    int numLeft = rootIndex - istart; // size of numLeft : rootIndex - 1 - istart + 1
    int numRight = iend - rootIndex; // size of numRight : iend - rootIndex -1 + 1

    // this will construct left side of the tree
    root.left = helper(postorder, pstart, pstart + numLeft - 1, inorder, istart, rootIndex - 1, inOrderMap);
    // this will construct right side of the tree
    root.right = helper(postorder, pstart + numLeft, pend - 1, inorder, rootIndex + 1, iend, inOrderMap);

    return root;
  }
}
