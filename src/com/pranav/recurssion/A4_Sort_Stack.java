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
public class A4_Sort_Stack {

  static void sortStackRecursive(Stack<Integer> stack) {
 
    // base case when there is only one element, it is sorted
    if (stack.size() == 1)
      return;

    
    int temp = stack.pop();

    // hypothesis -- call on smaller i/p
    sortStackRecursive(stack);
    
    // induction -- put the last element back at correct place
    sortedInsert(stack, temp);
    return;

  }

  static void sortedInsert(Stack<Integer> stack, int temp) {

    // base case -- if stack is empty or top element of the stack is bigger than temp element.
    if (stack.isEmpty() || stack.peek() <= temp) {
      stack.push(temp);
      return;
    }

    //
    int val = stack.pop();
    
    // hypothesis -- call on smaller i/p
    sortedInsert(stack, temp);
    
    stack.push(val);

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

//    stack.push(0);
//    stack.push(1);
//    stack.push(5);
//    stack.push(2);
    stack.push(30);
    stack.push(-5);
    stack.push(18);
    stack.push(14);
    stack.push(-3);

    System.out.println("stack elements before sorting");
    printStack(stack);
    sortStackRecursive(stack);
    System.out.println("\n stack elements after sorting");
    printStack(stack);
  }

}
