/**
 * 
 */
package com.pranav.lc.numbers;

import org.hamcrest.core.Is;

/**
 * @author pranavpatel https://leetcode.com/problems/happy-number/
 * 
 * https://www.youtube.com/watch?v=LUm2ABqAs1w&pbjreload=10
 * 
 * https://leetcode.com/problems/happy-number/discuss/56917/My-solution-in-C(-O(1)-space-and-no-magic-math-property-involved-)
 *
 */
public class A_HappyNumber {
  public static int digitSquareSum(int n) {

    int res = 0;
    while (n > 0) {

      int frac = n % 10;
      res += frac * frac;
      n = n / 10;

    }

    return res;
  }

  // floyd's cycle detection algo
  // https://www.youtube.com/watch?v=LUm2ABqAs1w&pbjreload=10

  public static boolean isHappy(int n) {
    int slow, fast;
    slow = fast = n;
    do {
      // as per floyd's slow iterate one poin and fast two, mimicing the same
      // by calling digitSquareSum(slow) once and digitSquareSum(fast) twice.
      slow = digitSquareSum(slow);
      fast = digitSquareSum(fast);
      fast = digitSquareSum(fast);
    } while (slow != fast);
    if (slow == 1)
      return true;
    else
      return false;

  }

  public static void main(String[] args) {
    System.out.println(isHappy(5555));
  }
}
