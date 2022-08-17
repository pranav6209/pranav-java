/**
 * 
 */
package com.pranav.ik.A3Trees.DFSTopDown;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author pranavpatel
 *
 */
public class D7_Boundry_Of_Binary_Tree {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }

  }

  public List<Integer> boundaryOfBinaryTree(TreeNode root) {

    List<Integer> res = new ArrayList<>();

    if (root == null)
      return res;

    if (root.left == null && root.right == null) {
      res.add(root.val);
      return res;
    }

    List<Integer> leftBoundry = getLeftBoundry(root);
    List<Integer> leafNode = new ArrayList<>();
    getLeafNode(root, leafNode);
    List<Integer> rightBoundry = getRightBoundry(root);
//
//    System.out.println(leftBoundry);
//    System.out.println(leafNode);
//    System.out.println(rightBoundry);

    res.addAll(leftBoundry);
    res.addAll(leafNode);
    res.addAll(rightBoundry);
    return res;
  }

  // we ll try to go left first and if left is not available, we ll go right
  private List<Integer> getLeftBoundry(TreeNode node) {

    // since it is not a recursion call, we do not need to keep passing the leftBoundry
    List<Integer> leftBoundry = new ArrayList<>();

    // handle root separately add that during a left walk
    leftBoundry.add(node.val);

    if (node.left != null) {

      TreeNode currentNode = node.left;

      while (currentNode != null) {
        leftBoundry.add(currentNode.val);
        // try going to left side first if there is a left node
        if (currentNode.left != null) {
          currentNode = currentNode.left;
        } else {// else go to right
          currentNode = currentNode.right;
        }
        // left and right both are null we are done
      }

      // remove leaf we have collected, we ll collect leaf separately
      leftBoundry.remove(leftBoundry.size() - 1);

    }

    return leftBoundry;
  }

  private List<Integer> getRightBoundry(TreeNode node) {

    // root is already added so no need to add it here
    List<Integer> rightBoundry = new ArrayList<>();

    if (node.right != null) {

      TreeNode currenNode = node.right;

      while (currenNode != null) {
        rightBoundry.add(currenNode.val);

        if (currenNode.right != null) {
          currenNode = currenNode.right;
        } else {
          currenNode = currenNode.left;
        }

      }

      rightBoundry.remove(rightBoundry.size() - 1);
    }
    Collections.reverse(rightBoundry);
    return rightBoundry;
  }

  private void getLeafNode(TreeNode node, List<Integer> leafNode) {

    if (node.left == null && node.right == null) {
      leafNode.add(node.val);
    }

    if (node.left != null)
      getLeafNode(node.left, leafNode);
    if (node.right != null)
      getLeafNode(node.right, leafNode);

  }
}
