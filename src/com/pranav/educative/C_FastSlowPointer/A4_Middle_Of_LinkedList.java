/**
 * 
 */
package com.pranav.educative.C_FastSlowPointer;

import com.pranav.educative.ListNode;

/**
 * @author pranavpatel
 * 
 *         https://leetcode.com/problems/middle-of-the-linked-list/

 *         time : O(N) 
 *         space : O(1)
 *
 */
public class A4_Middle_Of_LinkedList {

  public static ListNode findMiddle(ListNode head) {

    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {

      fast = fast.next.next;
      slow = slow.next;

    }

    return slow;

  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    System.out.println("Middle Node: " + A4_Middle_Of_LinkedList.findMiddle(head).value);

    head.next.next.next.next.next = new ListNode(6);
    System.out.println("Middle Node: " + A4_Middle_Of_LinkedList.findMiddle(head).value);

    head.next.next.next.next.next.next = new ListNode(7);
    System.out.println("Middle Node: " + A4_Middle_Of_LinkedList.findMiddle(head).value);
  }

}
