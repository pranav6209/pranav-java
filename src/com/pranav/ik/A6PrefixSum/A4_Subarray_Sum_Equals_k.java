/**
 * 
 */
package com.pranav.ik.A6PrefixSum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pranavpatel
 * 
 * talks about brute force approach first from leetcode 
 * it has a N^2 time complexity so we approach optimal 
 * solution
 * 
 * 
 * 
 * Algorithm explanation from leetcode solution
 * 
 * The idea behind this approach is as follows: If the cumulative sum (prefix sum/running sum)
   up to two indices is the same, the sum of the elements lying in between those indices is zero.[2,3,-3,2] 
   Extending the same thought further, if the cumulative sum up to two indices, say i and j is at a difference of k 
   i.e. if sum[i] - sum[j] =k(prefixSum(i)-prefixSum(j) = k), the sum of elements lying between indices i and j is k.
   
   sample dryrun in leetcode
   
   from Omkar Prefix floater slide 25 
   prefixSum(i)-prefixSum(j) = k
   prefixSum(i)- k  = prefixSum(j)
   
   calculation running sum which is  prefixSum(i) . HashMap stores prefixSum(j)
   
   Time and Space : O(N)
 
 */
public class A4_Subarray_Sum_Equals_k {
  public int subarraySum(int[] nums, int k) {

    int count = 0, prefixSum = 0;

    //map hold prefix sum and its frequency 
    Map<Integer, Integer> map = new HashMap<>();
    
    // initialize map with 0 prefixSum for empty array and its frequency is 1 
    map.put(0, 1);

    for (int i = 0; i < nums.length; i++) {

      prefixSum += nums[i];

      if (map.containsKey(prefixSum - k)) {

        count = count + map.get(prefixSum - k);

      }

      map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);

    }
    return count;
  }
}
