/**
 * 
 */
package com.pranav.ik.A1Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author pranavpatel
 * 
 * 
 * https://leetcode.com/problems/find-median-from-data-stream/
 * 
 * The max-heap will store the smaller half of the stream and the min-heap will store the larger half of the sorted stream. 
 * we have a median calculated at every stream. so if number coming is more than median we added to larger half(min Heap) else 
 * other side.
 * 
 * For every element that is added from the stream, we keep the sizes of the heaps the same or they differ maximum by 1. 
 * Without the loss of generality, we will have the extra element in max-heap whenever required. This way, if the total size 
 * of the stream is odd,the element on top of the max-heap is our median, else the floor of the average of the elements on the 
 * top of the min-heap and the max-heap is our required value.Please have a look at the solution for a better understanding.
 * 
 * Time : O(logn) rebalance for a specific number O(logn)  insert O(logn)  median cal O(1)
 * space : O(N) // adding all the element to heap
 * 
 *
 */
public class B4_C8_Online_Median {
  // for a leetcode version of the problem, look at the educative version of the solution. it is same breaking down code in 
  // different functions 
  //https://www.educative.io/courses/grokking-the-coding-interview/3Yj2BmpyEy4
  public static List<Integer> online_median(List<Integer> stream) {
    List<Integer> result = new ArrayList<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    int median = 0;

    
   
    for (int i = 0; i < stream.size(); i++) {
      int num = stream.get(i);

      // if num coming is more than median it belongs to max heap. imagine sorted
      // array where median lies in center and maxHeap
      // on left and minHeap on right
      if (num > median) {
        minHeap.add(num);
        // if diff is 2 re balance or > 1
        if (minHeap.size() - maxHeap.size() == 2) {
          // get the top element from max heap and insert into minHeap
          maxHeap.add(minHeap.poll());
        }

      } else { // num <= median
        maxHeap.add(num);
        if (maxHeap.size() - minHeap.size() == 2) {
          minHeap.add(maxHeap.poll());
        }
      }

      //minHeap and Maxheap is same we have a even element so return avg of both. Else return from max heap or minHeap which
      // evet has an extra element.
      if (minHeap.size() == maxHeap.size()) {
        median = (minHeap.peek() + maxHeap.peek()) / 2;
      } else if (minHeap.size() > maxHeap.size()) {
        median = minHeap.peek();
      } else { // minHeap.size() < maxHeap.size()
        median = maxHeap.peek();
      }
      System.out.println("median" + median);
      result.add(median);
    }

    return result;
  }

  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    list.add(3);
    list.add(8);
    list.add(5);
    list.add(2);

    System.out.println(online_median(list));

  }
}
