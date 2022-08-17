/**
 * 
 */
package com.pranav.ik.A3Trees.DFSBottomUP;

/**
 * @author pranavpatel
 * 
 * 
 *  try to do with this approach 
 *  
 *  https://leetcode.com/problems/largest-bst-subtree/discuss/443235/Java-simple-with-comments
 *
 */

// top down
public class F6_Largest_BST_SubTree2 {

    public int largestBSTSubtree(TreeNode root) {
        if(root == null) return 0;

        // if this node is BST get the size
        if(isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            return size(root);
        }

        // otherwise search in left & right
        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }

    private int size(TreeNode node) {
        // base case
        if(node == null) return 0;

        // sum all branches plus current one
        return size(node.left) + size(node.right) + 1;
    }

    private boolean isBST(TreeNode node, int min, int max) {
        // base case
        if(node == null) return true;

        // check that this node satisfies min/max contracts or not
        if(node.val <= min || node.val >= max) return false;

        // check left and right node in more strict diapasone
        return isBST(node.left, min, node.val) && isBST(node.right, node.val, max);
    }
}