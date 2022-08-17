/**
 * 
 */
package com.pranav.ik.A3Trees.TreeConstruction;

/**
 * @author pranavpatel
 * 
 *         Tree series -5 5:00:00
 * 
 *         https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 * 
 *         Time : T(N/2) for 2 recursive calls and O(N) for linkedList O(log n) like a merge sort
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
public class A2_Convert_Sorted_LIst_to_Binary_Search_Tree {

  private static class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int val) {
      this.val = val;
    }

  }

  // Definition for singly-linked list.
  public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  // goal here is to always find a mid and create a node from it
  public TreeNode sortedListToBST(ListNode head) {
    return dfs(head);
  }

  private TreeNode dfs(ListNode head) {

    // linkedList is empty
    if (head == null)
      return null;

    // only one linkedList node
    if (head.next == null)
      return new TreeNode(head.val);

    // similar approach of an array but since we can not access mid directly with linked list
    
    // find mid node. slow will be always at mid.create a node with mid
    // once we have a mid. goal is to divide linked list in 2 parts 
    // head to mid-1(that is why we have prev)
    // prev.next to end 
    
    
    ListNode slow = head;
    ListNode fast = head;
    ListNode prev = null;

    while (fast.next != null && fast.next.next != null) {

      fast = fast.next.next;
      prev = slow;
      slow = slow.next;

    }

    // slow will be at mid so that will be new root.
    // run dfs on left half by passing head again
    // run DFS on right half by passing dfs(slow.next)
    TreeNode root = new TreeNode(slow.val);

    // we are chopping the linkedList in two once mid is found. so first half can become left subtree and second half can become
    // right subtree
    if (prev != null) {

      // cut the list in 2 parts so setting prev.next = null
      prev.next = null;
      root.left = dfs(head);
    }

    root.right = dfs(slow.next);

    return root;
  }
}
