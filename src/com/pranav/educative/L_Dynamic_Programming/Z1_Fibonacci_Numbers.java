/**
 * 
 */
package com.pranav.educative.L_Dynamic_Programming;

/**
 * @author pranavpatel 0, 1, 1, 2, 3, 5, 8,13 …
 */
public class Z1_Fibonacci_Numbers {

  private int CalculateFibonacci(int n) {

    if (n < 2)
      return n;

    int[] dp = new int[n + 1];

    dp[0] = 0;
    dp[1] = 1;

    for (int i = 2; i <= n; i++) {

      dp[i] = dp[i - 2] + dp[i - 1];

    }

    return dp[n];
  }

  public static void main(String[] args) {
    Z1_Fibonacci_Numbers fib = new Z1_Fibonacci_Numbers();
    System.out.println("5th Fibonacci is ---> " + fib.CalculateFibonacci(5));
    System.out.println("6th Fibonacci is ---> " + fib.CalculateFibonacci(6));
    System.out.println("7th Fibonacci is ---> " + fib.CalculateFibonacci(7));

  }
}
