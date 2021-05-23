/**
 * 
 */
package com.pranav.code;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author pranavpatel
 *
 */
public class L_Stack_Queue {
  public static void testQueue() {

    Stack<Integer> stack = new Stack<>();

    stack.push(1);
    stack.peek();
    stack.pop();
    stack.isEmpty();

    Queue<Integer> queue = new LinkedList<>();

    queue.add(5);
    queue.peek();
    queue.remove();
    queue.isEmpty();
  }
}
