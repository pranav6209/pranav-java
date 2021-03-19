/**
 * 
 */
package com.pranav.educative.H_Depth_First_Search;

import java.util.ArrayList;
import java.util.List;
import com.pranav.TreeNode;

/**
 * @author pranavpatel
 * 
 *         https://leetcode.com/problems/check-if-a-string-is-a-valid-sequence-from-root-to-leaves-path-in-a-binary-tree/
 *
 */
public class A6_Count_Paths_For_Sum {

  static int count = 0;

  public static int countPaths(TreeNode root, int S) {
    List<Integer> currenPath = new ArrayList<>();
    countPathsRecursive(root, S, currenPath);
    return count;
  }

  private static void countPathsRecursive(TreeNode currentNode, int S, List<Integer> currentPath) {

    if (currentNode == null)
      return;
    currentPath.add(currentNode.val);
    int pathSum = 0;
    for (int i = currentPath.size() - 1; i >= 0; i--) {

      pathSum = pathSum + currentPath.get(i);

      if (pathSum == S) {
  
        count++;
        System.out.println(count);
      }
    }

    countPathsRecursive(currentNode.left, S, currentPath);
    countPathsRecursive(currentNode.right, S, currentPath);

    currentPath.remove(currentPath.size() - 1);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(4);
    root.right = new TreeNode(8);
    root.left.left = new TreeNode(11);
    root.right.left = new TreeNode(13);
    root.right.right = new TreeNode(4);
    root.left.left.left = new TreeNode(7);
    root.left.left.right = new TreeNode(2);
    root.right.right.left = new TreeNode(5);
    root.right.right.right = new TreeNode(1);
    System.out.println("Tree has path: " + A6_Count_Paths_For_Sum.countPaths(root, 22));
  }

}
