package com.pranav.educative.E_CycllicSort;

/**
 * @author pranavpatel
 * 
 * time : O(N)
 * space : O(1)
 */
public class A4_Find_Duplicate_Numbers {

  public static int findNumber(int[] nums) {

    if (nums.length <= 0)
      return -1;
    if (nums.length == 1)
      return nums[0];

    int i = 0;
    while (i < nums.length) {
      
      if (i != nums[i] - 1) {
        int otherIndex = nums[i] - 1;
        if (nums[i] == nums[otherIndex])
          return nums[i];
        swap(nums, i, otherIndex);
      } else {
        i++;
      }

    }

    return -1;
  }

  public static void swap(int[] nums, int i, int j) {

    int temp = nums[i];

    nums[i] = nums[j];

    nums[j] = temp;
  }

  public static void main(String[] args) {
    System.out.println(A4_Find_Duplicate_Numbers.findNumber(new int[] { 1, 4, 4, 3, 2 }));
    System.out.println(A4_Find_Duplicate_Numbers.findNumber(new int[] { 2, 1, 3,3, 5, 4 }));
    System.out.println(A4_Find_Duplicate_Numbers.findNumber(new int[] { 2, 4, 1,4, 4 }));
  }
}
