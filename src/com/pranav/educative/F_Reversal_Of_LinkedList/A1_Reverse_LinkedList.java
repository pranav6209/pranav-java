/**
 * 
 */
package com.pranav.educative.F_Reversal_Of_LinkedList;

import com.pranav.educative.ListNode;

/**
 * @author pranavpatel
 * 
 * time : O(N)
 * space : O(1)
 *
 */


public class A1_Reverse_LinkedList {
  public static ListNode reverse(ListNode head) {

    ListNode prev = null;

    while (head != null) {
      // store the next element as it is linkage will be broken later we will not be
      // able to traverse
      ListNode next = head.next;
   // update current head linkage to be prev(at this point we can not, head.next will be updated. That is why,we are doing next = head.next above)
      head.next = prev;
   // update reference for prev and head for next iteration.
      prev = head;
      head = next;

    }
    //adjust the head or return prev
    //head = prev;
    return head;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(2);
    head.next = new ListNode(4);
    head.next.next = new ListNode(6);
    head.next.next.next = new ListNode(8);
    head.next.next.next.next = new ListNode(10);

    ListNode result = A1_Reverse_LinkedList.reverse(head);
    System.out.print("Nodes of the reversed LinkedList are: ");
    while (result != null) {
      System.out.print(result.value + " ");
      result = result.next;
    }
  }
}
