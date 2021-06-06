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
 *         https://leetcode.com/problems/top-k-frequent-elements/submissions/
 * 
 *         time O(NlogK) space O(N+K) to store hashmap and heap for k elements
 *         
 *         https://www.youtube.com/watch?v=7VoJn544QrM&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=6
 *
 */
public class A5_Top_K_Frequent_Numbers {
  public static List<Integer> findTopKFrequentNumbers1(int[] nums, int k) {

    Map<Integer, Integer> map = new HashMap<>();

    // O(N)
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((n1, n2) -> map.get(n1) - map.get(n2));

    // 0(logK)

    // as we can not add keys to heap by index like examples we have seen before.
    // get all the key with key set and then start adding until we have k value and
    // as soon as we have k values start polling it.
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

  
  //https://www.youtube.com/watch?v=7VoJn544QrM&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=6
  public static List<Integer> findTopKFrequentNumbers2(int[] nums, int k) {

    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
    }

    // creating heap which is sorted by value which is frequency. Min heap will
    // store num and freq while in the
    // video, they are storing freq as key other way around. it will be easier to
    // store num and freq in java
    // as we get map as a entrySet.
    PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<Map.Entry<Integer, Integer>>((n1,
    n2) -> n1.getValue() - n2.getValue());

    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

      minHeap.add(entry);

      if (minHeap.size() > k) {
        minHeap.poll();
      }

    }

    List<Integer> result = new ArrayList<>();

    while (!minHeap.isEmpty()) {
      result.add(minHeap.poll().getKey());
    }

    return result;
  }

  public static void main(String[] args) {
    List<Integer> result = A5_Top_K_Frequent_Numbers.findTopKFrequentNumbers2(new int[] { 1, 3, 5, 12, 11, 12, 11 }, 2);
    System.out.println("Here are the K frequent numbers: " + result);

    result = A5_Top_K_Frequent_Numbers.findTopKFrequentNumbers2(new int[] { 5, 12, 11, 3, 11 }, 2);
    System.out.println("Here are the K frequent numbers: " + result);

  }
}
