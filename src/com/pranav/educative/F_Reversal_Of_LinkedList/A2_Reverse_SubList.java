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

public class A2_Reverse_SubList {

  public static ListNode reverseSubList(ListNode head, int p, int q) {
    if (head == null)
      return null;

    if (p == q)
      return head;

    ListNode previous = null;
    ListNode current = head;

    
    // after skipping 'p-1' nodes, current will point to 'p'th node
    for (int i = 0; current != null && i < p - 1; i++) {

      previous = current;
      current = current.next;
    }
    // we are interested in three parts of the LinkedList, part before index 'p', part between 'p' and 
    // 'q', and the part after index 'q'
    
    ListNode lastNodeOfFirstPart = previous; // // points to the node at index 'p-1'
    
    // after reversing the LinkedList 'current' will become the last node of the sub-list
    ListNode lastNodeOfSublist = current;

    // reverse node between p and q
    for (int i = 0; current != null && i < q - p + 1; i++) {

      ListNode next = current.next;
      current.next = previous;

      previous = current;
      current = next;

    }


    // connect with the first part
    if (lastNodeOfFirstPart != null)
      lastNodeOfFirstPart.next = previous; // 'previous' is now the first node of the sub-list
    else   // this means p == 1 i.e., we are changing the first node (head) of the LinkedList
      head = previous;

    
    // connect with the last part
    lastNodeOfSublist.next = current;

    return head;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);

    ListNode result = A2_Reverse_SubList.reverseSubList(head, 2, 4);
    System.out.print("Nodes of the reversed LinkedList are: ");
    while (result != null) {
      System.out.print(result.value + " ");
      result = result.next;
    }
  }
}
