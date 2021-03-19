/**
 * 
 */
package com.pranav.educative.J_Modified_Binary_Search;

/**
 * @author pranavpatel
 * 
 *         Time : O(logN) Space : O(1)
 * 
 *         https://leetcode.com/problems/binary-search/submissions/
 *
 */
public class A3_Floor_Of_Number {
  public static int searchCFloorOfANumber(int[] arr, int target) {

    int start = 0;
    int end = arr.length - 1;

    if (target < arr[0])
      return -1;

    while (start <= end) {

      int mid = start + (end - start) / 2;

      if (target == arr[mid])
        return mid;

      else if (target > arr[mid])
        start = mid + 1;

      else
        end = mid - 1;
    }
    return start;
  }

  public static void main(String[] args) {
    System.out.println(A3_Floor_Of_Number.searchCFloorOfANumber(new int[] { 4, 6, 10 }, 6));
    System.out.println(A3_Floor_Of_Number.searchCFloorOfANumber(new int[] { 1, 3, 8, 10, 15 }, 12));
    System.out.println(A3_Floor_Of_Number.searchCFloorOfANumber(new int[] { 4, 6, 10 }, 17));
    System.out.println(A3_Floor_Of_Number.searchCFloorOfANumber(new int[] { 4, 6, 10 }, -1));
  }
}
