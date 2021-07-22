/**
 * 
 */
package com.pranav.ik.A2Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author pranavpatel
 * 
 * Time : O(N!*N) -- N! base cases and N for copying
 * Space : O(N)
 *
 */
public class A2_Permute_Array_Of_Unique_Integer {

  static List<List<Integer>> get_permutations(List<Integer> arr) {
    
    List<List<Integer>> res = new ArrayList<List<Integer>>();    
    // Original array is used as a slate here
    helper(arr,0,res);
    return res;

  }

  // no need to pass slate here as we are implementing actual array
  private static void helper(List<Integer> slate, int index, List<List<Integer>> res) {
   if(index == slate.size()) {
     res.add(new ArrayList<>(slate));
     return;  
   }
     
   for(int i = index;i<slate.size();i++) {
     
     Collections.swap(slate,index,i);
     helper(slate, index+1, res);
     Collections.swap(slate,i,index);
   }
    
  }
  
  public static void main(String[] args) {
    List<Integer> input = new ArrayList<>();
    input.add(1);
    input.add(2);
    input.add(3);
    System.out.println(get_permutations(input));
  }
}
