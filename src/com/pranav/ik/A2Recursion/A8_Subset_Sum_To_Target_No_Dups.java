/**
 * 
 */
package com.pranav.ik.A2Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pranavpatel
 * 
 *  Omkar supplement class also similar problem in Test set 1
 *  consider here all number are positive 
 * 
 * 
 *  
 *   
 * count number of subset that sum to k instead of array add a counter
 *  
 * we can have a counter in backtracking case and can just return a counter 
 * instead of adding it to arrayList
 * 
 * Possible to achieve a target sum is similar problem in test
 *
 */


public class  A8_Subset_Sum_To_Target_No_Dups {

  static List<List<Long>> res = new ArrayList<>();

  static List<List<Long>> check_if_sum_possible(long[] arr, long target) {

    helper(arr, target, 0, new ArrayList<>(), 0);
    return res;
  }

  private static void helper(long[] arr, long target, int idx, List<Long> slate, long sumSlate) {

    // multiple backtracking case
    
    // backtracking case -1
    // if sumSlate > target, there is no way we ll have solution so backtrack
    // we need this case as if we add something to slate 
    // it can become more than target
    
    
    //possible to achieve target sum has this test case as it has a negative nums in 
    // array. that solution doesn't have this case
    
    // we have to eliminate this case if our array contains negative number 
    // [-5,-10] and target = -15. 
    
    // because when our slate has a partial solution -5. sumslate will be -5 and 
    // it will be greater than -15 and we ll backtrack instead of going further
 
    
    if (sumSlate > target)
      return;

    // backtracking case -2
    if (sumSlate == target) {
      res.add(new ArrayList<>(slate));
      return;
    }

    // recursive base case. if we are here means we sumSlate < target. other cases would have
    // caught above
    
    if (idx == arr.length) {
      return;
    }

    // include
    long element = arr[idx];
    slate.add(element);
    helper(arr, target, idx + 1, slate, sumSlate + element);
    slate.remove(slate.size() - 1);
    
    // exclude
    helper(arr, target, idx + 1, slate, sumSlate);

  }

  public static void main(String[] args) {
    long[] arr = { 2, 4, 8 };
    System.out.println(check_if_sum_possible(arr, 6));
  }
}
