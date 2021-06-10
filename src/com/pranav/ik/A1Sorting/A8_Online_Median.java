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
 * code is similar but just to understand the logic behind it
 * https://www.youtube.com/watch?v=1LkOrc-Le-Y&ab_channel=TECHDOSETECHDOSE
 *
 */
public class A8_Online_Median {

  public static List<Integer> online_median(List<Integer> stream) {
    List<Integer> result = new ArrayList<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    
    ArrayList<Integer> list = new ArrayList<>();

    for (int i = 0; i < stream.size(); i++) {
      int num = stream.get(i);
      
      // always try to add first in maxHeap. Max heap can carry one extra element than minHeap.
      //if maxHeap is zero or maxHeap top number is greater than num coming is belongs to maxHeap.
      if (maxHeap.size() == 0 || maxHeap.peek() > num) {
        maxHeap.offer(num);
      } else {
        minHeap.offer(num);
      }

      // balance heap (to handle odd set() and even set())
      if (maxHeap.size() != minHeap.size()) {
        // maxHeap has more than one element than minHeap 
        if (maxHeap.size() > minHeap.size() + 1) {
          minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
          maxHeap.offer(minHeap.poll());
        }
      }

      if (minHeap.size() == maxHeap.size()) {
        // even set
        result.add((minHeap.peek() + maxHeap.peek()) / 2);
      } else {
        // odd set
        result.add(maxHeap.peek());
      }

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
