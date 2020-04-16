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
public class A1_Middle_Of_LinkedList {

  
  
  //Definition of node class
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

  public static LinkedListNode middledOfLinkedList_1(LinkedListNode head) {
    
    //The number of nodes in the given list will be between 1 and 100. given
    LinkedListNode [] A = new LinkedListNode[100];
    int i=0;
    
    while(head!=null) {
      
      A[i++] =head;
      head = head.next;
    }
    
    return A[i/2];
    
  }
  
  
  /*
   * When traversing the list with a pointer slow, make another pointer fast that traverses twice as fast. 
   * When fast reaches the end of the list, slow must be in the middle.
   */
  
  public static LinkedListNode middledOfLinkedList_2(LinkedListNode head) {
    
    LinkedListNode slow=head,fast=head;
   
    
    while(fast!=null && fast.next!=null) {
      
      slow= slow.next;
      // this might be null in last iteration but we should be OK as we are returning slow
      
      fast= fast.next.next;
      
    }
    
    return slow;
       
  }
  
  public static LinkedListNode middledOfLinkedList_3(LinkedListNode head) {
    
    //length 1
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
    
    //10->12->13->14->15->16
    
    // in this first node will stay as head and new node will be next of head check A2 
    LinkedListNode n = new LinkedListNode(10);
    n.next= new LinkedListNode(12);
    n.next.next= new LinkedListNode(13);
    n.next.next.next= new LinkedListNode(14);
    n.next.next.next.next= new LinkedListNode(15);
    n.next.next.next.next.next= new LinkedListNode(16);
    
    System.out.println("Linked List");
    print(n);
    
    System.out.println("Middle: "+middledOfLinkedList_1(n).data);
    System.out.println("Middle: "+middledOfLinkedList_2(n).data);
    System.out.println("Middle: "+middledOfLinkedList_3(n).data);
    
    
  }
  
  
}
