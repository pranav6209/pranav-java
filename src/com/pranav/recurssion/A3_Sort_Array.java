/**
 * 
 */
package com.pranav.recurssion;

import java.util.Arrays;

/**
 * @author pranavpatel
 *
 * 
 *         https://www.youtube.com/watch?v=AZ4jEY_JAVc&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=6&ab_channel=AdityaVerma
 *         
 *         https://www.geeksforgeeks.org/recursive-insertion-sort/
 *
 */
public class A3_Sort_Array {

  static void insertionSortRecursive(int arr[], int n) {
    // Base case when there is only one element in array it is already sorted

    if (n == 1)
      return;

    int temp = arr[n - 1];

    // Sort first n-1 elements. Hypothesis
    insertionSortRecursive(arr, n - 1);

    insert(arr, temp, n - 1);
    return;

  }

  static void insert(int[] arr, int temp, int n) {

    // if array is empty or last element of the array is bigger than last element.
    if (n == 0 || arr[n] <= temp) {
      arr[n + 1] = temp;
      return;
    }

    int val = arr[n-1];
    
    insert(arr, temp, n - 1);
    arr[n] = val;
    

  }

  public static void main(String[] args) {
    //int arr[] = { 0, 1, 5, 2 };
     int arr[] = { 12, 11, 13, 5, 6 };

    insertionSortRecursive(arr, arr.length);

    System.out.println(Arrays.toString(arr));
  }

}
