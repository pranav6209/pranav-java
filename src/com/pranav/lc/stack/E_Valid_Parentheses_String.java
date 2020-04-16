/**
 * 
 */
package com.pranav.lc.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author pranavpatel
 * 
 *         https://leetcode.com/problems/valid-parenthesis-string/
 * 
 *         code explanation https://www.youtube.com/watch?v=KuE_Cn3xhxI
 *         
 *          *time complexity O(n) - traversing array once
 *           space complexity O(n)
 *
 */
public class E_Valid_Parentheses_String {
  public static boolean checkValidString(String s) {

    Stack<Integer> charStack = new Stack<>();
    Stack<Integer> startStack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {

      char currenntCh = s.charAt(i);

      if (currenntCh == '(')
        charStack.push(i);
      else if (currenntCh == '*')
        startStack.push(i);
      // for closing brackets
      else {

        // if there is open bracket pop it.
        if (!charStack.isEmpty())
          charStack.pop();
        // if there is a * pop it.
        else if (!startStack.isEmpty())
          startStack.pop();
        // if there is no open bracket and no star there is no way this is a valid
        // string
        // )*() or (*)))
        else
          return false;

      }

    }

    // above should take care of all the closing brackets

    // iterate over open brackets indexes
    // if statStack is not empty, we ll use it as an empty string
    while (!charStack.isEmpty()) {

      if (startStack.isEmpty())
        return false;

      // if index of open bracke is less than star then only we can use star as a
      // closing.
      else if (charStack.peek() < startStack.peek()) {

        charStack.pop();
        startStack.pop();
      }

      else
        return false;

    }

    return true;

  }

  public static void main(String[] args) {

    /*
     * (*) -- T (*)) -- T )*() -- F *()) -- T **()) -- T
     */

    System.out.println(checkValidString("**((*"));

  }

}
