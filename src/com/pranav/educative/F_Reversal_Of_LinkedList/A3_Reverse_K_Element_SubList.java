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

public class A3_Reverse_K_Element_SubList {

  public static ListNode ReverseEveryKElements(ListNode head, int k) {

    if (head == null)
      return null;

    ListNode prev = null;
    ListNode current = head;

    while (current!=null) {

      ListNode lastNodeOfSubList = current;
      ListNode lastNodeOfPrevoisPart = prev;

      for (int i = 0; i < k && current != null; i++) {

        ListNode next = current.next;
        current.next = prev;

        prev = current;
        current = next;

      }

      if (lastNodeOfPrevoisPart != null) {

        lastNodeOfPrevoisPart.next = prev;

      } else {
        head = prev;
      }

      lastNodeOfSubList.next = current;
      
      prev = lastNodeOfSubList;

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

    ListNode result = A3_Reverse_K_Element_SubList.ReverseEveryKElements(head, 3);
    System.out.print("Nodes of the reversed LinkedList are: ");
    while (result != null) {
      System.out.print(result.value + " ");
      result = result.next;
    }
  }
}
