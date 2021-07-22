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
 * 
 * Time Complexity:
 * Since a digit can have a maximum of 4 mappings, we’ll make 4 recursive calls per digit at most. This recursion can go up to 7 levels deep. Worst case time complexity is therefore O(4^7).
 * Auxiliary Space Used:
 * For each function call, constant space is used in the call stack. Since we can have a maximum of 4^n functions in the stack, the auxiliary space used is O(4^n).
 *
 */
public class A5_Words_From_Phone_Number {

  public static List<String> getWordsFromPhoneNumber(String phoneNumber) {

    // Creating a hashmap of digit mappings. storing as a char as when we string phoneNumber string, 
    // it will come as char
    Map<Character, String> digitMapping = new HashMap<>();

    digitMapping.put('2', "abc");
    digitMapping.put('3', "def");
    digitMapping.put('4', "ghi");
    digitMapping.put('5', "jkl");
    digitMapping.put('6', "mno");
    digitMapping.put('7', "pqrs");
    digitMapping.put('8', "tuv");
    digitMapping.put('9', "wxyz");

    List<String> result = new ArrayList<>();
    List<Character> slate = new ArrayList<>();

    // Since digits 0 and 1 map to no characters, remove them from the input string
    // as they have no effect on the output
    phoneNumber = phoneNumber.replace("0", "")
      .replace("1", "");
    if (phoneNumber.length() == 0) {
      result.add("-1");
    } else {
      getWordsFromPhoneNumberUtil(phoneNumber, result, digitMapping, 0, slate);
    }
    return result;
  }

  // Creating an util function for recursion with required parameters
  private static void getWordsFromPhoneNumberUtil(String phoneNumber, List<String> result,
  Map<Character, String> digitMapping, int currentIndex,List<Character> slate ) {

    if (currentIndex == phoneNumber.length()) {
    
      StringBuilder sb = new StringBuilder();
      for(char ch: slate) {
        sb.append(ch);
      }
      result.add(sb.toString());
      return;
    }

    // Get all the characters mapped from the following digit at current index
    String digits = digitMapping.get(phoneNumber.charAt(currentIndex));

    // Loop through all the characters and recurse for the next digit
    for (char digit : digits.toCharArray()) {
      slate.add(digit);
      getWordsFromPhoneNumberUtil(phoneNumber, result, digitMapping, currentIndex + 1,slate);
      // Backtrack by removing the current digit added and replacing it by the next
      // character in the loop
      slate.remove(slate.size()-1);
    }
  }
  public static void main(String[] args) {
    System.out.println(getWordsFromPhoneNumber("234"));
  }

}
