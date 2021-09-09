/**
 * 
 */
package com.pranav.ik.A3Trees.TreeConstruction;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pranavpatel
 * 
 *         This problem is similar to previous one just sort the preorder array
 *         and we ll have inorder array then problem is similar like previous
 */
public class A5_Construct_Binary_Search_Tree_from_Preorder_Traversal {

  private static class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int val) {
      this.val = val;
    }

  }

  public TreeNode bstFromPreorder(int[] preorder) {
    
    int[] inorder = new int[preorder.length];
    for (int i = 0; i < preorder.length; i++) {
      inorder[i] = preorder[i];

    }
    
    Arrays.sort(inorder);
   
    // store index of every number in inorder into hashmap, this will help to find
    // rootIndex

    // Guaranteed we do have dups so no collision in HashMap
    Map<Integer, Integer> inOrderMap = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      inOrderMap.put(inorder[i], i);
    }

    return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inOrderMap);
  }

  // this function will return subtree root of the binary tree constructed from
  // preorder subarray and inorder subarray
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
