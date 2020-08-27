/**
 * 
 */
package com.pranav.educative.B_twopointer;

import java.util.Arrays;

/**
 * @author pranavpatel
 * 
 * time : O(N)
 * space : O(1)
 *
 *  https://leetcode.com/problems/sort-colors/submissions/
 *
 */
public class A9_Dutch_National_Flag_Problem {
  public static void sort(int[] arr) {

    
    // all elements < low are 0 and all elements > high are 2
    // in between all elements are 1
    
    int low = 0;
    int high = arr.length - 1;
    int i = 0;

    // <= as high is index and not a length
    while (i <= high) {

      // if element is 0, we need to put it where low is(swap) and then increase the low and i
      if (arr[i] == 0) {

        // if 0 is the first element i and low is same so 0 will stay as it is 
        swap(arr, i, low);
        i++;
        low++;

      }

      // if we have one we are not swapping keeping between low and high
      else if (arr[i] == 1) {

        i++;

      } else { // if here element is 2 as array has only 0,1,2. swap it with high as we want to keep all 2s after high
        swap(arr, i, high);
     // decrement 'high' only, after the swap the number at index 'i' could be 0, 1 or 2
        high--;
      }

    }

  }

  // j is either low or high
  static void swap(int[] arr, int i, int j) {

    int temp = arr[j];
    arr[j] = arr[i];
    arr[i] = temp;

  }

  public static void main(String[] args) {

    int[] arr = new int[] { 1, 0, 2, 1, 0 };

    sort(arr);

    System.out.println(Arrays.toString(arr));

  }
}
