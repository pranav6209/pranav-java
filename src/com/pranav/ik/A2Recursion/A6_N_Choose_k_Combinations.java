/**
 * 
 */
package com.pranav.ik.A2Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pranavpatel
 * 
 * O(nCk * k).
 * The total number of combinations = nCk. 
 * To push nCk combination each of size k, we will require O(nCk * k) time in total.
 * Auxiliary Space Used:O(n).
 * We can have an O(n) number of recursive stacks at any moment in time.
 *
 */
public class A6_N_Choose_k_Combinations {
  // Complete the function below.
  public static List<List<Integer>> find_combinations(int n, int k) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> slate = new ArrayList<>();
    // start from index 1 to make array from 1
    helper(n, k, 1, slate, res);
    return res;
  }

  private static void helper(int n, int k, int idx, List<Integer> slate, List<List<Integer>> res) {

    if (slate.size() == k) {

      res.add(new ArrayList<>(slate));
      return;
    }

    // here we have to add this case additionally as base case only check for k and not till n
    if (idx > n)
      return;

    // inclusion
    slate.add(idx);
    helper(n, k, idx + 1, slate, res);
    slate.remove(slate.size() - 1);

    // exclusion
    helper(n, k, idx + 1, slate, res);

  }
  
  public static void main(String[] args) {
    System.out.println(find_combinations(5,2));
  }
}
