/**
 * 
 */
package com.pranav.code;

import java.util.Arrays;

/**
 * @author pranavpatel
 *
 */
public class QuickSort_old1 {

  private static void quickSort(int[] A, int startIndex, int endIndex) {

//    while (startIndex < endIndex) {
//      
//      int partionIndex = partition(A, startIndex, endIndex);
//      quickSort(A, startIndex, partionIndex - 1);
//      quickSort(A, partionIndex + 1, endIndex);
//    }

    int partionIndex = partition(A, startIndex, endIndex);
    if (partionIndex - 1 > startIndex) {
      quickSort(A, startIndex, partionIndex - 1);
    }
    if (partionIndex + 1 < endIndex) {
      quickSort(A, partionIndex + 1, endIndex);
    }

  }

  private static int partition(int[] A, int left, int right) {

    int pivot = A[right];
    int i = left;

    for (int j = left; j < right; j++) {

      if (A[j] <= pivot) {

        int swapTemp = A[i];
        A[i] = A[j];
        A[j] = swapTemp;
        i++;
      }

    }

    int swapTemp = A[i];
    A[i] = A[right];
    A[right] = swapTemp;

    return i;

  }

  public static void main(String[] args) {

    int[] nums = { 10, 7, 8, 9, 1, 5 };
    int startIndex = 0;
    int endIndex = nums.length - 1;

    quickSort(nums, startIndex, endIndex);

    System.out.println(Arrays.toString(nums));

  }

}
