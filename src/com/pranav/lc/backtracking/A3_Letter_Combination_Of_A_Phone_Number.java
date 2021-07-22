/**
 * 
 */
package com.pranav.lc.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pranavpatel
 * 
 * 
 *         https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * 
 *         https://www.youtube.com/watch?v=21OuwqIC56E&t=23s
 * 
 *         https://github.com/kdn251/interviews/blob/master/leetcode/backtracking/LetterCombinationsOfAPhoneNumber.java
 *
 */
public class A3_Letter_Combination_Of_A_Phone_Number {

  public static List<String> letterCombinations(String phoneNumber) {
    List<String> result = new ArrayList<String>();

    if (phoneNumber == null || phoneNumber.length() == 0) {
      return result;
    }

    // ask that do they want to store map with array or map
    String[] mapping = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    dfs(result, phoneNumber, "", 0, mapping);

    return result;
  }

  public static void dfs(List<String> result, String digits, String current, int index,
  String[] mapping) {
    if (index == digits.length()) {
      result.add(current);
      return;
    }
    

    // [digits.charAt(index) returns 'char' and mapping are stores index based so it is an integer
    // [digits.charAt(index) - '0' converts it to integer and then retrieve it from mapping
     
    //String letters = mapping[digits.charAt(index) - '0'];
    
    
    // or get the char --> convert to String --> as Integer.parserInt(String str) --> accepts String
    
    

    String letters = mapping[Integer.parseInt(String.valueOf(digits.charAt(index)))];
    for (int i = 0; i < letters.length(); i++) {
      dfs(result, digits, current + letters.charAt(i), index + 1, mapping);
    }
  }

  public static void main(String[] args) {

    List<String> list = letterCombinations("234");
    System.out.println("list.size():- "+list.size());
    for (String str : list) {
      System.out.println(str);
    }
  }
}
