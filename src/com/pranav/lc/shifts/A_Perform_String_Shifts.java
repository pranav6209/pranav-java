/**
 * 
 */
package com.pranav.lc.shifts;

/**
 * @author pranavpatel
 * 
 * 
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3299/
 *https://www.youtube.com/watch?v=sNH-f_5Gm0I
 */
public class A_Perform_String_Shifts {

  public String stringShift(String s, int[][] shift) {
    
    // abcdefg +3 efgabcd  -3 defgabc

    int shiftVal = 0;
    int strlen = s.length();
    String result = "";
    for (int i = 0; i < shift.length; i++) {
      if (shift[i][0] == 0) {
        shiftVal += (-shift[i][1]);
      }
      if (shift[i][0] == 1) {
        shiftVal += shift[i][1];
      }
    }
    shiftVal = shiftVal % strlen;
    // System.out.println("shiftVal="+shiftVal);
    if (shiftVal > 0) {
      // right shift from 1
      // 3 -- (4,3)+(0,4)
      result = s.substring(strlen - shiftVal, strlen) + s.substring(0, strlen - shiftVal);
    } else {
      // left shift--negative from 0
      // -3 -- (3,4)+(0,3)
      result = s.substring(-shiftVal, strlen) + s.substring(0, -shiftVal);
    }
    return result;

  }
}