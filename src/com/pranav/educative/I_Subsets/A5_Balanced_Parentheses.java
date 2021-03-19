/**
 * 
 */
package com.pranav.educative.I_Subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pranavpatel
 * 
 * recursion tree in educative
 *
 *  Educative for Time and Space
 */
public class A5_Balanced_Parentheses {
  public static List<String> generateValidParentheses(int n) {

    List<String> res = new ArrayList<>();
    int openCounter=0, closeCounter = 0;
    char[] parenthesesString = new char[2 * n];
    generateValidParenthesesRecursive(res, openCounter, closeCounter, n, parenthesesString,0);
    return res;

  }

  public static void generateValidParenthesesRecursive(List<String> res, int openCounter, int closeCounter, 
  int n,char[] parenthesesString, int index) {
    if (openCounter == n && closeCounter == n) {
      res.add(new String(parenthesesString));
    }
    if (openCounter < n) {
      parenthesesString[index] = '(';
      generateValidParenthesesRecursive(res, openCounter+1, closeCounter, n, parenthesesString, index+1);
    }
    if(closeCounter < openCounter) {
      parenthesesString[index] = ')';
      generateValidParenthesesRecursive(res, openCounter, closeCounter+1, n, parenthesesString, index+1);
      
    }

  }

  public static void main(String[] args) {
    List<String> result = A5_Balanced_Parentheses.generateValidParentheses(2);
    System.out.println("All combinations of balanced parentheses are: " + result);

    result = A5_Balanced_Parentheses.generateValidParentheses(3);
    System.out.println("All combinations of balanced parentheses are: " + result);
  }
}
