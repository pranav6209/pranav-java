/**
 * 
 */
package com.pranav.educative.F_Reversal_Of_LinkedList;

import com.pranav.educative.ListNode;

/**
 * @author pranavpatel
 * 
 *         time : O(N) space : O(1)
 *
 */

public class A4_Reverse_AlternatingK_element_SubList {

  public static ListNode ReverseEveryKElements(ListNode head, int k) {

    if (head == null)
      return null;

    ListNode previous = null;
    ListNode current = head;

    while (current != null) {

      ListNode lastNodeOfPreviousSublist = previous;
      ListNode lastNodeOfCurrentSublist = current;// after reversing

      for (int i = 0; i < k && current != null; i++) {

        ListNode next = current.next;
        current.next = previous;
        previous = current;
        current = next;
      }

      if (lastNodeOfPreviousSublist != null) {
        lastNodeOfPreviousSublist.next = previous;
      } else {

        head = previous;
      }

      lastNodeOfCurrentSublist.next = current;

      previous = lastNodeOfCurrentSublist;

      for (int i = 0; i < k && current != null; i++) {

        current = current.next;
        previous = previous.next;

      }

    }

    return head;

  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = new ListNode(6);
    head.next.next.next.next.next.next = new ListNode(7);
    head.next.next.next.next.next.next.next = new ListNode(8);

    ListNode result = A4_Reverse_AlternatingK_element_SubList.ReverseEveryKElements(head, 3);
    System.out.print("Nodes of the reversed LinkedList are: ");
    while (result != null) {
      System.out.print(result.value + " ");
      result = result.next;
    }
  }
}
