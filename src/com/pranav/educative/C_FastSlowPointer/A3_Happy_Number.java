/**
 * 
 */
package com.pranav.educative.C_FastSlowPointer;

/**
 * @author pranavpatel
 * 
 *   https://leetcode.com/problems/happy-number/
 * 
 * 
 * 
 * 
 * 
 *         time : O(logN) space : O(1)
 *
 */
public class A3_Happy_Number {

  public static boolean findHappyNumber(int num) {

    int slow = num;
    int fast = num;

    do {
      slow = findSquareSum(slow);
      fast = findSquareSum(findSquareSum(fast));
  
    } while (slow != fast); // found cycle

    return slow == 1; // check if cycle is stuck on 1

  }

  private static int findSquareSum(int num) {
    int sum = 0;
    int digit;
    while (num > 0) {

      digit = num % 10;
      sum = sum + (digit * digit);
      num = num / 10;

    }

    return sum;
  }

  public static void main(String[] args) {

    System.out.println(A3_Happy_Number.findHappyNumber(23));
    System.out.println(A3_Happy_Number.findHappyNumber(12));

  }

}
