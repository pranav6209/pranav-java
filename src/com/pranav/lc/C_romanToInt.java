/**
 * 
 */
package com.pranav.lc;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pranavpatel
 * 
 * https://leetcode.com/problems/roman-to-integer/
 * 
 * Array -- Two Pointer 
 * Math
 * 
 * Here as we want to implement array till last index, with two pointer i and i+1 chance of array out of bound
 * 
 * so limiting for loop o length-1 and then calculating last index separately  
 * 
 */
public class C_romanToInt {

  public static int romanToInt(String s) {

    int result = 0;

    Map<Character, Integer> map = new HashMap<>();

    map.put('I', 1);
    map.put('V', 5);
    map.put('X', 10);
    map.put('L', 50);
    map.put('C', 100);
    map.put('D', 500);
    map.put('M', 1000);
   
    for (int i = 0; i < s.length() - 1; i++) {

      int val1 = map.get(s.charAt(i));
      int val2 = map.get((s.charAt(i + 1)));

      // make val1 negative if val2 > val1 and then add it result
      if (val2 > val1) {

        val1 = -val1;

      }

      result += val1;

    }

    // last index, as we are iterating length-1, always add to result.
    return result + map.get(s.charAt(s.length() - 1));

  }

  public static void main(String[] args) {

    System.out.println(romanToInt("IIIIII"));

  }

}
