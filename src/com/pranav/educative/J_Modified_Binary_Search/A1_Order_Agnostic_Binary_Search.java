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
public class A1_Order_Agnostic_Binary_Search {
  public static int search(int[] arr, int target) {

    int start = 0;
    int end = arr.length - 1;

    boolean isAsc = arr[start] < arr[end];

    while (start <= end) {

      int mid = start + (end - start) / 2;
      if (target == arr[mid])
        return mid;
      if (isAsc) {
        if (target > arr[mid])
          start = mid + 1;
        else
          end = mid - 1;
      } else {
        /* if array is in descending order, and key is greater than middle, key will be
         on left side unlike ascending. { 10, 6, 4 }, 10. here 10 is likely to be left
         side.*/
        if (target > arr[mid])
          end = mid - 1;
        else
          start = mid + 1;
      }

    }
    return -1;
  }

  public static void main(String[] args) {
    System.out.println(A1_Order_Agnostic_Binary_Search.search(new int[] { 4, 6, 10 }, 10));
    System.out.println(A1_Order_Agnostic_Binary_Search.search(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 5));
    System.out.println(A1_Order_Agnostic_Binary_Search.search(new int[] { 10, 6, 4 }, 10));
    System.out.println(A1_Order_Agnostic_Binary_Search.search(new int[] { 10, 6, 4 }, 4));
  }
}
