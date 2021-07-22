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
public class A3_Permute_Array_Of_Duplicate_Integer {

  static List<List<Integer>> get_permutations(List<Integer> arr) {
    
    Collections.sort(arr);
    List<List<Integer>> res = new ArrayList<List<Integer>>();    
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
     //Edge Case 1 : if two consecutive numbers are same don't swap or add to the result list
     if(i> index) if(slate.get(i)==slate.get(i-1)) continue;
     //Edge case 2: if two indexes are not same but the numbers in the arr are same.
     if(i!=index) if(slate.get(i)==slate.get(index)) continue;
     Collections.swap(slate,index,i);
     helper(slate, index+1, res);
     Collections.swap(slate,i,index);
   }
    
  }
  
  public static void main(String[] args) {
    List<Integer> input = new ArrayList<>();
    input.add(1);
    input.add(2);
    input.add(2);
    System.out.println(get_permutations(input));
  }
}
