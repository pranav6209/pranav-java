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
public class A_Middle_Of_LinkedList {

  LinkedListNode head;
  static class LinkedListNode {

    
    LinkedListNode next;
    int data;

    LinkedListNode(int val) {

      this.data = val;

    }

  }
 
  public static void print(LinkedListNode head) {
   
    
    while(head!=null) {
      System.out.println(head.data);
      head=head.next;
      
    }
  }
  
 /*
  * Put every node into an array A in order. Then the middle node is just A[A.length // 2], 
  * since we can retrieve each node by index.
  * 
  */

  public LinkedListNode middledOfLinkedList_1(LinkedListNode head) {
    
    //The number of nodes in the given list will be between 1 and 100. given
    LinkedListNode [] A = new LinkedListNode[100];
    int i=0;
    
    while(head.next!=null) {
      
      A[i++] =head;
      head = head.next;
    }
    
    return A[i/2];
    
  }
  
  
  /*
   * When traversing the list with a pointer slow, make another pointer fast that traverses twice as fast. 
   * When fast reaches the end of the list, slow must be in the middle.
   */
  
  public LinkedListNode middledOfLinkedList_2(LinkedListNode head) {
    
    LinkedListNode slow=head,fast=head;
   
    
    while(fast!=null && fast.next!=null) {
      
      slow= slow.next;
      fast= fast.next.next;
      
    }
    
    return slow;
       
  }
  
  public static LinkedListNode middledOfLinkedList_3(LinkedListNode head) {
    
    int length=1;
    
    LinkedListNode current = head;
      
    while(current.next!=null) {
      
      current = current.next;
      length++;
      
    }
    
    int middle = length/2;
    
    current = head;
    
    int i=0;
    
    while(i<middle){
      
      current = current.next;
      i++;
      
    }
    
    return current;
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
    
    System.out.println("Middle: "+middledOfLinkedList(n).data);
    
    
  }
  
  
}