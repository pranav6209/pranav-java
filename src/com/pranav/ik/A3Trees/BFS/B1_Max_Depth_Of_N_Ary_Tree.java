/**
 * 
 */
package com.pranav.ik.A3Trees.BFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author pranavpatel
 *
 *         same time/space complexity as A1
 *
 */
public class B1_Max_Depth_Of_N_Ary_Tree {

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

  // return the farthest child from root
  public int maxDepth(Node root) {

    int depth = 0;

    if (root == null)
      return depth;

    Queue<Node> queue = new LinkedList<Node>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      // as soon as we encounter node we have to increase the counter
      depth++;
      
      int levelSize = queue.size();

      for (int i = 0; i < levelSize; i++) {

        Node currentNode = queue.poll();

        for (Node child : currentNode.children) {
          queue.offer(child);
        }
      }
    }
    return depth;
  }

}
