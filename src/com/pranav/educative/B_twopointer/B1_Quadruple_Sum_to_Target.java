/**
 * 
 */
package com.pranav.educative.B_twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author pranavpatel
 *
 */
public class B1_Quadruple_Sum_to_Target {

  public static List<List<Integer>> searchQuadruplets(int[] arr, int target) {

    Arrays.sort(arr);
    List<List<Integer>> quadruplets = new ArrayList<>();
    int i;
    int j = 0;

    for (i = 0; i < arr.length - 3; i++) {

      if (i > 0 && arr[i] == arr[i - 1])
        continue;

      for (j = i + 1; j < arr.length - 2; j++) {
        if (j > i + 1 && arr[j] == arr[j - 1])
          continue;

        int left = j + 1;
        int right = arr.length - 1;

        while (left < right) {

          int sum = arr[i] + arr[j] + arr[right] + arr[left];

          if (sum == target) {

            quadruplets.add(Arrays.asList(arr[i], arr[j], arr[left], arr[right]));

            left++;
            right--;

            while (left < right && arr[left] == arr[left - 1]) {
              left++;
            }

            while (left < right && arr[right] == arr[right + 1]) {
              right--;
            }

          }

          if (sum < target)
            left++;
          else
            right--;

        }
      }
    }
    return quadruplets;
  }

  public static void main(String[] args) {
    System.out.println(B1_Quadruple_Sum_to_Target.searchQuadruplets(new int[] { 4, 1, 2, -1, 1, -3 }, 1));
    System.out.println(B1_Quadruple_Sum_to_Target.searchQuadruplets(new int[] { 2, 0, -1, 1, -2, 2 }, 2));
  }

}
