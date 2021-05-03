/**
 * 
 */
package com.pranav.recurssion;

/**
 * @author pranavpatel
 * 
 * https://www.youtube.com/watch?v=Xu5RqPdABRE&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=3&ab_channel=AdityaVerma
 *
 */
public class A1_Print_1_to_N {

  public static void print1toN(int n) {

    // base condition
    if (n == 1) {
      System.out.println(1);
      return;
    }

    // hypothesis
    print1toN(n - 1);

    // induction
    System.out.println(n);

  }

  public static void printNto1(int n) {

    // base condition
    if (n == 1) {
      System.out.println(1);
      return;
    }

    // induction
    System.out.println(n);

    // hypothesis
    printNto1(n - 1);

  }

  public static void main(String[] args) {
    print1toN(5);
    System.out.println("");
    printNto1(5);
  }
}
