/**
 * 
 */
package com.pranav.ik.A3Trees.DFSBottomUP;

import java.util.List;

/**
 * @author pranavpatel
 * 
 *        
 * 
 *         https://stackoverflow.com/questions/2603692/what-is-the-difference-between-tree-depth-and-height
 * 
 *         bottom DFS 4:00:00
 *         
 *         in bottom up DFS, call stacks goes from top to bottom but flow informations pass from bottom to top.
 *         that information will be packaged inside the return values from the dfs function.
 */

public class F1_Height_Of_K_Ary_Tree {

  class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, List<Node> _children) {
      val = _val;
      children = _children;
    }
  }

  /*
   * from slide of tree series
   * 
   * to find my height, i need to know height of my children, to which i will add
   * 1 so my children must return their height to me. Which means I need to return
   * my height to my parent. every node must return its height to its parent
   */

  static int find_height(Node root) {
    if (root == null)
      return 0;

    // no additional parameter for bottom up
    return dfs(root);
  }

  // common code for each node in the tree. each node return depth to parent
  private static int dfs(Node node) {

    // base case. at leaf level height is 0
    if (node.children == null)
      return 0;

    // for all intermediate level node  
    // initializing nodeHeight to zero and it will be updated with bottom up call from children
    int nodeHeight = 0;

    for (Node child : node.children) {

      // count subtree height under rooted under me
      int subTreeHeight = dfs(child);
      // count my height by adding my edge
      int myHeight = 1 + subTreeHeight;
      
      // compare with nodeHeight of other subtree rooted under me and if take the max
      nodeHeight = Math.max(nodeHeight, myHeight);

    }
    
    // return max height to parent
    return nodeHeight;
  }

}
