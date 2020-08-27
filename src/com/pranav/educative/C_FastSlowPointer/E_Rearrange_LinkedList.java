/**
 * 
 */
package com.pranav.educative.C_FastSlowPointer;

import com.pranav.educative.ListNode;

/**
 * @author pranavpatel
 * 
 *         time : O(N) space : O(1)
 *         
 *         https://leetcode.com/problems/reorder-list/
 */
public class E_Rearrange_LinkedList {
  public static void reorder(ListNode head) {

    if (head == null || head.next == null)
      return;

    // find middle

    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {

      slow = slow.next;
      fast = fast.next.next;

    }

    System.out.println("middle:- " + slow.value);

    ListNode headSecondHalf = reverse(slow); // reverse second half
    ListNode headFirstHalf = head;

    while (headFirstHalf != null && headSecondHalf != null) {

      ListNode temp = headFirstHalf.next;

      headFirstHalf.next = headSecondHalf;

      headFirstHalf = temp;

      temp = headSecondHalf.next;

      headSecondHalf.next = headFirstHalf;

      headSecondHalf = temp;

    }

    if (headFirstHalf != null) {
      headFirstHalf.next = null;
    }

  }

  private static ListNode reverse(ListNode head) {

    ListNode prev = null;

    while (head != null) {

      // store the next element as it is linkage will be broken later we will not be
      // able to traverse

      ListNode next = head.next;
      head.next = prev;
      prev = head;
      head = next;

    }

    return prev;

  }

  public static void main(String[] args) {
    ListNode head = new ListNode(2);
    head.next = new ListNode(4);
    head.next.next = new ListNode(6);
    head.next.next.next = new ListNode(8);
    head.next.next.next.next = new ListNode(10);
    head.next.next.next.next.next = new ListNode(12);
    E_Rearrange_LinkedList.reorder(head);
    while (head != null) {
      System.out.print(head.value + " ");
      head = head.next;
    }
  }
}
