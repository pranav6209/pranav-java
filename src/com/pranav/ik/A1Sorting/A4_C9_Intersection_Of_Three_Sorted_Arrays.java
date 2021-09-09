/**
 * 
 */
package com.pranav.ik.A1Sorting;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pranavpatel
 * 
 * 
 * questions to ask 
 * 
 * 1. input array is sorted ?
 * 2. what to return if there is no intersection 
 * 
 * what is array is not sorted ? go for hashMap approach. look live class notes 
 * 
 * what if one array is very small compare to other(assuming sorted array) iterate 
 * over a small array and  find element using binary search in a big array 
 * 
 * 
 * 
 * 
 * https://leetcode.com/problems/intersection-of-three-sorted-arrays/
 * 
 * Optimized sol
 * 
 * time O(L+M+N)
 * space O(1)
 *
 */
public class A4_C9_Intersection_Of_Three_Sorted_Arrays {

  public static List<Integer> find_intersection(List<Integer> arr1, List<Integer> arr2, List<Integer> arr3) {

    List<Integer> res = new ArrayList<>();

    List<Integer> instersection1_2 = find_instersection_two_array(arr1, arr2);

    res = find_instersection_two_array(instersection1_2, arr3);

    if (res.isEmpty()) {
      res.add(-1);
    }

    return res;
  }

  private static List<Integer> find_instersection_two_array(List<Integer> arr1, List<Integer> arr2) {

    int i = 0, j = 0;
    
    List<Integer> res = new ArrayList<>();

    while (i < arr1.size() && j < arr2.size()) {

      if (arr1.get(i) == arr2.get(j)) {

        res.add(arr1.get(i));
        i++;
        j++;
      }

      else if (arr1.get(i) < arr2.get(j)) {
        i++;
      }

      else {
        j++;
      }

    }

    return res;

  }

}
