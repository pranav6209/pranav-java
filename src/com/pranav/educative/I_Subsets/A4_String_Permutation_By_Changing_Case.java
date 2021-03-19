/**
 * 
 */
package com.pranav.educative.I_Subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pranavpatel
 * 
 *         https://leetcode.com/problems/letter-case-permutation/
 * 
 * 
 *         time complexity : O(2^N) for recursion and O(N) for converting String to char array
 *                           O(N+2^N)    
 *
 *         space complexity : O(2^N) for recursion stack and O(N) for storing char array 
 *                            O(N+2^N)
 *
 */
public class A4_String_Permutation_By_Changing_Case {
  public static List<String> letterCasePermutation(String S) {

    List<String> ans = new ArrayList<>();
    dfs(ans, 0, S.toCharArray());
    return ans;

  }

  public static void dfs(List<String> res, int index, char[] S) {
    if (index == S.length)
      res.add(new String(S));
    else {
      if (Character.isLetter(S[index])) { // If it's letter
        S[index] = Character.toUpperCase(S[index]);
        dfs(res, index + 1, S); // Upper case branch
        S[index] = Character.toLowerCase(S[index]);
        dfs(res, index + 1, S); // Lower case branch
      } else
        dfs(res, index + 1, S);
    }
  }

  public static void main(String[] args) {
    List<String> result = A4_String_Permutation_By_Changing_Case.letterCasePermutation("a1b2");
    System.out.println(" String permutations are: " + result);
  }
}
