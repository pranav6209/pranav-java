/**
 * 
 */
package com.pranav.code;

/**
 * 
 *CTCI 
 *
 *also 
 *https://www.youtube.com/watch?v=UxICsjrdlJA&list=PL2_aWCzGMAwLz3g66WrxFGSXvSsvyfzCO&index=5
 * @author pranavpatel
 *
 */
public class H_Dyanmic_Programming {

  static int count = 0;
  static int count1 = 0;
  static int count2 = 0;

  public static int fibonacci(int n) {
    count++;
    if (n == 0)
      return 0;
    if (n == 1)
      return 1;
    return fibonacci(n - 1) + fibonacci(n - 2);

  }

  public static int fibonacciTopDown(int n) {
    return fibonacciTopDown(n, new int[n + 1]);

  }

  public static int fibonacciTopDown(int i, int[] memo) {
    count1++;
    if (i == 0 || i == 1)
      return i;

    //as we are initializing array of (n+1). all elements are zero.
    // memo[i]==0 means if that element is not yet calculated, calculate otherwise return from memo[]
    if (memo[i] == 0) {

      memo[i] = fibonacciTopDown(i - 1, memo) + fibonacciTopDown(i - 2, memo);
    }

    return memo[i];
  }

  public static int fibonacciBottomDown(int n) {
    count2++;
    // base cases 
    if (n == 0)
      return 0;
    if (n == 1)
      return 1;

    // initial assignment in dp []
    int[] dp = new int[n];
    
    dp[0]=0;
    dp[1]=1;

    for (int i = 2; i < n; i++) {

      // adding it to dp array
      dp[i] = dp[i - 1] + dp[i - 2];

    }

    // add last 2 of array
    return dp[n - 1] + dp[n - 2];

  }

  public static void main(String[] args) {
    // 1,1,2,3,5

    System.out.println("fibonacci:-" + fibonacci(5));
    System.out.println(count);
    System.out.println("fibonacciTopDown:-" + fibonacciTopDown(5));
    System.out.println(count1);
    System.out.println("fibonacciBottomDown:-" + fibonacciBottomDown(5));
    System.out.println(count2);
  }

}
