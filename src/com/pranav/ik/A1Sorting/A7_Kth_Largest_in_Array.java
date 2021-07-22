/**
 * 
 */
package com.pranav.ik.A1Sorting;

import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author pranavpatel
 * 
 * time :O(N) -- as only we are doing partial array not the full array
 * space : O(1)
 *
 */
public class A7_Kth_Largest_in_Array {

  public static int kth_largest_in_an_array(List<Integer> numbers, int k) {

    // n-k is the kth largest element n-1 is largest, n-2 is second largest, n-k is kth largest
    // only change for kth smallest index of interest is k-1 insted of n-k

    int n = numbers.size();
    helper(numbers, 0, n - 1, n - k);
    return (numbers.get(n - k));
  }

  private static void helper(List<Integer> arr, int start, int end, int index) {

    // leaf worker // base case
    if (start >= end)
      return;

    // https://www.baeldung.com/java-generating-random-numbers-in-range

    Random rand = new Random();
    int pivot_index = rand.nextInt(end - start + 1) + start;

    // move pivot_index to beginning of the array.
    Collections.swap(arr, start, pivot_index);

    // orange region begin at start
    int orange = start;

    for (int green = start + 1; green <= end; green++) {

      // if green element is less that pivot which is sitting at start. swap it
      // if it is bigger no need to do anything it is a green pointer region
      if (arr.get(green) < arr.get(start)) {
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
    // if index of interest is less than orange, quick sort left array and ignore right 
    if (index < orange) {
      helper(arr, start, orange - 1, index);
    }
    // vice-versa ignore left and process right
    else {// index > orange
      helper(arr, orange + 1, end, index);
    }

  }
}
