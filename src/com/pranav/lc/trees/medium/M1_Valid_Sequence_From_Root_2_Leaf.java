/**
 * 
 */
package com.pranav.lc.trees.medium;

import com.pranav.lc.trees.TreeNode;
import com.pranav.lc.trees.TreePrinter;

/**
 * @author pranavpatel
 * 
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/532/week-5/3315/
 * 
 * https://www.youtube.com/watch?v=Mu4b6dLfCks
 * 
 * 
 * time complexity O(N)
 *
 */
public class M1_Valid_Sequence_From_Root_2_Leaf {



  public static boolean isValidSequence(TreeNode root, int[] arr) {

    // position of array we are at
    int pos = 0;
    int n = arr.length;

    return checkValidSequence(root, n, pos, arr);

  }

  public static boolean checkValidSequence(TreeNode root, int n, int pos, int[] arr) {

    // if the root doen't exist
    if (root == null)
      return false;
    // if array is iterated completely and we are not at a leaf node
    else if (pos == n)
      return false;
    // root value and array value at a particular position is not same
    else if (root.val != arr[pos])
      return false;
    // if its a leaf node and we are at the end of an array
    else if (root.left == null && root.right == null && pos == n - 1)
      return true;

    return (checkValidSequence(root.left, n, pos + 1, arr) || checkValidSequence(root.right, n, pos + 1, arr));

  }
  
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(0);
    root.left.left = new TreeNode(0);
    root.left.right = new TreeNode(2);
    root.left.right.left = new TreeNode(0);

    root.right = new TreeNode(0);
    root.right.left = new TreeNode(1);

    int[] nums = { 1, 0, 0, 0 };
    TreePrinter.printNode(root);
    System.out.println(isValidSequence(root, nums));

  }

}
