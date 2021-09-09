/**
 * 
 */
package com.pranav.ik.A1Sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author pranavpatel
 * 
 * https://leetcode.com/problems/sort-colors/
 * 
 * time : O(logk*(initial_stream+append_stream)) - logk for to maintain heap
 * space : aux space : O(k) 
 */
public class B3_C6_Kth_Largest_In_Stream {

  public static List<Integer> kth_largest(int k, List<Integer> initial_stream, List<Integer> append_stream) {

    List<Integer> res = new ArrayList<>();

    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

    // add initial stream in to heap
    for (int i = 0; i < initial_stream.size(); i++) {

      minHeap.add(initial_stream.get(i));
    }

    // add append strem to heap
    for (int j = 0; j < append_stream.size(); j++) {

      minHeap.add(append_stream.get(j));

      // if heap is greater than k remove elements
      while (minHeap.size() > k) {
        minHeap.poll();
      }

      // once we have only k element add it to result
      // here we are building res with each addition number from stream
      if (minHeap.size() == k) {

        res.add(minHeap.peek());
      }

    }

    return res;

  }

}
