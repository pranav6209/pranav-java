/**
 * 
 */
package com.pranav.ik.A1Sorting;

import java.util.ArrayList;
import java.util.List;

import com.pranav.ListNode;

/**
 * @author pranavpatel
 *
 */
public class A9_Merge_K_Sorted_Singly_Linked_List {

  public static ListNode merge_k_lists(List<ListNode> lists) {
    if (lists == null || lists.isEmpty()) {
      return null;
    }

    return mergeKLists(lists, 0, lists.size() - 1);

  }

  public static ListNode mergeKLists(List<ListNode> lists, int start, int end) {
    
    
    //base case -1 if start == end 
    
    if (start == end) {
      return lists.get(start);
    }
    
    if(start>end) return null;

    int mid = start + (end - start) / 2;

    ListNode h1 = mergeKLists(lists, start, mid);
    ListNode h2 = mergeKLists(lists, mid + 1, end);
    return mergeSinglyLinkedListNode(h1, h2);
  }

  private static ListNode mergeSinglyLinkedListNode(ListNode l1, ListNode l2) {

    ListNode res = new ListNode(-1);
    ListNode dummy = res;

    while (l1 != null && l2 != null) {

      if (l1.value < l2.value) {
        res.next = l1;
        l1 = l1.next;
      } else {
        res.next = l2;
        l2 = l2.next;
      }
      res = res.next;
    }

    if (l1 != null)
      res.next = l1;
    else
      res.next = l2;

    return dummy.next;

  }

  public static void main(String[] args) {
    ListNode l1 = new ListNode(1);
    l1.next = new ListNode(3);
    l1.next.next = new ListNode(5);

    ListNode l2 = new ListNode(3);
    l2.next = new ListNode(4);
    // l2.next.next = new ListNode(4);

    ListNode l3 = new ListNode(7);
    // l3.next = new ListNode(3);
    // l3.next.next = new ListNode(4);

    List<ListNode> list = new ArrayList<ListNode>();

    list.add(l1);
    list.add(l2);
    list.add(l3);

    ListNode res = merge_k_lists(list);

    while (res != null) {
      System.out.println(res.value);
      res = res.next;
    }

  }

}
