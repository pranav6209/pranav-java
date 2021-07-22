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
 * Time Complexity:
 * 
 * O(length * 2length).
 * 
 * In the worst case, each character in the string might be an English alphabet.
 * In that case, we will have to consider two possibilities of all the length
 * numbers of characters present in the string. So, the total number of possible
 * output strings will be O(2length). It will take O(length) amount of time to
 * copy each of these strings into our result. This makes the overall time
 * complexity equal to O(length * 2length).
 * 
 * Auxiliary Space Used:
 * 
 * O(length).
 * 
 * We can have at most a length number of recursive calls at any moment of time
 * in the recursion stack (one for each character in the string).
 * 
 */
public class A1_Letter_Case_Permutation {

  // Complete the function below.
  public static List<String> letter_case_permutations(String str) {

    List<String> res = new ArrayList<>();
    // slate if list of char as we are only expecting one char at a time in the list
    List<Character> slate = new ArrayList<>();
    helper(str, 0, slate, res);
    return res;

  }

  // slate = partial solution passing to lower roots
  private static void helper(String str, int idx, List<Character>slate, List<String> res) {

    // recursion base case
    if (idx == str.length()) {
      StringBuilder sb = new StringBuilder();
      for(char ch : slate) {
        sb.append(ch);
      }
      res.add(sb.toString());
      return;
    }

    // recursive calls to delegate works to lower roots
    char ch = str.charAt(idx);

    // if letter -- lower case and upper case
    if (Character.isLetter(ch)) {
     
      slate.add(Character.toLowerCase(ch));
      helper(str, idx + 1, slate, res);
      slate.remove(slate.size()-1);
      
      slate.add(Character.toUpperCase(ch));
      helper(str, idx + 1, slate, res);
      slate.remove(slate.size()-1);

      // digit just add it to slate
    } else if (Character.isDigit(ch)) {

      slate.add(ch);
      //slate[index] = ch;

      helper(str, idx + 1, slate, res);
      slate.remove(slate.size()-1);
    }

  }

  public static void main(String[] args) {
    List<String> result = A1_Letter_Case_Permutation.letter_case_permutations("a1b2");
    System.out.println(" String permutations are: " + result);
  }

}
