/**
 * 
 */
package com.pranav.lc.stackQueueHeap;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author pranavpatel
 * 
 * 
 *         https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/531/week-4/3313/
 *
 */
public class F_First_Unique_Number2 {

  // map of value and frequency
  Map<Integer, Integer> map;
  // Set<Integer> set;
  Queue<Integer> queue;

  F_First_Unique_Number2(int[] nums) {

    // inserting an element is O(N)
    map = new HashMap<>();
    queue = new LinkedList<>();
    for (int num : nums) {
      add(num);

    }

  }

  public int showFirstUnique() {

    int res = 0;

    while (!queue.isEmpty() && map.get(queue.peek()) > 1) {
      queue.remove();
    }

    if (queue.isEmpty()) {
      res = -1;

    }

    else {
      res = queue.peek();
    }

    System.out.println(res);
    return res;
  }

  public void add(int value) {

    // 0(1)
    if (map.containsKey(value)) {
      // 0(1)
      map.put(value, map.get(value) + 1);
      // remove it from queue if value is more than 1
    }

    else {
      map.put(value, 1);
      // only add it to queue if its value is 1
      queue.add(value);
    }

    // public void add(int value) {
    //
    // if (set.add(value)) {
    // queue.add(value);
    // } else {
    // queue.remove(value);
    // }

  }

  public static void main(String[] args) {
    /*
     * 
     * int[] nums = { 2, 3, 5 };
     * 
     * F_First_Unique_Number firstUnique = new F_First_Unique_Number(nums);
     * firstUnique.showFirstUnique(); // return 2 firstUnique.add(5); // the queue
     * is now [2,3,5,5] firstUnique.showFirstUnique(); // return 2
     * firstUnique.add(2); // the queue is now [2,3,5,5,2]
     * firstUnique.showFirstUnique(); // return 3 firstUnique.add(3); // the queue
     * is now [2,3,5,5,2,3] firstUnique.showFirstUnique(); // return -1
     */

    /*
     * int[] nums = {7,7,7,7,7,7};
     * 
     * F_First_Unique_Number firstUnique = new F_First_Unique_Number(nums);
     * firstUnique.showFirstUnique(); // return -1 firstUnique.add(7); // the queue
     * is now [7,7,7,7,7,7,7] firstUnique.add(3); // the queue is now
     * [7,7,7,7,7,7,7,3] firstUnique.add(3); // the queue is now [7,7,7,7,7,7,7,3,3]
     * firstUnique.add(7); // the queue is now [7,7,7,7,7,7,7,3,3,7]
     * firstUnique.add(17); // the queue is now [7,7,7,7,7,7,7,3,3,7,17]
     * firstUnique.showFirstUnique(); // return 17
     */

    int[] nums = { 809 };
    F_First_Unique_Number2 firstUnique = new F_First_Unique_Number2(nums);
    firstUnique.showFirstUnique(); // return 809
    firstUnique.add(809); // the queue is now [809,809]
    firstUnique.showFirstUnique(); // return -1

  }
}
