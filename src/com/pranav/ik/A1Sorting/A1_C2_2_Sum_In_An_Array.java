/**
 * 
 */
package com.pranav.ik.A1Sorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * here if we have to return a boolean we can sort the array and use similar
 * approach of class problem-1 time complexity : O(nlog n) + O(n) - O(nlog n) for
 * sorting and O(n) - for single two pointete one pass space : O(1)
 * 
 * since we are returning indices, we can no use that approach. use hashmap that
 * requires additional space
 * 
 * time : O(N) space : O(N)
 * 
 * 
 * if additional space is not permitted and pre sorting is not 
 * allowed then use brute force approach
 * 
 * time : O(N^2)
 * space : O(1)
 *
 */
public class A1_C2_2_Sum_In_An_Array {
  public static List<Integer> two_sum(List<Integer> numbers, int target) {

    List<Integer> res = new ArrayList<Integer>();

    // map of the number and indecice
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < numbers.size(); i++) {

      int complement = target - numbers.get(i);

      if (map.containsKey(complement)) {

        res.add(map.get(complement));
        res.add(i);
        return res;

      } else {
        map.put(numbers.get(i), i);
      }

    }

    res.add(-1);
    res.add(-1);

    return res;
  }

  public static List<Integer> two_sum_bruteforce(List<Integer> numbers, int target) {

    List<Integer> res = new ArrayList<>();

    for (int i = 0; i < numbers.size(); i++) {
      for (int j = i + 1; j < numbers.size(); j++) {

        if (numbers.get(i) + numbers.get(j) == target) {
          res.add(i);
          res.add(j);
          return res;
        }

      }
    }

    res.add(-1);
    res.add(-1);
    return res;

  }
}
