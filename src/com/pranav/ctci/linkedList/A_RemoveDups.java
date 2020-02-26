/**
 * 
 */
package com.pranav.ctci.linkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * @author pranavpatel
 *
 */
public class A_RemoveDups {

  // static node class
  static class node {

    int data;
    // pointer to next node
    node next;

    // constructor
    public node(int val) {
      this.data = val;
    }

  }

  public static void removeDups(node n) {

    Set<Integer> set = new HashSet<>();

    node prev = null;

    while (n != null) {
      if (set.contains(n.data))
        prev.next = n.next;
      else {
        set.add(n.data);
        prev = n;
      }
      n = n.next;
    }

  }

  public static void printList(node head) {
    while (head != null) {
      System.out.print(head.data + " ");
      head = head.next;
    }
  }

  // n = 10 -> 12 -> 11 -> 12
  public static void main(String[] args) {

    node n = new node(10);
    n.next = new node(12);
    n.next.next = new node(11);
    n.next.next.next = new node(12);

    System.out.println("Before");
    printList(n);

    removeDups(n);

    System.out.println("\nAfter");
    printList(n);

  }

}
