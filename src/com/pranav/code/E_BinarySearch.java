/**
 * 
 */
package com.pranav.code;

/**
 * @author pranavpatel
 *
 */
public class E_BinarySearch {
  public static int binarySearchRecursive(int arr[], int l, int r, int x) {

    while (l <= r) {
      int mid = l + (r - l) / 2;

      // If the element is present at the
      // middle itself
      if (arr[mid] == x)
        return mid;

      // If element is smaller than mid, then
      // it can only be present in left subarray
      if (arr[mid] > x)
        return binarySearchRecursive(arr, l, mid - 1, x);

      // Else the element can only be present
      // in right subarray
      return binarySearchRecursive(arr, mid + 1, r, x);

      // if we reach here, then element was
      // not present
    }
    return -1;
  }

  public static int binarySearch(int arr[], int target) {

    int l = 0;
    int r = arr.length-1;
    int mid = 0;
    while (l <= r) {

      mid = l+ (r- l) / 2;

      if (target == arr[mid])
        return mid;

      // then search target on right side
      if (target > arr[mid])
        l = mid + 1;

      else
        r = mid - 1;

    }

    return -1;
  }

  public static void main(String[] args) {
    
    int [] nums = {1,3,5,7,10,15};
    int target=15;
    System.out.println(binarySearch(nums, target));
    System.out.println(binarySearchRecursive(nums, 0, nums.length-1, target));
  }
}

