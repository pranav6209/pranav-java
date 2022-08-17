/**
 * 
 */
package com.pranav.ik.A1Sorting;

import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 *
 * Quick select -- variation of a quick sort. where we only recurse on the one side based on our intresr index is known as a quick select
 *
 * @author pranavpatel
 *  After each iteration
 *  1. pivot index will take the correct place
 *  2. element left side of the pivots are smaller than pivot and elements bigger than pivot are on right side. But it will be in unsorted manner
 *  time :O(N) -- as only we are doing partial array not the full array
 *  space : O(1)
 *
 */
public class A8_C7_Kth_Largest_in_Array {

  public static int kth_largest_in_an_array(List<Integer> numbers, int k) {

    // n-k is the kth largest element n-1 is largest, n-2 is second largest, n-k is kth largest
    // for kth smallest index only change is index of interest is k-1 instead

    int n = numbers.size();
    helper(numbers, 0, n - 1, n - k);
    return (numbers.get(n - k)); // return number at the pivot index
  }

  private static void helper(List<Integer> arr, int start, int end, int index) {

    // leaf worker // base case
    if (start >= end)
      return;

    // https://www.baeldung.com/java-generating-random-numbers-in-range
    // end - start + 1 is length of an array and start is beginning of an array.
    // generate number between it

    Random rand = new Random();
    int pivot_index = rand.nextInt(end - start + 1) + start;

    // move pivot_index to beginning of the array.
    Collections.swap(arr, start, pivot_index);

    // orange region begin at start
    int orange = start;

    for (int green = start + 1; green <= end; green++) {

      // if green element is less that pivot which is sitting at start. swap it
      // if it is bigger no need to do anything it is a green pointer region
      
      
      // added || arr.get(green).equals(arr.get(start)) && green % 2==0 to avoid TLE on one of the Test case IK Has
      
      if (arr.get(green) < arr.get(start) || arr.get(green).equals(arr.get(start)) && green % 2==0) {
        // increment first as it is sitting at start
        orange++;
        Collections.swap(arr, orange, green);
      }

    }
    // finally move pivot to it correct position
    Collections.swap(arr, start, orange);
    
    // found the index of interest at orange
    if (index == orange)
      return;
    // if index of interest is less than orange, quick sort left array and ignore right. so here we are saving time to iterate on other side
    if (index < orange) {
      helper(arr, start, orange - 1, index);
    }
    // vice-versa ignore left and process right
    else {// index > orange
      helper(arr, orange + 1, end, index);
    }

  }
}
