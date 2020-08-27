/**
 * 
 */
package com.pranav.educative.B_twopointer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pranavpatel
 * 
 *         https://leetcode.com/problems/remove-duplicates-from-sorted-array
 * 
 *         time : O(N) space : O(1)
 */
public class A2_Remove_Duplicates {

  public static int remove(int[] arr) {

    if (arr == null || arr.length == 0)
      return 0;

    int i = 0;
    for (int j = 1; j < arr.length; j++) {

      int value1 = arr[i];
      int value2 = arr[j];

      // goal here is to move non duplicate number to front and doen't matter what we
      // left behind
      // so no need to swap i and j just. just assign value of j to i.
      // we have to do it when both values are different
      if (value1 != value2) {
        // make sure to first increment and then assign the value
        i++;
        arr[i] = arr[j];

      }
    }

    return i + 1;
  }

  public static void main(String[] args) {

    System.out.println(remove(new int[] { 2, 3, 3, 3, 6, 9, 9 }));
    System.out.println(remove(new int[] { 2, 2, 2, 11 }));

  }
}
