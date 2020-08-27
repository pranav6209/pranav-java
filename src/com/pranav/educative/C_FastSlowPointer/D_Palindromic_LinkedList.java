/**
 * 
 */
package com.pranav.educative.C_FastSlowPointer;

import com.pranav.educative.ListNode;

/**
 * @author pranavpatel
 * 
 * 
 *          https://www.youtube.com/watch?v=sYcOK51hl-A
 *
 *         https://leetcode.com/problems/palindrome-linked-list/
 * 
 * 
 *         https://leetcode.com/problems/reverse-linked-list/
 * 
 * 
 *
 *         time : O(N) space : O(1)
 */
public class D_Palindromic_LinkedList {
  public static boolean isPalindrome(ListNode head) {

    if (head == null || head.next == null)
      return true;

    // find middle

    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {

      slow = slow.next;
      fast = fast.next.next;

    }

    System.out.println("middle" + slow.value);

    ListNode headSecondHalf = reverse(slow); // reverse second half
    ListNode copyHeadSecondHalf = headSecondHalf; // store head of second half so we can reverse it back

    while (head != null && headSecondHalf != null) {

      if (head.value != headSecondHalf.value)
        break; // not a palindrome

      head = head.next;
      headSecondHalf = headSecondHalf.next;

    }

    reverse(copyHeadSecondHalf); // revert the reverse of the second half

    if (head == null || headSecondHalf == null)
      return true;

    return false;

  }

  private static ListNode reverse(ListNode head) {

    ListNode prev = null;

    while (head != null) {

      // store the next element as it is linkage will be broken later we will not be
      // able to traverse

      ListNode next = head.next;
      
      // update current head linkage to be prev(at this point we can not, head.next will be updated. That is why,we are doing next = head.next above)
      head.next = prev;
      
      // update reference for prev and head for next iteration.
      prev = head;
      head = next;

    }

    //adjust the head or return prev
    // head = prev;
    return prev;

  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(1);
    System.out.println("Is palindrome: " + D_Palindromic_LinkedList.isPalindrome(head));

    head.next.next = new ListNode(6);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(2);
    System.out.println("Is palindrome: " + D_Palindromic_LinkedList.isPalindrome(head));

    head.next.next.next.next.next = new ListNode(2);
    System.out.println("Is palindrome: " + D_Palindromic_LinkedList.isPalindrome(head));
  }
}
