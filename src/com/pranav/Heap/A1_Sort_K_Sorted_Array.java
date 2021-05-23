/**
 * 
 */
package com.pranav.Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author pranavpatel
 *
 */
public class A1_Sort_K_Sorted_Array {

  public static int[] sortKSortedArray(int[] nums, int k) {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    int[] res = new int[nums.length];
    int j = 0;

    for (int i = 0; i < nums.length; i++) {
      minHeap.add(nums[i]);

      if (minHeap.size() > k) {
        res[j] = minHeap.poll();
        j++;
      }
    }

    while (!minHeap.isEmpty()) {
      res[j] = minHeap.poll();
      j++;
    }

    return res;

  }

  public static void main(String[] args) {
    int[] nums = { 2, 6, 3, 12, 56, 8 };
    int k = 3;

    System.out.println(Arrays.toString(sortKSortedArray(nums, k)));

  }

}
