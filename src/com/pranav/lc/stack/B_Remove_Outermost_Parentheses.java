/**
 * 
 */
package com.pranav.lc.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author pranavpatel
 * 
 * https://leetcode.com/problems/remove-outermost-parentheses/
 *
 */
public class B_Remove_Outermost_Parentheses {

  public static String removeOutermostParentheses(String s) {

    /*
     * 1. iterate over a string 
     * 2. '(' if stack is empty add it to stack else append to sb and increase the leftCount 
     * 3. for '(' , pop it from stack if leftCount== rightCount and if peek is not open bracket 
     * else add it sb and increase the rightCount
     * 
     * 
     * 
     */
    
    StringBuffer output = new StringBuffer();
    Stack<Character> stack = new Stack<>();
    int leftCount = 0, rightCount = 0;

    for (int i = 0; i < s.length(); i++) {

      if (s.charAt(i) == '(') {
        if (stack.isEmpty()) {
          stack.push('(');
        } else {
          output.append(s.charAt(i));
          leftCount++;
        }

      } else {

        if (stack.peek() != s.charAt(i) && leftCount == rightCount) {

          stack.pop();

        } else {

          output.append(s.charAt(i));
          rightCount++;
        }
      }

    }
    return output.toString();
  }

  public static void main(String[] args) {

    List<String> patterns = Arrays.asList("(()())(())", "(()())(())(()(()))", "()()");
    
  //  patterns.stream().forEach(pattern->System.out.println(pattern));
  //  patterns.stream().forEach(pattern->System.out.println(pattern));

    patterns.stream()
      .map(B_Remove_Outermost_Parentheses::removeOutermostParentheses)
      .forEach(System.out::println);

  }
}
