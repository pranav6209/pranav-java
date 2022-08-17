/**
 * 
 */
package com.pranav.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author pranavpatel
 * explanation in Omkar live class 5:20:00 orginal explanation start ard 5:45:00
 * 
 * time O(long)
 * space O(1)=
 *
 *
 *
 */
public class D_QuickSort {

  public static List<Integer> quickSort(List<Integer> arr) {

    helper(arr, 0, arr.size() - 1);
    return arr;

  }

  
  // consider sub problem for any internal worker.
  // it will get arr,start and end index to work on
  private static void helper(List<Integer> arr, int start, int end) {
    
    // leaf worker // base case
    if(start>=end) return;
    
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
    helper(arr, start, orange - 1); // recurse on left side of the pivot
    helper(arr, orange + 1, end); // recurse on right side of the pivot
  }

  public static void main(String[] args) {

    List<Integer> list = new ArrayList<>();

    list.add(4);
    list.add(5);
    list.add(1);
    list.add(2);
    list.add(3);

    System.out.println(quickSort(list));
  }

}
