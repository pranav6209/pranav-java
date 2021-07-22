/**
 * 
 */
package com.pranav.ik.A1Sorting;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pranavpatel
 * 
 * Time : O(N)
 * Space : O(1)
 * 
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 *
 */
public class A1_2Sum_In_Sorted_Array {
  // 2-pointer approach
  public static List<Integer> pair_sum_sorted_array(List<Integer> numbers, int target) {

    List<Integer> res = new ArrayList<>();

    // pointers starting from two extremes

    int left = 0, right = numbers.size() - 1;

    while (left < right) {

      int sum = numbers.get(left) + numbers.get(right);

      // System.out.println("sum"+sum);

      if (sum == target) {

        res.add(left);
        res.add(right);
        return res;
      }

      // if sum is less than targer means we have to keep adding bigger value to sum.
      if (sum < target) {
        left++;
      } else { // if sum is bigger than targer means we have to keep subtracting bigger value
               // from sum.
        right--;
      }

    }

    res.add(-1);
    res.add(-1);
    return res;

  }
}
