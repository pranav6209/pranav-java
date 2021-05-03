/**
 * 
 */
package com.pranav.recurssion;

/**
 * @author pranavpatel
 * 
 * https://leetcode.com/problems/k-th-symbol-in-grammar/submissions/
 * 
 * https://www.youtube.com/watch?v=5P84A0YCo_Y&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=11
 * 
 * https://www.tutorialspoint.com/java/java_basic_operators.htm
 *
 */
public class A7_Kth_Symbol_Grammer {
  public static int kthGrammar(int N, int K) {
    
    if(N==1 && K==1) return 0;

    int mid = (int) (Math.pow(2, N-1)/2);
    
    if(K<=mid) return kthGrammar(N-1, K);
    
    else return (kthGrammar(N-1, K-mid)^1);
    
  }

  public static void main(String[] args) {
    System.out.println(kthGrammar(4, 5));
  }
}
