/**
 * 
 */
package com.pranav.educative.E_CycllicSort;

/**
 * @author pranavpatel
 * 
 * 
 * https://www.youtube.com/watch?v=YvksaZhYYAk
 *
 */
public class A1_cyclic_sort {
  public static void sort(int[] nums) {
    int i = 0;
    while (i < nums.length) {

      // index and ith elment -1 is not equal, element is not at correct pos
      if (i != nums[i] - 1) {

        // get the ith elements correct index
        int otherIndex = nums[i] - 1;
        swap(nums, i, otherIndex);

      } else {
        i++;
      }

    }
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void main(String[] args) {
    int[] arr = new int[] { 3, 1, 5, 4, 2 };
    // A1_cyclic_sort.sort(arr);
    // for (int num : arr)
    // System.out.print(num + " ");
    // System.out.println();

    arr = new int[] { 2, 6, 4, 3, 1, 5 };
    A1_cyclic_sort.sort(arr);
    for (int num : arr)
      System.out.print(num + " ");
    System.out.println();

    // arr = new int[] { 1, 5, 6, 4, 3, 2 };
    // A1_cyclic_sort.sort(arr);
    // for (int num : arr)
    // System.out.print(num + " ");
    // System.out.println();
  }
}
