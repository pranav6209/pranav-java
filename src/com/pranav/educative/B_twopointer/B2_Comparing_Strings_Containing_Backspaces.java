/**
 * 
 */
package com.pranav.educative.B_twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author pranavpatel
 * 
 * https://leetcode.com/problems/backspace-string-compare/
 * 
 * 
 * time : O(S1+S2)
 * space  : O(1)
 *
 */
public class B2_Comparing_Strings_Containing_Backspaces {

  public static boolean compare(String str1, String str2) {

    Stack<Character> stack1 = new Stack<>();
    Stack<Character> stack2 = new Stack<>();

    for (int i = 0; i < str1.length(); i++) {

      char ch1 = str1.charAt(i);

      if (ch1 == '#') {

        if (!stack1.isEmpty())
          stack1.pop();

      } else
        stack1.push(ch1);

    }

    for (int j = 0; j < str2.length(); j++) {

      char ch2 = str2.charAt(j);

      if (ch2 == '#') {

        if (!stack2.isEmpty())
          stack2.pop();

      } else
        stack2.push(ch2);

    }

    return stack1.equals(stack2);
  }

  public static boolean compare1(String str1, String str2) {

    int i = str1.length() - 1;
    int j = str1.length() - 1;
    int countStr1 = 0;
    int countStr2 = 0;

    while (i > 0 || j > 0) {
      
      // here even if counter is still > 0, we will not decrement i further as i is index
      while (i > 0) {

        if (str1.charAt(i) == '#') {

          countStr1++;
          i--;

        } else if (countStr1 > 0) {
          countStr1--;
          i--;
        } else
          break;

      }

      while (j > 0) {

        if (str2.charAt(j) == '#') {

          countStr2++;
          j--;

        } else if (countStr2 > 0) {
          countStr2--;
          j--;
        } else
          break;

      }

      // If two actual characters are different
      // i,j should be >= 0 as we need to get char from that index
      if (i>= 0 && j>=0  &&  str1.charAt(i) != str2.charAt(j))
        return false;
      // if i is greater than 0 but j is not means string doesn't match
      if ((i >= 0) != (j >= 0))
        return false;
      
      // here when the first element is compare after that index decreases and goes to -1 that will break the loop 
      i--;
      j--;

    }
    return true;
  }

  public static void main(String[] args) {
//    System.out.println(B2_Comparing_Strings_Containing_Backspaces.compare1("xy#z", "xzz#"));
//    System.out.println(B2_Comparing_Strings_Containing_Backspaces.compare1("xy#z", "xyz#"));
//    System.out.println(B2_Comparing_Strings_Containing_Backspaces.compare1("xp#", "xyz##"));
//    System.out.println(B2_Comparing_Strings_Containing_Backspaces.compare1("xywrrmp", "xywrrmu#p"));
    System.out.println(B2_Comparing_Strings_Containing_Backspaces.compare1("ab##", "c#d#"));
  }

}
