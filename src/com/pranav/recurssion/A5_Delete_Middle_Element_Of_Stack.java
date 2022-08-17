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
 *         https://www.youtube.com/watch?v=AZ4jEY_JAVc&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=6&ab_channel=AdityaVerma
 *
 */
public class
A5_Delete_Middle_Element_Of_Stack {

  static void deleteMiddleElement(Stack<Integer> stack, int k) {

    // base case when there is only one element, it is sorted
    if (k == 1) {
      stack.pop();
      return;
    }
    int temp = stack.pop();

    // hypothesis -- call on smaller i/p
    deleteMiddleElement(stack, k - 1);

    // induction -- put the last element back at correct place
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

    stack.push(0);
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5);

    int k = stack.size() / 2 + 1;

    System.out.println("stack elements before sorting");
    printStack(stack);
    deleteMiddleElement(stack, k);
    System.out.println("\n stack elements after sorting");
    printStack(stack);
  }

}
