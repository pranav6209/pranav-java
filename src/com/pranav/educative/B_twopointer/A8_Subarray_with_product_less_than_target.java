/**
 * 
 */
package com.pranav.educative.B_twopointer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author pranavpatel
 * 
 * time : O(N3)
 * space : O(N)
 *
 */
public class A8_Subarray_with_product_less_than_target {

  public static List<List<Integer>> findSubarrays(int[] arr, int target) {
    List<List<Integer>> subarrays = new ArrayList<>();

    int window_start = 0;
    int product = 1;

    for (int window_end = 0; window_end < arr.length; window_end++) { // O(N)

      product = product * arr[window_end];

      // if product is greater, increment the window_start and element going out should be removed from window
      
      // not sure why we need window_start < arr.length, leet code solution doesn't have it
      while (product >= target && window_start < arr.length) {
        product = product / arr[window_start];
        window_start++;
      }
      
      // so we can add constantly at the 0th index
      List<Integer> tempList = new LinkedList<>();
      
      // all the elements between window_end and window_start should be included in the list 
      for (int i = window_end; i >= window_start; i--) { //  //The worst case, this will be executed n times.
        tempList.add(0, arr[i]); // O(1) since you are adding at the start of the LinkedList.
        subarrays.add(new ArrayList<>(tempList));//Here is the problem! For each iteration the cost of copying the tempList to a new ArrayList will increase by one. So the total cost of this execution in the worst case will be the summation from 1 to n, which is n(n+1)/2 and asymptotic to n^2. 
      }

    }

    return subarrays;
  }
  
  
  // total no of sub array instead of returning all sub array
  public static int numSubarrayProductLessThanK(int[] arr, int target) {
    
 // to handle test case {1,1,1} to return 0;   
  if (target <= 1) return 0;    

  int window_start = 0;
  int product = 1;
  int count=0;  

  for (int window_end = 0; window_end < arr.length; window_end++) { // O(N)

    
    product = product * arr[window_end];
    while (product >= target) {
      product = product / arr[window_start];
      window_start++;
    }
      
   count = count + window_end - window_start+1;
        
       
  }

  return count;
      
  }

  public static void main(String[] args) {
  //  System.out.println(A8_Subarray_with_product_less_than_target.findSubarrays(new int[] { 2, 5, 3, 10 }, 30));
//    System.out.println(A8_Subarray_with_product_less_than_target.findSubarrays(new int[] { 8, 2, 6, 5 }, 50));
//    System.out.println(A8_Subarray_with_product_less_than_target.findSubarrays(new int[] { 1,1,1 }, 1));
    System.out.println(A8_Subarray_with_product_less_than_target.numSubarrayProductLessThanK(new int[] { 2, 5, 3, 10 }, 30));
  }

}
