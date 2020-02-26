/**
 * 
 */
package com.pranav.ctci.linkedList;

/**
 * @author pranavpatel
 *
 *    important thing here is, 
 *    
 *    we do not have an access head or prev node, we just have an
 *    access to particular node we are deleting and after that as 
 *    node we are deleting have pointer to its next node.
 *
 *
 *         Explanation of Logic...
 *         https://www.youtube.com/watch?time_continue=25&v=Cay6RsoIG78
 * 
 *         Copied code
 * 
 *         http://algorithms.tutorialhorizon.com/delete-a-node-in-the-middle-of-a-linked-list-given-only-access-to-that-node/
 * 
 */
public class C_DeleteMiddleNode {

  static class node {

    int data;
    node next;

    public node(int val) {
      this.data = val;
    }

    // logic here is that we are updating mid with 
    // mid.next and then drop mid.next
    public static void deleteMiddle(node mid) {

     // store mid.next to temp 
      node temp = mid.next;
     // update mid.data with temp data
      mid.data = temp.data;
      // drop the temp node
      mid.next = temp.next;

    }

    public static void printLinkedList(node head) {

      while (head != null) {
        System.out.print(head.data + " ");
        head = head.next;
      }

    }
  }

  public static void main(String[] args) {

    node n = new node(1);
    n.next = new node(2);
    n.next.next = new node(3);
    node mid = new node(4);
    n.next.next.next = mid;
    n.next.next.next.next = new node(5);
    n.next.next.next.next.next = new node(6);
    n.next.next.next.next.next.next = new node(7);

  }

}
