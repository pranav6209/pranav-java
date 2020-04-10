/**
 * 
 */
package com.pranav.code;

import java.util.LinkedList;

/**
 * @author pranavpatel
 *
 */
public class F_LinkedList {
  LinkedListNode head;
  
  class LinkedListNode {
    LinkedListNode next;
    int data;
    
    LinkedListNode(int val) {
      this.data = val;
    }
  }
  
  public void addNode(int data) {
    
    LinkedListNode newNode = new LinkedListNode(data);
    if(this.head== null) this.head = newNode;
    
    else {
      
      // adding node at start 
      newNode.next= head;
      // new node is head now
      head= newNode;
      
    }
    
  }
  
  
  public void print() {
    
    LinkedListNode n = this.head;
    
    while(n!=null) {
      System.out.println(n.data);
      n=n.next; //i++
      
    }
  }
  
  
  public static void main(String[] args) {
    F_LinkedList ll = new F_LinkedList();
    ll.addNode(10);
    ll.addNode(11);
    ll.addNode(12);
    ll.addNode(13);
    ll.addNode(14);
    ll.print();
    
  }
  

}
