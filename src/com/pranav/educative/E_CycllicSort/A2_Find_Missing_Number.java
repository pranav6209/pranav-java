/**
 * 
 */
package com.pranav.educative.E_CycllicSort;

/**
 * @author pranavpatel
 *
 */
public class A2_Find_Missing_Number {

  public static int findMissingNumber(int[] nums) {
    int i = 0;
    while (i < nums.length) {

      if (nums[i] < nums.length && i != nums[i]) {

        int otherIndex = nums[i];
        swap(nums, i, otherIndex);
      } else
        i++;
    }

    // find the first number missing from its index, that will be our required
    // number
    for (i = 0; i < nums.length; i++)
      if (nums[i] != i)
        return i;

    return nums.length;
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void main(String[] args) {
    System.out.println(A2_Find_Missing_Number.findMissingNumber(new int[] { 1, 0, 4, 3 }));
    // System.out.println(A2_Find_Missing_Number.findMissingNumber(new int[] { 8, 3,
    // 5, 2, 4, 6, 0, 1 }));
  }

}
