/**
 * 
 */
package com.pranav.recurssion;

import java.util.ListIterator;
import java.util.Stack;

/**
 * @author pranavpatel
 *
 * 
 *         https://www.youtube.com/watch?v=8YXQ68oHjAs&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=9&ab_channel=AdityaVerma
 *
 */
public class A6_Reverse_Stack {

  static void reverseStack(Stack<Integer> stack) {
    if (stack.size() == 1) {
      return;
    }

    int temp = stack.peek();
    stack.pop();
    reverseStack(stack);
    insert(stack, temp);
  }

  static void insert(Stack<Integer> stack, int element) {

    if (stack.isEmpty()) {
      stack.push(element);
      return;
    }
    int temp = stack.peek();
    stack.pop();
    insert(stack, element);
    stack.push(temp);
    return;

  }

  static void printStack(Stack<Integer> s) {

    if (s.isEmpty())
      return;

    int x = s.peek();
    System.out.println(x);
    s.pop();
    printStack(s);

    s.push(x);
  }

  public static void main(String[] args) {

    Stack<Integer> stack = new Stack<>();

    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5);

    System.out.println("stack elements before Reversing");
    printStack(stack);
    reverseStack(stack);
    System.out.println("\n stack elements after sorting");
    printStack(stack);
  }

}
