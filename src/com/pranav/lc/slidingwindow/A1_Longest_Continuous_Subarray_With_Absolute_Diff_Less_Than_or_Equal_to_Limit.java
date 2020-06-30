/**
 * 
 */
package com.pranav.lc.slidingwindow;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author pranavpatel
 * 
 * 
 * https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/submissions/
 * 
 * https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/discuss/609771/JavaC%2B%2BPython-Deques-O(N)
 * 
 * https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/discuss/609743/Java-Detailed-Explanation-Sliding-Window-Deque-O(N)
 * 
 * video explaination
 * 
 * https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/discuss/609828/DETAILED-VIDEO-EXPLANATION-with-code-O(n)
 *
 *  Time O(N)
    Space O(N)
 *
 */
public class A1_Longest_Continuous_Subarray_With_Absolute_Diff_Less_Than_or_Equal_to_Limit {
  public static int longestSubarray(int[] A, int limit) {
    
    // double ended queue
    
    Deque<Integer> maxd = new ArrayDeque<>();
    Deque<Integer> mind = new ArrayDeque<>();
    
    int left = 0, right, res = 1;

    for (right = 0; right < A.length; right++) {

      // update maxDeque with new right pointer

      while (!maxd.isEmpty() && A[right] > maxd.peekLast())
        maxd.pollLast();
      
      maxd.add(A[right]);

      // update minDeque with new right pointer
      while (!mind.isEmpty() && A[right] < mind.peekLast())
        mind.pollLast();
      mind.add(A[right]);

      // as we are incrementing left, remove that element if it is in dequeue.
      if (maxd.peek() - mind.peek() > limit) {
        if (maxd.peek() == A[left])
          maxd.poll();
        if (mind.peek() == A[left])
          mind.poll();
        left++;
      }
      res = Math.max(res, right - left + 1);
    }
    return res;
  }

  public static void main(String[] args) {

    int[] nums = { 8, 2, 4, 7 };
    System.out.println(longestSubarray(nums, 4));
  }
}
