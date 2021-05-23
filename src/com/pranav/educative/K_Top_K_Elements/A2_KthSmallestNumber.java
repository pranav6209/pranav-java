
/**
 * 
 */
package com.pranav.educative.K_Top_K_Elements;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author pranavpatel
 * 
 *         https://www.youtube.com/watch?v=4BfL2Hjvh8g&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=3&ab_channel=AdityaVerma
 *
 */
public class A2_KthSmallestNumber {
  public static int findKthSmallestNumber1(int[] nums, int k) {

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((n1, n2) -> n2 - n1);

    for (int i = 0; i < k; i++) {

      maxHeap.add(nums[i]);
    }

    for (int i = k; i < nums.length; i++) {
      if (nums[i] < maxHeap.peek()) {
        maxHeap.poll();
        maxHeap.add(nums[i]);
      }

    }
    return maxHeap.peek();
  }
  
  /*
  Time complexity #
  The time complexity of this algorithm is O(K*logK+(N-K)*logK)O(K∗logK+(N−K)∗logK), which is asymptotically equal to O(N*logK)O(N∗logK)

  Space complexity #
  The space complexity will be O(K)O(K) because we need to store ‘K’ smallest numbers in the heap.
  
  */
  public static int findKthSmallestNumber2(int[] nums, int k) {

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

    for (int i = 0; i < nums.length; i++) {

      maxHeap.add(nums[i]);

      if (maxHeap.size() > k) {
        maxHeap.poll();
      }

    }
    return maxHeap.peek();
  }

  public static void main(String[] args) {
    int result = A2_KthSmallestNumber.findKthSmallestNumber2(new int[] { 1, 5, 12, 2, 11, 5 }, 3);
    System.out.println("Kth smallest number is: " + result);

    // since there are two 5s in the input array, our 3rd and 4th smallest numbers
    // should be a '5'
    result = A2_KthSmallestNumber.findKthSmallestNumber2(new int[] { 1, 5, 12, 2, 11, 5 }, 4);
    System.out.println("Kth smallest number is: " + result);

    result = A2_KthSmallestNumber.findKthSmallestNumber2(new int[] { 5, 12, 11, -1, 12 }, 3);
    System.out.println("Kth smallest number is: " + result);
  }

}
