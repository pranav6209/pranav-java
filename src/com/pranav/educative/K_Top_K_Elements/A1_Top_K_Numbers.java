/**
 * 
 */
package com.pranav.educative.K_Top_K_Elements;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author pranavpatel
 *
 */
public class A1_Top_K_Numbers {

  public static List<Integer> findKLargestNumbers(int[] nums, int k) {

    // creates a PQ keeping root at min.
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);
    //PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(Comparator.naturalOrder());

    for (int i = 0; i < k; i++) {

      minHeap.add(nums[i]);
    }

    for (int i = k; i < nums.length; i++) {

      if (nums[i] > minHeap.peek()) {

        minHeap.poll();
        minHeap.add(nums[i]);

      }

    }

    return new ArrayList<>(minHeap);
  }

  public static void main(String[] args) {
    List<Integer> result = A1_Top_K_Numbers.findKLargestNumbers(new int[] { 3, 1, 5, 12, 2, 11 }, 3);
    System.out.println("Here are the top K numbers: " + result);

    result = A1_Top_K_Numbers.findKLargestNumbers(new int[] { 5, 12, 11, -1, 12 }, 3);
    System.out.println("Here are the top K numbers: " + result);
  }

}
