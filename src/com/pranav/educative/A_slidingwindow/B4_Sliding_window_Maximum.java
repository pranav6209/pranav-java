/**
 * 
 */
package com.pranav.educative.A_slidingwindow;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author pranavpatel
 *         https://www.interviewbit.com/problems/sliding-window-maximum/#
 *         https://leetcode.com/problems/sliding-window-maximum/
 *         https://www.youtube.com/watch?v=xFJXtB5vSmM&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=6&ab_channel=AdityaVerma
 *
 */
public class B4_Sliding_window_Maximum {
  public static int[] maxSlidingWindow(int[] nums, int k) {

    int[] res = new int[nums.length - k + 1];

    int window_start = 0;

    Deque<Integer> deque = new LinkedList<>();

    
    /*
     * Always store window_end in deque but before doing so, remove all the smaller
     * element/s than that element from the deque.
     
     * when we do compare for removal, do peekLast() as last element will be smallest 
     * in queue and then if after removing(pollLast()) it, if there are other smaller 
     * element/s remove them before adding an element in queue.
     * 
     * 
     * That will place an existing element right after bigger element and so we will 
     * have natural asc order in deque.
     * 

     */
    for (int window_end = 0; window_end < nums.length; window_end++) {

      while (!deque.isEmpty() && deque.peekLast() < nums[window_end]) {
        deque.pollLast();
      }

      deque.add(nums[window_end]);

      if (window_end - window_start + 1 == k) {
        res[window_start] = deque.peekFirst();
        
        // before sliding window
        
        // 1. if the element going out is at the peek of deque, remove it
        if (deque.peekFirst() == nums[window_start]) {
          deque.pollFirst();
        }
        window_start++;
      }
     
    }

    return res;
  }

  public static void main(String[] args) {

    int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
    int k = 3;

    System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
  }
}
