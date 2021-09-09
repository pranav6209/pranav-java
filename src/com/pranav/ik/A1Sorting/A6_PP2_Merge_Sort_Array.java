/**
 * 
 */
package com.pranav.ik.A1Sorting;

import java.util.ArrayList;

/**
 * @author pranavpatel
 *
 */
public class A6_PP2_Merge_Sort_Array {
  static ArrayList<Integer> merge_sort(ArrayList<Integer> arr) {
    // Write your code here.
    helper(arr, 0, arr.size() - 1);
    return arr;

  }

  static void helper(ArrayList<Integer> arr, int start, int end) {

    // base case.

    // we do not want to process same element start == end start >= end

    if (start >= end)
      return;

    // divide more like (start + (end - start)) / 2;
    int mid = start + (end - start) / 2;

    helper(arr, start, mid);
    helper(arr, mid + 1, end);

    // merge

    // size of the existing array end-start+1 is a size
    int[] aux = new int[end - start + 1];

    int i = start;
    int j = mid + 1;
    int k = 0;

    while (i <= mid && j <= end) {

      // to maintain stability combining <= look at the notes
      if (arr.get(i) <= arr.get(j)) {
        aux[k] = arr.get(i);
        i++;
        k++;
      } else {// arr.get(i) > arr.get(j)
        aux[k] = arr.get(j);
        j++;
        k++;
      }
    }

    //either one of this will execute. one array will hit the end and then process other array 
    while (i <= mid) {
      aux[k] = arr.get(i);
      i++;
      k++;
    }

    while (j <= end) {
      aux[k] = arr.get(j);
      j++;
      k++;
    }

    // copy aux array back into original array starting from the start index
    for (int p = 0; p < aux.length; p++) {
      arr.set(start, aux[p]);
      start++;
    }
  }
  
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
    list.add(5);
    list.add(7);
    list.add(3);
    list.add(2);
    System.out.println(merge_sort(list));
  }

}
