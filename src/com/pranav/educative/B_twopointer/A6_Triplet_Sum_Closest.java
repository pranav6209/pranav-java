/**
 * 
 */
package com.pranav.educative.B_twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author pranavpatel
 * 
 * 
 *         https://leetcode.com/problems/3sum-closest/
 * 
 *         time : sorting O(N logN ) -- searching for each no input array(for and nest while so o(N^2)) that will be O(N^2) = O(N^2+logn)
 *         
 *         space : O(N) required for sorting
 * 
 *
 */
public class A6_Triplet_Sum_Closest {

  // time O(N)
  // space O(1)
  public static int threeSumClosest(int[] num, int target) {
    Arrays.sort(num);
    int res = 0;
    int minimunDiff = Integer.MAX_VALUE;

    for (int i = 0; i < num.length; i++) {
      
      int left = i + 1;
      int right = num.length -1;
      
      while (left < right) {
        int sum = num[i] + num[left] + num[right];
        if (sum == target)
          return sum;

        // as sum is smaller, add bigger no to sum
        if (sum < target)
          left++;
        else
          right--;

        // abs value as lets says 3 is target, for  both sum 2 and 4 difference is 1
        int currentDiff = Math.abs(target - sum);

        if (currentDiff < minimunDiff) {

          minimunDiff = currentDiff;

          res = sum;
        }

      }
    }
    return res;
  }

  public static void main(String[] args) {

    // System.out.println(A5_Triplet_Sum_Zero.searchTriplets(new int[] { -3, 0, 1,
    // 2, -1, 1, -2 }));
    // System.out.println(A5_Triplet_Sum_Zero.searchTriplets(new int[] { -5, 2, -1,
    // -2, 3 }));
    System.out.println(A6_Triplet_Sum_Closest.threeSumClosest(new int[] { -1, 0, 1, 1, 55 }, 3));
    // System.out.println(A5_Triplet_Sum_Zero.searchTriplets(new int[] { -1, 0, 1,
    // 2, -1, -4 }));

  }
}
