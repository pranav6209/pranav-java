package com.pranav.educative.E_CycllicSort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pranavpatel
 * 
 *         time : O(N) space : O(1)
 */
public class A5_Find_All_Duplicate_Numbers {

  public static List<Integer> findNumbers(int[] nums) {
    List<Integer> duplicateNumbers = new ArrayList<>();

    int i = 0;

    while (i < nums.length) {

      if (i != nums[i] - 1) {

        int otherIndex = nums[i] - 1;

        if (nums[i] == nums[otherIndex]) {

          duplicateNumbers.add(nums[i]);
          i++;
        } else {
          swap(nums, i, otherIndex);
        }

      } else {
        i++;
      }

    }

    return duplicateNumbers;
  }

  public static void swap(int[] nums, int i, int j) {

    int temp = nums[i];

    nums[i] = nums[j];

    nums[j] = temp;
  }

  public static void main(String[] args) {
    List<Integer> duplicates = A5_Find_All_Duplicate_Numbers.findNumbers(new int[] { 3, 4, 4, 5, 5 });
    System.out.println("Duplicates are: " + duplicates);

    duplicates = A5_Find_All_Duplicate_Numbers.findNumbers(new int[] { 5, 4, 7, 2, 3, 5, 3 });
    System.out.println("Duplicates are: " + duplicates);
  }
}
