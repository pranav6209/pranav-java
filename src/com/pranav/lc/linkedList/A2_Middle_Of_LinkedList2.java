/**
 * 
 */
package com.pranav.lc.linkedList;

/**
 * @author pranavpatel
 * 
 *         https://leetcode.com/problems/middle-of-the-linked-list/
 *
 */
public class A2_Middle_Of_LinkedList2 {

  
  //Definition of node class
  static class LinkedListNode {

    LinkedListNode next;
    int data;

    LinkedListNode(int val,LinkedListNode next) {

      this.data = val;
      this.next = next;

    }
   

  }

  public static void print(LinkedListNode head) {

    while (head != null) {
      System.out.println(head.data);
      head = head.next;

    }
  }

  /*
   * When traversing the list with a pointer slow, make another pointer fast that
   * traverses twice as fast. When fast reaches the end of the list, slow must be
   * in the middle.
   */

  public static LinkedListNode middledOfLinkedList_2(LinkedListNode head) {

    // head is null
    if(head == null)  return null;
    //  only one element
    if(head.next == null)  return head;
    // two elements // ask what to return ?
    if(head.next.next == null)  return head;


    // all other cases will be handled below
    LinkedListNode slow = head, fast = head;



    while (fast.next != null && fast.next.next != null) {

      slow = slow.next;
      // this might be null in last iteration but we should be OK as we are returning
      // slow

      fast = fast.next.next;

    }

    return slow;

  }

  public static void main(String[] args) {

    // 10->12->13->14->15->16
    // in this new node will replace the head.
    LinkedListNode head = new LinkedListNode(16,null);
    head= new LinkedListNode(15,head);
    head= new LinkedListNode(14,head);
    head= new LinkedListNode(13,head);
    head= new LinkedListNode(12,head);
    head= new LinkedListNode(10,head);

    System.out.println("Linked List");
    print(head);
    System.out.println("Middle: " + middledOfLinkedList_2(head).data);
  }

}
