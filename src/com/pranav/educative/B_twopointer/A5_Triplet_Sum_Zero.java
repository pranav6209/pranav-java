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
 *         https://leetcode.com/problems/3sum/
 *
 *         if approach - presorting and
 *            time : sorting O(N logN ) -- searching for each no input array(for and nest while so o(N^2))that will be O(N^2) = O(N^2+logn)
 *            space : O(N) required for sorting 
 *         
 *
 */
public class A5_Triplet_Sum_Zero {

  public static List<List<Integer>> searchTriplets(int[] arr) {

    List<List<Integer>> triplets = new ArrayList<>();

    Arrays.sort(arr); // O(NlogN)

    
    // here we can do arr.lenght-2 but not necessary
    for (int i = 0; i < arr.length; i++) {

      
      int currentNum = arr[i];
      
      // we x+y+z = 0 so we are looking for x+y = -z 
      int target = -currentNum;

      // since we might have dups in the array, skip same element to avoid duplicate triplets in the answer
      if (i > 0 && arr[i] == arr[i - 1])
        continue;

      // find Pair

      int left = i + 1;
      int right = arr.length - 1;

      // here  we are looking for all the possible pairs for particular index, if we have found one pair, 
      // we will be continue looking for other pairs till left < right 
      while (left < right) {

        // found matching pair
        if (target == arr[left] + arr[right]) {
          triplets.add(Arrays.asList(currentNum, arr[left], arr[right]));
          left++;
          right--;

          // optimization in code
          // continue skipping, for dups. left == left-1 ( current and a previous )
          while (left < right && arr[left] == arr[left - 1])
            left++;
          
          // continue skipping, for dups.right == right +1 ( current and a next )
          while (left < right && arr[right] == arr[right + 1])
            right--;
          
          // if target is bigger, increase the sum so increase left to include bigger number.
        } else if (target > arr[left] + arr[right]) {
          left++;
        } else {
          right--; // if target is smaller, decrease the sum so decrement left to include smaller number.
        }
      }
    }
    return triplets;
  }

  public static void main(String[] args) {

    System.out.println(A5_Triplet_Sum_Zero.searchTriplets(new int[] { -3, 0, 1, 2, -1, 1, -2 }));
   // System.out.println(A5_Triplet_Sum_Zero.searchTriplets(new int[] { -5, 2, -1, -2, 3 }));
  //  System.out.println(A5_Triplet_Sum_Zero.searchTriplets(new int[] { -2, 0, 1, 1, 2 }));
   // System.out.println(A5_Triplet_Sum_Zero.searchTriplets(new int[] { -1, 0, 1, 2, -1, -4 }));

  }
}
