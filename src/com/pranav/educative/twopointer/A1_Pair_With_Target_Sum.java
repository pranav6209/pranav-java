/**
 * 
 */
package com.pranav.educative.twopointer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pranavpatel
 * 
 *      https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * 
 *         time : O(N) space : O(1)
 */
public class A1_Pair_With_Target_Sum {

  public static int[] search(int[] arr, int targetSum) {

    int left = 0;
    int right = arr.length - 1;

    while (left < right) {

      if (arr[left] + arr[right] == targetSum)
        return new int[] { left, right };

      else if (arr[left] + arr[right] > targetSum)
        right--;
      else if (arr[left] + arr[right] < targetSum)
        right++;

    }

    return new int[] { -1, -1 }; // pair not found
  }
  
  
  // time O(N) 
  // space O(N): in the worst case, we will be pushing ‘N’ numbers in the HashTable.

  public static int[] searchHashMap(int[] arr, int targetSum) {

    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < arr.length; i++) {

      if (map.containsKey(targetSum - arr[i]))
        return new int[] { map.get(targetSum - arr[i]),i  };

      else {

        map.put(arr[i], i);

      }

    }
    return new int[] { -1, -1 }; // pair not found
  }

  public static void main(String[] args) {

    System.out.println(Arrays.toString(search(new int[] { 2, 5, 9, 11 }, 11)));
    System.out.println(Arrays.toString(searchHashMap(new int[] { 2, 5, 9, 11 }, 11)));

  }
}
