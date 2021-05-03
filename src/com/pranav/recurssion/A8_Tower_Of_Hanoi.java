/**
 * 
 */
package com.pranav.recurssion;

/**
 * @author pranavpatel
 * 
 *         https://leetcode.com/problems/k-th-symbol-in-grammar/submissions/
 * 
 *         https://www.youtube.com/watch?v=5P84A0YCo_Y&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=11
 * 
 *         https://www.tutorialspoint.com/java/java_basic_operators.htm
 *
 */
public class A8_Tower_Of_Hanoi {
  static int  count =0;
  public static void towerOfHanoi(int source, int dest, int helper, int n) {

    if (n == 1) {
      System.out.println("Move Disk 1 from: " + source + " to: " + dest);
      count++;
      return;
    }
    towerOfHanoi(source, helper, dest, n - 1);
    count++;
    System.out.println("Move Disk: " + n + "from: " + source + " to: " + dest);
    towerOfHanoi(helper, dest, source, n - 1);
    return;
  }

  public static void main(String[] args) {
    towerOfHanoi(1, 3, 2, 4);
    System.out.println("count:- " + count);
  }
}
