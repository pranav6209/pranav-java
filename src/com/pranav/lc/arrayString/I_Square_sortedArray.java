/**
 * 
 */
package com.pranav.lc.arrayString;

import java.util.Arrays;

/**
 * @author pranavpatel 
 * 
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 * 
 * 1. get the beginning index of the negative number 
 * 2. from negative no, go left and right 
 * 3. compare and put it into new array
 *
 */
public class I_Square_sortedArray {
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

    int[] nums = { -4, -1, 0, 3, 10 };

    System.out.println(Arrays.toString(sortedSquares((nums))));

  }

}
