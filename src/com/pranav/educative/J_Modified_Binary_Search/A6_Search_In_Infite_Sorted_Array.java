/**
 * 
 */
package com.pranav.educative.J_Modified_Binary_Search;

/**
 * @author pranavpatel
 * 
 *         Time : O(logN) to search range and O(logN) for bianry search Space :
 *         O(1)
 * 
 * 
 * 
 *
 */

class ArrayReader {
  int[] arr;

  ArrayReader(int[] arr) {
    this.arr = arr;
  }

  public int get(int index) {
    if (index >= arr.length)
      return Integer.MAX_VALUE;
    return arr[index];
  }
}

public class A6_Search_In_Infite_Sorted_Array {
  public static int search(ArrayReader reader, int key) {

    // int newStart = end + 1;
    // end += (end - start + 1) * 2; // increase to double the bounds size
    // start = newStart;
    int start = 0;
    int end = 1;
    
    // we can not do arr[index] here as we might go out of bound
    // take an example of { 1, 3, 8, 10, 15 }, in sencond itteration 
    // end will be 5
    while (key > reader.get(end)) {
      System.out.println("reader.get(end)" + reader.get(end));
      int newStart = end + 1;
      end += (end - start + 1) * 2;
      start = newStart;

      // this might work as well
      start = end + 1;
      end = (start * 2) + 1;
    }
    return binarySearch(reader, key, start, end);
  }

  public static int binarySearch(ArrayReader reader, int target, int start, int end) {

    System.out.println("start: " + start);
    System.out.println("end: " + end);
    while (start <= end) {

      int middle = start + (end - start) / 2;
      if (target == reader.get(middle))
        return middle;
      else if (target > reader.get(middle))
        start = middle + 1;
      else
        end = middle - 1;

    }
    return -1;
  }

  public static void main(String[] args) {
    // ArrayReader reader = new ArrayReader(new int[] { 4, 6, 8, 10, 12, 14, 16, 18,
    // 20, 22, 24, 26, 28, 30 });
    // System.out.println(A6_Search_In_Infite_Sorted_Array.search(reader, 16));
    // System.out.println(A6_Search_In_Infite_Sorted_Array.search(reader, 11));
    ArrayReader reader1 = new ArrayReader(new int[] { 1, 3, 8, 10, 15 });
    // System.out.println(A6_Search_In_Infite_Sorted_Array.search(reader1, 15));
    System.out.println(A6_Search_In_Infite_Sorted_Array.search(reader1, 200));
  }
}
