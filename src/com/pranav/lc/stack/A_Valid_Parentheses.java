/**
 * 
 */
package com.pranav.lc.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import com.pranav.company.A_Veeva;

/**
 * @author pranavpatel
 *
 */
public class A_Valid_Parentheses {

  public static boolean isValidParentheses(String s) {

    /*
     * () -- true ^ ()[]{} -- true (] -- false ([)] -- false ^
     */

    if (s.isEmpty())
      return true;

    Map<Character, Character> map = new HashMap<>();
    Stack<Character> stack = new Stack<>();

    map.put(')', '(');
    map.put('}', '{');
    map.put(']', '[');

    for (int i = 0; i < s.length(); i++) {
      Character ch = s.charAt(i);
      // checking only close brackets, open brackets push to stack directly
      if (map.containsKey(ch)) {
        if (stack.isEmpty() || stack.pop() != map.get(ch))
          return false;
      } else {
        stack.push(ch);
      }
    }
    //System.out.println(stack.isEmpty());
    return stack.isEmpty();
  }

  public static void main(String[] args) {

    List<String> patterns = Arrays.asList("()", "()[]{}", "(]", "([)] ");

    // two 1s, one 2, one 1
    // one 7, three 8s, one 2, two 1s
    // one 1, one 2, one 3, four 4s
    patterns.stream()
      .map(A_Valid_Parentheses::isValidParentheses)
      .forEach(System.out::println);

  }

}
