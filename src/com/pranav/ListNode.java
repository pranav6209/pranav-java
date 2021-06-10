/**
 * 
 */
package com.pranav;

/**
 * @author pranavpatel
 *
 */
public class ListNode {

  public int value;
  public ListNode next;

  public ListNode(int value) {

    this.value = value;

  }

  public static void print(ListNode head) {

    while (head != null) {
      System.out.println(head.value);
      head = head.next;

    }
  }
}
