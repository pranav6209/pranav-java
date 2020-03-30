/**
 * 
 */
package com.pranav.lc.linkedList;


/**
 * @author pranavpatel
 * 
 * https://leetcode.com/problems/middle-of-the-linked-list/
 *
 */
public class B_Reverse_LinkedList {

  LinkedListNode head;
  static class LinkedListNode {

    
    LinkedListNode next;
    int data;

    LinkedListNode(int val) {

      this.data = val;

    }

  }
  
  
  public static LinkedListNode reverseLinkedList(LinkedListNode head) {
    
    LinkedListNode prev = null;
    LinkedListNode curr = head;
    while (curr != null) {
      LinkedListNode nextTemp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = nextTemp;
    }
    return prev;
  }
 
  public static void print(LinkedListNode head) {
   
    
    while(head!=null) {
      System.out.println(head.data);
      head=head.next;
      
    }
  }
  
  
  public static void main(String[] args) {
    
    //10->12->13->14->15
    LinkedListNode n = new LinkedListNode(10);
    n.next= new LinkedListNode(12);
    n.next.next= new LinkedListNode(13);
    n.next.next.next= new LinkedListNode(14);
    n.next.next.next.next= new LinkedListNode(15);
    n.next.next.next.next.next= new LinkedListNode(16);
    
    System.out.println("Linked List");
    print(n);
    System.out.println("Reversed Linked List");
    print(reverseLinkedList(n));
    
    
    
  }
  
  
}
