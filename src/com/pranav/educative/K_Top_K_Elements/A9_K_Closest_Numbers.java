/**
 * 
 */
package com.pranav.educative.K_Top_K_Elements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author pranavpatel
 * 
 * https://www.youtube.com/watch?v=J8yLD-x7fBI&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=5
 * https://www.educative.io/courses/grokking-the-coding-interview/N8MJQNYyJPL
 * 
 * https://leetcode.com/problems/find-k-closest-elements/
 * 
 * problem with leetcode is this condition  
 * 
 * |a - x| < |b - x|, or
 * |a - x| == |b - x| and a < b not sure how to initialize priority queue using this 
 * conditions 
 *
 */

class Entry {
  int key;
  int value;

  public Entry(int key, int value) {
    this.key = key;
    this.value = value;
  }
}


public class A9_K_Closest_Numbers {
  public static List<Integer> findClosestElements(int[] arr, int K, int X) {
    
    List<Integer> result = new ArrayList<>();
    
    // search for an element if that is present
    int index = binarySearch(arr, X);
    
    // element will be present between low and high
    int low = index - K;
    int high = index + K;

    // if the low is negative adjust, if max is out of bound adjust
    low = Math.max(low, 0);
    high = Math.min(high, arr.length - 1);

    PriorityQueue<Entry> maxHeap = new PriorityQueue<Entry>((n1, n2) -> n2.key - n1.key);

    //
    for (int i = low; i <= high; i++) {
      maxHeap.add(new Entry(Math.abs(arr[i] - X), arr[i]));

      if (maxHeap.size() > K) {
        maxHeap.poll();
      }

    }
    while (!maxHeap.isEmpty()) {
      result.add(maxHeap.poll().value);

    }
    Collections.sort(result);
    return result;

  }

  private static int binarySearch(int[] arr, int target) {

    int low = 0;
    int high = arr.length - 1;
    while (low <= high) {

      int mid = low + high - low / 2;

      if (target == arr[mid]) {
        return mid;
      } else if (target > arr[mid]) {
        low = mid + 1;
      } else
        high = mid - 1;

    }
    // if the element is not present return the low index instead of -1
    return low;
  }

  public static void main(String[] args) {
    List<Integer> result = A9_K_Closest_Numbers.findClosestElements(new int[] { 5, 6, 7, 8, 9 }, 3, 7);
    System.out.println("'K' closest numbers to 'X' are: " + result);

    result = A9_K_Closest_Numbers.findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 6);
    System.out.println("'K' closest numbers to 'X' are: " + result);

    result = A9_K_Closest_Numbers.findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 10);
    System.out.println("'K' closest numbers to 'X' are: " + result);

  }
}
