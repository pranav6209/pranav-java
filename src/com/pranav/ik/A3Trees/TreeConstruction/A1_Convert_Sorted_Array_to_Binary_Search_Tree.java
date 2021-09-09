/**
 * 
 */
package com.pranav.ik.A3Trees.TreeConstruction;

/**
 * @author pranavpatel
 * 
 *         Tree series -5 5:00:00
 * 
 *         https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 *         
 *         Time : O(N) Space : O(N)
 * 
 * 
 *         Two types of tree construction patterns
 * 
 *         1. Top down 2. left to right(inorder)
 * 
 *         Top down tree construction template
 * 
 *         1. Figure out and create a root node 2. Recursively construct the
 *         left subtree 3. Recursively construct the right subtree
 * 
 * 
 * 
 *         This problem is base on top down
 *
 */
public class A1_Convert_Sorted_Array_to_Binary_Search_Tree {

  private static class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int val) {
      this.val = val;
    }

  }

  
  // goal here is to always find a mid and create a node from it
  public TreeNode sortedArrayToBST(int[] nums) {
    return dfs(nums, 0, nums.length - 1);
  }

  private TreeNode dfs(int[] nums, int start, int end) {

    // base case

    // in merge sort we have start >=end. in merge sort, when we have start = end we
    // have a single element and it is sorted we return
    // here we want to construct a root when start == mid
    if (start > end)
      return null;

    if (start == end)
      return new TreeNode(nums[start]);      

    // get the mid from the array and that will be our root.
    int mid = start + (end - start) / 2;

    TreeNode root = new TreeNode(nums[mid]);

    // pass the left sub array to construct root.left
    root.left = dfs(nums, start, mid - 1);
    // pass the right sub array to construct root.right
    root.right = dfs(nums, mid + 1, end);

    return root;

  }
}
