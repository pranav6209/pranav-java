/**
 * 
 */
package com.pranav.lc.linkedList;

/**
 * @author pranavpatel
 * 
 *         https://www.youtube.com/watch?v=zbozWoMgKW0
 *         https://leetcode.com/problems/linked-list-cycle-ii/submissions/
 */
public class D_Linked_List_Cycle_2 {

  static class ListNode {

    ListNode next;
    int data;

    ListNode(int value) {
      this.data = value;
    }

  }

  public static ListNode hasCycle(ListNode head) {

    ListNode slow = head, fast = head;

    while (fast != null && fast.next != null) {

      slow = slow.next;
      fast = fast.next.next;

      if (slow == fast)
        return slow;

    }

    return null;

  }

  public static ListNode detectCycle(ListNode head) {

    // at this point pt1 and pt2 will be at the same distance.
    ListNode pt1 = hasCycle(head);
    ListNode pt2 = head;

    while (pt1 != null) {

      if (pt1 == pt2)
        return pt1;
      pt1 = pt1.next;
      pt2 = pt2.next;
    }

    return null;
  }

  public static void printList(ListNode head) {
    while (head != null) {
      System.out.println(head.data);
      head = head.next;
    }

  }

  // can't create circular linked list using this. just run main code in to
  // console of leet
  public static void main(String[] args) {

    ListNode node = new ListNode(3);
    node.next = new ListNode(2);
    node.next.next = new ListNode(0);
    node.next.next.next = new ListNode(-4);
    node.next.next.next.next = node.next;
    printList(node);
    System.out.println(hasCycle(node));
  }

}
