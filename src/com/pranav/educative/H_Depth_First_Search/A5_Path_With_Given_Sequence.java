/**
 * 
 */
package com.pranav.educative.H_Depth_First_Search;

import com.pranav.TreeNode;

/**
 * @author pranavpatel
 * 
 * https://leetcode.com/problems/check-if-a-string-is-a-valid-sequence-from-root-to-leaves-path-in-a-binary-tree/
 *
 */
public class A5_Path_With_Given_Sequence {
  public static boolean findPath(TreeNode root, int[] sequence) {
    return findPathRecursive(root, sequence, 0);
  }

  private static boolean findPathRecursive(TreeNode currentNode, int[] sequence, int sequenceIndex) {

    if (currentNode == null)
      return false;

    if (sequenceIndex > sequence.length - 1 || currentNode.val != sequence[sequenceIndex])
      return false;

    // if the current node is a leaf, add it is the end of the sequence, we have
    // found a path!
    if (currentNode.left == null && currentNode.right == null && currentNode.val == sequence[sequenceIndex])

      return true;

    // recursively call to traverse the left and right sub-tree
    // return true if any of the two recusrive call return true
    return findPathRecursive(currentNode.left, sequence, sequenceIndex + 1)
    || findPathRecursive(currentNode.right, sequence, sequenceIndex + 1);

  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(0);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(1);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(5);

    System.out.println("Tree has path sequence: " + A5_Path_With_Given_Sequence.findPath(root, new int[] { 1, 0, 7 }));
    System.out.println("Tree has path sequence: " + A5_Path_With_Given_Sequence.findPath(root, new int[] { 1, 1, 6 }));
  }

}
