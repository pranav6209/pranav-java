/**
 * 
 */
package com.pranav.lc.stack;

import java.util.Stack;

/**
 * @author pranavpatel https://leetcode.com/problems/min-stack/
 *         https://leetcode.com/problems/min-stack/discuss/49010/Clean-6ms-Java-solution
 */
public class D_Min_Stack {

  // this variable keep tracks of current head
  ListNode head;

  // Definition of node class
  public static class ListNode {

    int val;
    int min;
    ListNode next;

    ListNode(int val, int min, ListNode next) {
      this.val = val;
      this.min = min;
      this.next = next;
    }

  }

  public void push(int x) {

    if (head == null)
      head = new ListNode(x, x, null);// means a first/last node, reference to next is null
    else
      head = new ListNode(x, Math.min(x, head.min), head);

  }

  public void pop() {
    // update the head

    if (head.next != null)
      head = head.next;
  }

  public int top() {
    return head.val;

  }

  public int getMin() {

    return head.min;
  }

  public static void main(String[] args) {

    D_Min_Stack min_Stack = new D_Min_Stack();

    min_Stack.push(-2);
    min_Stack.push(0);
    min_Stack.push(-3);
    System.out.println(min_Stack.getMin());
    min_Stack.pop();
    System.out.println(min_Stack.top());
    System.out.println(min_Stack.getMin());

  }
}
