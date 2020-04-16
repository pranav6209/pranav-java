/**
 * 
 */
package com.pranav.lc.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * @author pranavpatel
 * 
 *         make sure to understand tree before this.
 * 
 *         https://leetcode.com/problems/last-stone-weight/
 *         https://www.geeksforgeeks.org/priority-queue-class-in-java-2/
 *         https://www.youtube.com/watch?v=EuUBxM_E03E
 *
 */
public class A_Last_Stone_Weight {
  


  public static int lastStoneWeight(int[] stones) {
    
    // 0(logn) , space complexity 0(N) as we are creating a priority queue with n
    // stones
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    for (int item : stones)
      maxHeap.add(item);
    while (maxHeap.size() > 1) {
      // poll 0(logn) // add 0(logn) // peel O(1)
      int stone1 = maxHeap.poll();
      int stone2 = maxHeap.poll();
      if (stone1 != stone2)
        maxHeap.add(stone1 - stone2);
    }
    return maxHeap.isEmpty() ? 0 : maxHeap.poll();

  }

  public static void testQueue() {

    Stack<Integer> stack = new Stack<>();

    stack.peek();
    stack.push(1);
    stack.pop();
    stack.isEmpty();
    
    
    Queue<Integer> queue = new LinkedList<>();
    
    
    queue.add(5); 
    queue.remove();
    queue.peek();
    queue.isEmpty();
  }

  public static void main(String[] args) {

    int[] stones = { 2, 7, 4, 1, 8, 1 };
    System.out.println(lastStoneWeight(stones));

  }

}
