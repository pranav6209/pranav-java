/**
 * 
 */
package com.pranav.ik.A1Sorting;

import com.pranav.ListNode;

/**
 * @author pranavpatel
 * 
 * https://www.youtube.com/watch?v=mBUcaPvEawI&t=629s
 *
 */
public class S1_Merge_2_Sorted_Linked_List {

  public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

    if (l1 == null || l2 == null)
      return l1 != null ? l1 : l2;

    
    ListNode res = new ListNode(-1);
    ListNode dummy = res;
    
    // Referencing l1 and l2 to c1 and c2 so we do not update the head of the l1 and l2
    ListNode c1 = l1;
    ListNode c2 = l2;

    while (c1 != null && c2 != null) {

      if (c1.value < c2.value) {
        res.next = c1;
        c1 = c1.next;

      } else {
        res.next = c2;
        c2 = c2.next;
      }
      res = res.next;

    }
    
    // once we are out of the loop either c1 is still remaining or either c2 is remaining.
    // just point prev.next to remaining list.
    res.next = c1 != null ? c1 : c2;
    return dummy.next;
  }

  public static void main(String[] args) {

    ListNode l1 = new ListNode(1);
    l1.next = new ListNode(2);
    l1.next.next = new ListNode(4);

    ListNode l2 = new ListNode(1);
    l2.next = new ListNode(3);
    l2.next.next = new ListNode(4);

    ListNode res = mergeTwoLists(l1, l2);

    while (res != null) {
      System.out.println(res.value);
      res = res.next;

    }

  }

}
