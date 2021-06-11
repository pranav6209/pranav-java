/**
 * 
 */
package com.pranav.ik.A1Sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import com.pranav.ListNode;

/**
 * @author pranavpatel
 * 
 * preffer solution with heap. but look at the code for merging 2 linked list 
 *
 */
public class A9_Merge_K_Sorted_Singly_Linked_List {

  public static ListNode merge_k_lists_divide_conquer(List<ListNode> lists) {
    if (lists == null || lists.isEmpty()) {
      return null;
    }

    return mergeKLists(lists, 0, lists.size() - 1);

  }

  public static ListNode mergeKLists(List<ListNode> lists, int start, int end) {

    // base case -1 if start == end

    if (start == end) {
      return lists.get(start);
    }

    if (start > end)
      return null;

    int mid = start + (end - start) / 2;

    ListNode h1 = mergeKLists(lists, start, mid);
    ListNode h2 = mergeKLists(lists, mid + 1, end);
    return mergeSinglyLinkedListNode(h1, h2);
  }

  private static ListNode mergeSinglyLinkedListNode(ListNode l1, ListNode l2) {

    ListNode temp = new ListNode(-1);
    ListNode res = temp;

    while (l1 != null && l2 != null) {

      if (l1.value < l2.value) {
        temp.next = l1;
        l1 = l1.next;
      } else {
        temp.next = l2;
        l2 = l2.next;
      }
      temp = temp.next;
    }

    if (l1 != null)
      temp.next = l1;
    else
      temp.next = l2;

    return res.next;

  }

  // 
  public static ListNode merge_k_lists_heap(List<ListNode> lists) {

    if (lists.isEmpty())
      return null;

    // minHeap with listnode values
    PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>((n1, n2) -> n1.value - n2.value);

    // add all the list head into heap.(val and next-pointer to next node)
    for (int i = 0; i < lists.size(); i++) {
      minHeap.add(lists.get(i));
    }

    ListNode temp = new ListNode(-1);
    ListNode res = temp;

    while (!minHeap.isEmpty()) {

      ListNode node = minHeap.poll();
      temp.next = node;
      temp = temp.next;

      if (node.next != null)
        minHeap.add(node.next);

    }
    return res.next;
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

    /*
    ListNode res = merge_k_lists_divide_conquer(list);
   
    System.out.println("merge_k_lists_divide_conquer");
    while (res != null) {
      System.out.print(res.value + ",");
      
      res = res.next;
    }
    System.out.println();
    
    */
    ListNode res1 = merge_k_lists_heap(list);
    System.out.println("merge_k_lists_heap");
    while (res1 != null) {
      System.out.print(res1.value+",");
      res1 = res1.next;
    }

  }

}
