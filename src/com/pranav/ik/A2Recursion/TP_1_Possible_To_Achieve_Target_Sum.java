/**
 * 
 */
package com.pranav.ik.A2Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pranavpatel
 *
 */
public class TP_1_Possible_To_Achieve_Target_Sum {
  static boolean check_if_sum_possible(long[] arr, long k) {

    return helper(arr, k, 0, new ArrayList<>(), 0);

  }

  private static boolean helper(long[] arr, long target, int idx, List<Long> slate, long sumSlate) {

    

    // recursive basecase
    if (idx == arr.length) {
      
      /*
      
      long[] arr = {1}; target =0
      
      consider arr with element 1 when we exclude we ll get 0 in a slate and 
      we ll get the target but that is not correct   
      
      */
      if(target == 0 && slate.size()==0) return false;
      
      // we can also put this outside of the if (idx == arr.length) if we want to stop early
      if (sumSlate == target) {
        return true;
      } 
        return false;
    }

    // include

    long element = arr[idx];
    slate.add(element);
    /*
     * instead of b1 || b2. check if include case (boolean b1)  
     * return true then we do not have to check exclude. to prevent a case 
     * [2,4,6] we want to return when we find [2,4]
     * 
     */
    
    boolean b1 = helper(arr, target, idx + 1, slate, sumSlate + element);
    slate.remove(slate.size() - 1);

    // exclude
    if(!b1) {
    boolean b2 = helper(arr, target, idx+1, slate, sumSlate);
    return b2;
    }
   
    return b1;

    //  return b1 || b2;

  }

  public static void main(String[] args) {
    long[] arr = {1};
    System.out.println(check_if_sum_possible(arr, 0));
  }
}
