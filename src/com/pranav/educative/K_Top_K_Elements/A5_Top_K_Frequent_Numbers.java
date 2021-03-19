/**
 * 
 */
package com.pranav.educative.K_Top_K_Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author pranavpatel
 * 
 * https://leetcode.com/problems/top-k-frequent-elements/submissions/
 * 
 * time O(NlogK)
 * space O(N+K) to store hashmap and heap for k elements
 *
 */
public class A5_Top_K_Frequent_Numbers {
  public static List<Integer> findTopKFrequentNumbers(int[] nums, int k) {

    Map<Integer, Integer> map = new HashMap<>();

    // O(N)
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((n1, n2) -> map.get(n1) - map.get(n2));

    // 0(logK)
    
    // as we can not add keys to heap by index like examples we have seen before.
    // get all the key with key set and then start adding until we have k value and as soon as we have k values start polling it.
    for (int key : map.keySet()) {
      minHeap.add(key);

      if (minHeap.size() > k) {
        minHeap.poll();
      }

    }
    return new ArrayList<>(minHeap);
    // return as int[] nums
    // return new ArrayList<>(minHeap).stream().mapToInt(i->i).toArray(); 
  }

  public static void main(String[] args) {
    List<Integer> result = A5_Top_K_Frequent_Numbers.findTopKFrequentNumbers(new int[] { 1, 3, 5, 12, 11, 12, 11 }, 2);
    System.out.println("Here are the K frequent numbers: " + result);

    result = A5_Top_K_Frequent_Numbers.findTopKFrequentNumbers(new int[] { 5, 12, 11, 3, 11 }, 2);
    System.out.println("Here are the K frequent numbers: " + result);

    
  }
}
