/**
 * 
 */
package com.pranav.educative.C_FastSlowPointer;

import com.pranav.educative.ListNode;

/**
 * @author pranavpatel
 * 
 * https://www.youtube.com/watch?v=zbozWoMgKW0
 * https://leetcode.com/problems/linked-list-cycle/solution/
 * 
 *         time : O(N)
 *         space : O(1)
 *
 */
public class A1_LinkedListCycle {

  public static boolean hasCycle(ListNode head) {

    
    ListNode slow = head;
    ListNode fast = head;
    
    while (fast != null && fast.next != null) {

      fast = fast.next.next;
      slow = slow.next;

      if (fast == slow)
        return true;

    }

    // if we reach here means linked list doesn't have a cycle and we are at the end of list
    return false;
  }

  public static void main(String[] args) {

    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = new ListNode(6);
    System.out.println("LinkedList has cycle: " + A1_LinkedListCycle.hasCycle(head));

    head.next.next.next.next.next.next = head.next.next;
    System.out.println("LinkedList has cycle: " + A1_LinkedListCycle.hasCycle(head));

    head.next.next.next.next.next.next = head.next.next.next;
    System.out.println("LinkedList has cycle: " + A1_LinkedListCycle.hasCycle(head));

  }

}
