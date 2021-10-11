/**
 * 
 */
package com.pranav.ik.A6PrefixSum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pranavpatel
 * 
 * talks about brute force approach
 * 
 * Time : O(N)
 * Space : O(k) as we are doing mod k, there ll be only k entry in a map
 * 
 * 
 *   Input:  A = [4,5,0,-2,-3,1], K = 5
            Map  
  step 1 : {0:1}          a=4    sum=4  mod=4  count = 0+0 =0
  step 2 : {0:1,4:1}      a=5    sum=9  mod=4  count = 0+1 =1
  step 3 : {0:1,4:2}      a=0    sum=9  mod=4  count = 1+2 =3
  step 4 : {0:1,4:3}      a=-2   sum=7  mod=2  count = 3+0 =3  
  step 6 : {0:1,4:3,2:1}  a=-3   sum=4  mod=4  count = 3+3 =6
  step 7 : {0:1,4:4,2:1}  a=1    sum=5  mod=0  count = 6+1 =7

 * 
 */
public class A5_Subarray_Sum_Divided_By_k {
  public int subarraySum(int[] nums, int k) {

    int count = 0, prefixSum = 0;

    //map hold reminder and its frequency 
    Map<Integer, Integer> map = new HashMap<>();
    
    // initialize map with 0 prefixSum for empty array and its frequency is 1 
    map.put(0, 1);

    for (int i = 0; i < nums.length; i++) {

      // this is p
      prefixSum += nums[i];
      // this p%k
      prefixSum = prefixSum % k;
      
      
      // because when prefixSum is -1, -1 % 5 will be -1 but we need positive mod 4
      if(prefixSum < 0) prefixSum += k;  
      
      // once we have a prefixSum % k, our goal is to find that in existing 
      // hashMap we have a similar key. 
      
      // if we find the key then we have j...i which is divisible by k 
      if (map.containsKey(prefixSum))
        
        // get it count and current count value
        count = count + map.get(prefixSum);

      // else put that value in map
      map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);

    }
    return count;
  }
}
