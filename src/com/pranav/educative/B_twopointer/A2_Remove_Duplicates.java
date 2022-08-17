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

    int slow = 0;
    for (int fast = 1; fast < arr.length; fast++) {

      int value1 = arr[slow];
      int value2 = arr[fast];

//      goal here is to move non-duplicate number to front and doesn't matter what we left behind
//      so no need to swap i and j just. just assign value of j to i.in case we have to return array we need to swap
//       we have to do it when both values are different

      if (value1 != value2) {
        // make sure to first increment and then assign the value
        slow++;
        arr[slow] = arr[fast];

      }
    }

    return slow + 1;
  }

  public static void main(String[] args) {

    System.out.println(remove(new int[] { 2, 3, 3, 3, 6, 9, 9 }));
    System.out.println(remove(new int[] { 2, 2, 2, 11 }));

  }
}
