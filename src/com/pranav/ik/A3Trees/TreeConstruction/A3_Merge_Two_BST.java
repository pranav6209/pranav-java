/**
 * 
 */
package com.pranav.ik.A3Trees.TreeConstruction;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pranavpatel
 * 
 * 
 *
 */
public class A3_Merge_Two_BST {

  private static class TreeNode {
    public int val;
    public TreeNode left_ptr;
    public TreeNode right_ptr;

    public TreeNode(int val) {
      this.val = val;
    }

  }

  // there are 3 problems merge here
  static TreeNode merge_two_BSTs(TreeNode root1, TreeNode root2) {

    // 1. get inorder list of the both BST, since it is  BST it will be sorted
    List<Integer> inOrder1 = new ArrayList<>();
    List<Integer> inOrder2 = new ArrayList<>();

    inOrder(root1, inOrder1);
    inOrder(root2, inOrder2);

    // 2. merge sort two sorted list 
    List<Integer> sortedList = mergeSort(inOrder1, inOrder2);
    
    // 3. construct a new BST with sorted array like problem 1
    return convertArrToTree(sortedList, 0, sortedList.size() - 1);
  }

  // inorder list
  private static void inOrder(TreeNode node, List<Integer> res) {

    if (node == null)
      return;

    if (node.left_ptr != null)
      inOrder(node.left_ptr, res);
    res.add(node.val);
    if (node.right_ptr != null)
      inOrder(node.right_ptr, res);
  }

  // merge sort
  static List<Integer> mergeSort(List<Integer> listA, List<Integer> listB) {
    List<Integer> result = new ArrayList<>();
    int i = 0;
    int j = 0;
    while (i < listA.size() && j < listB.size()) {
      if (listA.get(i) <= listB.get(j)) {
        result.add(listA.get(i));
        i++;
      } else if (listA.get(i) > listB.get(j)) {
        result.add(listB.get(j));
        j++;
      }
    }

    if (i < listA.size()) {
      while (i < listA.size()) {
        result.add(listA.get(i));
        i++;
      }
    }

    if (j < listB.size()) {
      while (j < listB.size()) {
        result.add(listB.get(j));
        j++;
      }
    }

    return result;
  }

  // covert sorted array to tree problem
  private static TreeNode convertArrToTree(List<Integer> nums, int start, int end) {

    // base case

    // in merge sort we have start >=end. in merge sort, when we have start = end we
    // have a single element and it is sorted we return
    // here we want to construct a root when start == mid
    if (start > end)
      return null;

    if (start == end)
      return new TreeNode(nums.get(start));

    // get the mid from the array and that will be our root.
    int mid = start + (end - start) / 2;

    TreeNode root = new TreeNode(nums.get(mid));

    // pass the left sub array to construct root.left
    root.left_ptr = convertArrToTree(nums, start, mid - 1);
    // pass the right sub array to construct root.right
    root.right_ptr = convertArrToTree(nums, mid + 1, end);

    return root;

  }

}
