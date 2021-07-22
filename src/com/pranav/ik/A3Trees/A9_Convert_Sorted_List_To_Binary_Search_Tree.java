/**
 * 
 */
package com.pranav.ik.A3Trees;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pranavpatel
 * 
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * 
 * Time : O(N) //every worker is creating new node
 * SPace :O(Height of the tree) O(lonN) as we are making binary tree 
 *
 */
public class A9_Convert_Sorted_List_To_Binary_Search_Tree {

  class SinglyLinkedListNode {
    public Integer data;
    public SinglyLinkedListNode next;

    SinglyLinkedListNode(Integer node_data) {
      this.data = node_data;
      this.next = null;
    }
  };

  class TreeNode {
    public int val;
    public TreeNode left_ptr;
    public TreeNode right_ptr;

    public TreeNode(int val) {
      this.val = val;
      this.left_ptr = null;
      this.right_ptr = null;
    }
  };

  static TreeNode sorted_list_to_bst(SinglyLinkedListNode head) {

    // convert LinkedList to arraylist

    SinglyLinkedListNode curr = head;
    List<Integer> inOrder = new ArrayList<>();
    TreeNode root = null;

    while (curr != null) {
      inOrder.add(curr.data);
      curr = curr.next;

    }

    return helper(inOrder, 0, inOrder.size() - 1, root);

  }

  
  // think about what arbitrary node  in the tree will do 
  private static TreeNode helper(List<Integer> inOrder, int start, int end, TreeNode root) {

    // if sub array is empty 
    if (start > end)
      return null;
    
    // Recursive Case // index
    int mid = start + (end - start) / 2;

    root = new TreeNode(inOrder.get(mid));

    root.left_ptr = helper(inOrder, start, mid - 1, root);
    root.right_ptr = helper(inOrder, mid + 1, end, root);

    return root;

  }
}
