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
public class PP2_Palindromic_Decomposition_Of_A_String {

  static String[] generate_palindromic_decompositions(String s) {

    List<String> res = new ArrayList<>();
    List<String> slate = new ArrayList<String>();
    helper(s, 0, slate, res);
    System.out.println("res"+res);
    return res.toArray(new String[res.size()]);

  }

  private static void helper(String str, int idx, List<String> slate, List<String> res) {

    if (idx == str.length()) {
      res.add(String.join("|",slate));
      return;

    }

    for (int i = idx; i < str.length(); i++) {

      String tempString = str.substring(idx, i + 1);

      if (isPalindromic(tempString)) {
        slate.add(tempString);
        helper(str, i + 1, slate, res);
        slate.remove(slate.size() - 1);// remove char 

      }

    }

  }

  private static boolean isPalindromic(String s) {

    int i = 0, j = s.length() - 1;

    while (i < j) {

      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }

      i++;
      j--;

    }

    return true;

  }
  
  public static void main(String[] args) {
    System.out.println("res"+generate_palindromic_decompositions("aab"));
  }
}

// abracadabra
