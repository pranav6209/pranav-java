package com.pranav.educative.E_CycllicSort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pranavpatel
 *
 */
public class A3_Find_All_Missing_Numbers {
  public static List<Integer> findNumbers(int[] nums) {
    List<Integer> missingNumbers = new ArrayList<>();

    int i = 0;
    while (i < nums.length) {

      // index of this number should be -1
      int j = nums[i] - 1;

      // if number and index is same means the number is at correct place and do not
      // need to swap and increment
      // start otherwise we have to swap
      if (nums[i] != nums[j]) {

        swap(nums, i, j);
      }

      else
        i++;

    }

    for (i = 0; i < nums.length; i++) {

      if (nums[i] != i + 1) {

        missingNumbers.add(i + 1);
      }

    }

    return missingNumbers;
  }

  private static void swap(int[] nums, int i, int j) {

    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;

  }

  public static void main(String[] args) {
    List<Integer> missing = A3_Find_All_Missing_Numbers.findNumbers(new int[] { 2, 3, 1, 8, 2, 3, 5, 1 });
    System.out.println("Missing numbers: " + missing);

    missing = A3_Find_All_Missing_Numbers.findNumbers(new int[] { 2, 4, 1, 2 });
    System.out.println("Missing numbers: " + missing);

    missing = A3_Find_All_Missing_Numbers.findNumbers(new int[] { 2, 3, 2, 1 });
    System.out.println("Missing numbers: " + missing);
  }

}
