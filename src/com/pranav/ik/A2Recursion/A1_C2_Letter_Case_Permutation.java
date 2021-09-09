/**
 * 
 */
package com.pranav.ik.A2Recursion;

import java.util.ArrayList;
import java.util.List;

import com.pranav.educative.I_Subsets.A4_String_Permutation_By_Changing_Case;

/**
 * @author pranavpatel
 * 
 *         https://leetcode.com/problems/letter-case-permutation/
 *         https://www.educative.io/courses/grokking-the-coding-interview/xVlKmyX542P
 *
 */

/*
 * space and time in the live class explanation 
 * 
 */
public class A1_C2_Letter_Case_Permutation {

  static List<String> res = new ArrayList<>();
  public static List<String> letter_case_permutations(String str) {

    // slate if list of char as we are only expecting one char at a time in the list
    List<Character> slate = new ArrayList<>();
    helper(str, 0, slate);
    return res;

  }

  // here we are writing this code for an arbitrary worker in hierarchy which
  // includes leaf node and internal node.

  // partial solution = slate = passing to lower roots
  // sub problem definition = str and idx
  private static void helper(String str, int idx, List<Character> slate) {

    // recursion base case
    // leaf node
    
    // here we are not checking idx == str.lenght -1 as at that point we are still
    // working with sub problem definition size 1
    // when we at idx == str.lenght, our subproblem definition is empty

    // here all the blanks are filled at this point 
    if (idx == str.length()) {
      // every recursive call is modifying list so if we do not make a copy, we ll end up with empty sets
      StringBuilder sb = new StringBuilder();
      for (char ch : slate) {
        sb.append(ch);
      }

      res.add(sb.toString());
      return;
    }

    // recursive calls to delegate works to lower roots. arbitaty worker which is
    // not a leaf

    char ch = str.charAt(idx);

    // if letter -- lower case and upper case
    if (Character.isLetter(ch)) {

      slate.add(Character.toUpperCase(ch));
      // index + 1 because, we filled the first letter with our choice and now working
      // on second blank
      helper(str, idx + 1, slate);
      slate.remove(slate.size() - 1);

      slate.add(Character.toLowerCase(ch));
      helper(str, idx + 1, slate);
      slate.remove(slate.size() - 1);

      // digit just add it to slate
    } else if (Character.isDigit(ch)) {

      slate.add(ch);
      helper(str, idx + 1, slate);
      slate.remove(slate.size() - 1);
    }

  }

  public static void main(String[] args) {
    List<String> result = A1_C2_Letter_Case_Permutation.letter_case_permutations("a1b2");
    System.out.println(" String permutations are: " + result);
  }

}
