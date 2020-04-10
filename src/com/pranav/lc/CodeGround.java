/**
 * 
 */
package com.pranav.lc;

/**
 * @author pranavpatel
 *
 */
public class CodeGround {

  static class LinkedListNode {

    LinkedListNode next;
    int data;

    LinkedListNode(int value) {

      this.data = value;
    }

  }

  static void printLinkedList(LinkedListNode head) {

    while (head != null) {
      System.out.println(head.data);
      head = head.next;
    }

  }

  public static LinkedListNode findMiddleNode(LinkedListNode node) {

    LinkedListNode slow = node;
    LinkedListNode fast = node;

    while (fast != null && fast.next != null) {

      slow = slow.next;
      fast = fast.next.next;

    }

    return slow;
  }

  public static void main(String[] args) {

    LinkedListNode node = new LinkedListNode(10);
    node.next = new LinkedListNode(12);
    node.next.next = new LinkedListNode(13);
    node.next.next.next = new LinkedListNode(14);
    node.next.next.next.next = new LinkedListNode(15);
    node.next.next.next.next.next = new LinkedListNode(16);

    //printLinkedList(node);

    System.out.println(findMiddleNode(node).data);

  }

}
