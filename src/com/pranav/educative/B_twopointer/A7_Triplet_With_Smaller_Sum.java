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
 *         https://leetcode.com/problems/3sum-smaller/
 * 
 *         time : sorting O(N logN ) -- searching for each no input array(for
 *         and nest while so o(N^2)) that will be O(N^2) = O(N^2+logn)
 * 
 *         space : O(N) required for sorting
 * 
 *
 */
public class A7_Triplet_With_Smaller_Sum {

  //
  public static int searchNoOfTriplets(int[] num, int target) {
    Arrays.sort(num);
    int count = 0;

    for (int i = 0; i < num.length - 2; i++) {

      int left = i + 1;
      int right = num.length - 1;

      while (left < right) {

        int currentSum = num[i] + num[left] + num[right];

        if (currentSum < target) {

          // as array is sorted,all the number between right and left can be included
          count = count + (right - left);
          left++;

        }

        else {

          // if sum is bigger include smaller number
          right--;
        }

      }

    }
    return count;

  }
  
//  time : sorting O(N logN ) -- searching for each no input array(for
//  and nest while and nest for so o(N^3)) that will be O(N^2) = O(N^2+logn)
//   
//  space : O(N) required for sorting ignoring space required for o/p


  public static List<List<Integer>> searchTriplets(int[] num, int target) {
    Arrays.sort(num);

    List<List<Integer>> triplets = new ArrayList<>();

    for (int i = 0; i < num.length - 2; i++) {

      int left = i + 1;
      int right = num.length - 1;

      while (left < right) {

        int currentSum = num[i] + num[left] + num[right];

        if (currentSum < target) {

          for (int j = right; j > left; j--) {

            triplets.add(Arrays.asList(num[i], num[left], num[j]));

          }

          left++;

        }

        else {

          // if sum is bigger include smaller number
          right--;
        }

      }

    }
    return triplets;

  }

  public static void main(String[] args) {

    System.out.println(A7_Triplet_With_Smaller_Sum.searchNoOfTriplets(new int[] { -1, 4, 2, 1, 3 }, 5));
    System.out.println(A7_Triplet_With_Smaller_Sum.searchTriplets(new int[] { -1, 4, 2, 1, 3 }, 5));

  }
}
