/**
 * 
 */
package com.pranav.lc.stackQueueHeap.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import com.pranav.company.A_Veeva;

/**
 * 
 * https://leetcode.com/problems/valid-parentheses/
 * @author pranavpatel
 *
 *
 *  time complexity O(N)
 *  
 *  
 *  space complexity O(N) as we are using hash and map
 *  
 *  as we push all opening brackets onto the stack and in the worst case, we will end up pushing all the brackets onto the stack. e.g. ((((((((((.
 */
public class A1_Valid_Parentheses {

  public static boolean isValidParentheses(String s) {

    /*
     * () -- true ^ ()[]{} -- true (] -- false ([)] -- false ^
     */

    if (s.isEmpty())
      return true;

    Map<Character, Character> map = new HashMap<>();
    Stack<Character> stack = new Stack<>();

    //0(1)
    map.put(')', '(');
    map.put('}', '{');
    map.put(']', '[');

    // O(N)
    for (int i = 0; i < s.length(); i++) {
      Character ch = s.charAt(i);
      // checking only close brackets, open brackets push to stack directly
      // all below operations are O(1)
      if (map.containsKey(ch)) {
        if (stack.isEmpty() || stack.pop() != map.get(ch))
          
          if(stack.isEmpty()) return false;
          if(stack.pop()!=map.get(ch)) return false;
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
      .map(A1_Valid_Parentheses::isValidParentheses)
      .forEach(System.out::println);

  }

}
