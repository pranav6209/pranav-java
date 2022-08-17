/**
 * 
 */
package com.pranav.ik.A2Recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author pranavpatel
 * time and space class note
 *
 */
public class A6_C6_Words_From_Phone_Number {

  static String[] phNumber = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
  static List<String> res = new ArrayList<>();

  public static List<String> getWordsFromPhoneNumber(String phoneNumber) {
    // consider a string 101010101010
    phoneNumber = phoneNumber.replace("0", "").replace("1", "");
    if(phoneNumber.length()==0) {
      res.add("-1");
      return res;
    }
    // going forward from here, we ll not have 0 and 1. so, ll not have empty res 
    helper(phoneNumber, 0, new ArrayList<Character>());
    return res;
  }

  // Creating an util function for recursion with required parameters
  private static void helper(String phoneNumber, int index, List<Character> slate) {

    System.out.println("phoneNumber" + phoneNumber);
    if (index == phoneNumber.length()) {
      StringBuilder sb = new StringBuilder();
      for (char ch : slate) {
        sb.append(ch);
      }
      res.add(sb.toString());
      return;
    }

    // Get all the characters mapped from the following digit at current index
    // phoneNumber.charAt(index) will give a char and if we want int from that subtract 
    // ASCII of 0. look at the code for ASCII
    
    int element = phoneNumber.charAt(index)-'0';
    String str = phNumber[element];

    for (int i = 0; i < str.length(); i++) {
      slate.add(str.charAt(i));
      helper(phoneNumber, index + 1, slate);
      slate.remove(slate.size() - 1);
    }

  }

  public static void main(String[] args) {
    System.out.println(getWordsFromPhoneNumber("234"));
  }

}
