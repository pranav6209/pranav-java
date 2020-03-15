/**
 * 
 */
package com.pranav.lc.arrayString;

/**
 * @author pranavpatel
 *
 */
public class N_Search_Insert_Position {

  public static int searchInsert(int[] nums, int target) {

    if (target < nums[0])
      return 0;
    if (target > nums[nums.length - 1])
      return nums.length;

    for (int i = 0; i < nums.length; i++) {

      if (target==nums[i])return i;
      if(nums[i]>target) return i;

    }

    throw new IllegalArgumentException("not found");
  }

  public static void main(String[] args) {

    int[] nums = { 1, 3, 5, 6 };
    int target = 7;
    System.out.println(searchInsert(nums, target));

  }
}
