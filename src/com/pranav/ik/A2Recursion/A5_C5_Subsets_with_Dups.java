/**
 * 
 */
package com.pranav.ik.A2Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Time Complexity: O(2^n * n).
 * As we will generate 2^n strings of length O(n).
 * Auxiliary Space Used:
 * O(2^n * n).
 * As we will store 2^n strings of length O(n) in the output array to be returned.
 * 
 * @author pranavpatel
 * look at the second problem first
 *
 */
public class A5_C5_Subsets_with_Dups {

  public static List<String> get_distinct_subsets(String s) {
    
    char [] ch = s.toCharArray();
    Arrays.sort(ch);
    s= new String(ch);
    System.out.println("s"+s);
    
    List<String> res = new ArrayList<String>();
    List<Character> slate = new ArrayList<>();
    int index = 0;
    helper(s, index, slate, res);
    return res;


  }

  private static void helper(String s, int index, List<Character> slate, List<String> res) {

    if (index == s.length()) {
      StringBuilder sb = new StringBuilder();
      for(char ch : slate) {
        sb.append(ch);
      }
      res.add(sb.toString());
      return;

    }

    // include

    char ch = s.charAt(index);
    slate.add(ch);
    helper(s, index + 1, slate, res);
    slate.remove(slate.size()- 1);

    // exclude
    while (index < s.length()-1 && s.charAt(index) == s.charAt(index+1)) {

      index++;

    }

    helper(s, index+1, slate, res);
  }
  
  public static void main(String[] args) {
    System.out.println(get_distinct_subsets("abbcb"));
  }
}
