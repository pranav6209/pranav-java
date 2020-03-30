/**
 * 
 */
package com.pranav.code;

/**
 * @author pranavpatel
 *
 */
public class G_Recursion {

  public static int summation(int n) {
    // base case: at the end
    if (n <= 0)
      return 0;
    // recursive case: keep going
    else {

      /*
       * 3+ summation(2) 3+2+summation(1) 3+2+1+summation(0) 3+2+1+0
       * 
       */
      return n + summation(n - 1);

    }
  }

  public static int factorial(int n) {
    // base case: at the end
    if (n <= 1)
      return 1;
    // recursive case: keep going
    else {
      /*
       * 3* factorial(2) 3*2* factorial(1) 3*2*1
       * 
       */

      return n * factorial(n - 1);

    }

  }

  public static int exponentioal(int n, int p) {

    // base case
    if (p <= 0)
      return 1;
    // recursive case
    else {
      /*
       * 5* exponentioal(5,2)
       * 5* 5* exponentioal(5,1)
       * 5* 5* 5* exponentioal(5,0)
       * 5* 5* 5*1
       */
      return n * exponentioal(n, p - 1);

    }
  }

  public static void main(String[] args) {
    System.out.println(summation(3));
    System.out.println(factorial(3));
    System.out.println(exponentioal(5,3));
  }

}
