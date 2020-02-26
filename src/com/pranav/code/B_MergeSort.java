/**
 * 
 */
package com.pranav.code;

import java.util.Arrays;

/**
 * @author pranavpatel
 * https://www.geeksforgeeks.org/merge-sort/
 * https://www.youtube.com/watch?v=TzeBrDU-JaY&list=PL2_aWCzGMAwKedT2KfDMB9YA5DgASZb3U&index=5
 * 
 *
 */

// O(nlogn)
public class B_MergeSort {

  // divide the array till it has only one element, calls recursively
  public static void mergeSort(int[] a, int n) {

    int mid = n / 2;

    if (n < 2)
      return;

    int[] l = new int[mid];
    int[] r = new int[n - mid];

    for (int i = 0; i < mid; i++) {

      l[i] = a[i];

    }

    for (int j = mid; j < n; j++) {

      r[j - mid] = a[j];

    }

    mergeSort(l, mid);
    mergeSort(r, n - mid);
    merge(a, l, r, mid, n - mid);
    // System.out.println(Arrays.toString(l));
    // System.out.println(Arrays.toString(r));

    //System.out.println(Arrays.toString(a));
  }

  // merge two halves
  public static void merge(int[] a, int[] l, int[] r, int left, int right) {

    int i = 0, j = 0, k = 0;
    while (i < left && j < right) {

      if (l[i] < r[j]) {
        a[k] = l[i];
        k++;
        i++;
      } else {

        a[k] = r[j];
        k++;
        j++;
      }

    }

    while (i < left) {
      a[k] = l[i];
      k++;
      i++;
    }

    while (j < right) {
      a[k] = r[j];
      k++;
      j++;

    }
  }

  public static void main(String[] args) {
    //int[] nums = { 12, 11, 13, 5, 6, 7 };
    int[] nums = { 38, 27, 43, 3, 9, 82,10 };

    mergeSort(nums, 7);
    
    //sorted array
    System.out.println(Arrays.toString(nums));

  }

}
