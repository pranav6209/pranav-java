/**
 * 
 */
package com.pranav.ik.A1Sorting;

import com.pranav.educative.B_twopointer.A4_Squaring_Sorted_Array;

/**
 * @author pranavpatel
 *
 */
public class PP5_Squares_Of_Sorted_Array {

  public static int[] sortedSquares(int[] A) {

    int[] newArray = new int[A.length];

    // get the index of negative number. iterate array till the array is
    // negative

    int i = 0;
    while (i < A.length && A[i] < 0)
      i++;

    /*
     * for (i = 0; i < A.length; i++) { if (A[i] >=0) break; }
     */

    int j = i - 1;

    System.out.println("index for negative no: " + j);

    int t = 0;

    // better to use while as initial value of i and j is already defined up above
    // approach for merge sort
    while (i < A.length && j >= 0) {

      // put the smaller one in new array

      if (A[j] * A[j] < A[i] * A[i]) {

        newArray[t] = A[j] * A[j];
        j--;
        t++;

      }

      else {

        newArray[t] = A[i] * A[i];
        i++;
        t++;

      }
    }

    while (j >= 0) {
      newArray[t++] = A[j] * A[j];
      j--;
    }
    while (i < A.length) {
      newArray[t++] = A[i] * A[i];
      i++;
    }

    return newArray;

  }

  public static void main(String[] args) {

    int[] result = PP5_Squares_Of_Sorted_Array.sortedSquares(new int[] { -2, -1, 0, 2, 3 });
    for (int num : result)
      System.out.print(num + " ");
    System.out.println();

    result = PP5_Squares_Of_Sorted_Array.sortedSquares(new int[] { -3, -1, 0, 1, 2 });
    for (int num : result)
      System.out.print(num + " ");
    System.out.println();

  }

}
