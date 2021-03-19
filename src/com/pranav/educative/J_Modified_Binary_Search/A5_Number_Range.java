/**
 * 
 */
package com.pranav.educative.J_Modified_Binary_Search;

/**
 * @author pranavpatel
 * 
 *         Time : O(logN) Space : O(1)
 * 
 * 
 * 
 *
 */
public class A5_Number_Range {
  public static int[] findRange(int[] arr, int target) {
    int[] result = new int[] { -1, -1 };
    if(arr.length==0) return result;
    if (target > arr[arr.length - 1] || target < arr[0])
      return result;
    result[0] = binarySearch(arr, target, false);

    if (result[0] != -1) {// no need to search, if 'key' is not present in the input array
      result[1] = binarySearch(arr, target, true);
    }
    return result;
  }

  public static int binarySearch(int[] arr, int target, boolean lastIndex) {

    int start = 0;
    int end = arr.length - 1;
    int keyIndex = -1;
    while (start <= end) {

      int mid = start + (end - start) / 2;

      if (target == arr[mid]) {
        keyIndex = mid;
        if (lastIndex) {
          start = mid + 1;
        } else {
          end = mid - 1; // we are not searching last index, so goto the right for search
        }
      } else if (target > arr[mid]) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }

    }

    return keyIndex;
  }

  public static void main(String[] args) {
    int[] result = A5_Number_Range.findRange(new int[] { 4, 6, 6, 6, 9 }, 6);
     System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
     result = A5_Number_Range.findRange(new int[] { 1, 3, 8, 10, 15 }, 10);
     System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
     result = A5_Number_Range.findRange(new int[] { 1, 3, 8, 10, 15 }, 12);
     System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
  }
}
