/**
 * 
 */
package com.pranav.lc.stack;

import java.util.Stack;

/**
 * @author pranavpatel
 *
 */
public class C_Backspace_String_Compare {

  public static boolean backspaceCompare(String S, String T) {

    char[] chs = S.toCharArray();
    char[] cht = T.toCharArray();
    Stack<Character> st1 = new Stack<>();
    Stack<Character> st2 = new Stack<>();
    for (int i = 0; i < chs.length; i++) {

      if (chs[i] == '#' && !st1.isEmpty()) {
        st1.pop();
      }
      if (chs[i] != '#') {
        st1.push(chs[i]);
      }

    }

    for (int j = 0; j < cht.length; j++) {

      if (cht[j] == '#' && !st2.isEmpty()) {
        st2.pop();
      }
      if (cht[j] != '#') {
        st2.push(cht[j]);
      }

    }
    return st2.equals(st1);
  }

  public static void main(String[] args) {

    // String S = "ab#c", T = "ad#c";
    // String S = "ab##", T = "c#d#";
    // String S = "a##c", T = "#a#c";
    // String S = "a#c", T = "b";
    // String S = "xywrrmp", T = "xywrrmu#p";
    String S = "y#fo##f", T = "y#f#o##f";

    System.out.println(backspaceCompare(S, T));
  }

}
