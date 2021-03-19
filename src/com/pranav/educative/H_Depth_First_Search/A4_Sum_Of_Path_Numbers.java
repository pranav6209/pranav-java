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
 */
public class A4_Sum_Of_Path_Numbers {

  public static int findSumOfPathNumbers(TreeNode root) {

    List<String> allPaths = new ArrayList<>();
    StringBuffer sb = new StringBuffer();
    findSumOfPathNumbersRecursive(root, sb, allPaths);

    int sum = 0;
    for (String path : allPaths) {

      sum = sum + Integer.parseInt(path);

    }

    return sum;
  }

  public static void findSumOfPathNumbersRecursive(TreeNode root, StringBuffer sb, List<String> allPaths) {

    if (root == null)
      return;

    int length = sb.length();

    sb.append(root.val);

    if (root.left == null && root.right == null)
      allPaths.add(sb.toString());

    findSumOfPathNumbersRecursive(root.left, sb, allPaths);

    findSumOfPathNumbersRecursive(root.right, sb, allPaths);

    sb.setLength(length);

  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(0);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(1);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(5);
    System.out.println("Total Sum of Path Numbers: " + A4_Sum_Of_Path_Numbers.findSumOfPathNumbers(root));
  }

}
