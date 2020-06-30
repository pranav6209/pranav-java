/**
 * 
 */
package com.pranav.code;

/**
 * @author pranavpatel
 *
 */
public class I_ASCII {

  public static void test() {

    char ch1 = 'A';
    char ch2 = 'B';

    int num1 = ch1;
    int num2 = ch2;

    System.out.println(num1);
    System.out.println(num2);

    // this converts to integer
    
    
    // first it gets ASCII value of 1 and then subtract ASCII value of zero

    // more explanations on is in backtracking letter combinations problem

    // https://stackoverflow.com/questions/12438336/why-we-use-0-beside-charati
    // get the char at index, convert to string , parse it to integer, retrieve from
    // mapping

    // https://beginnersbook.com/2019/04/java-char-to-int-conversion/
    
    //ASCII tabel
    //https://www.cs.cmu.edu/~pattis/15-1XX/common/handouts/ascii.html
    System.out.println('1' - '0');
    System.out.println('2' - '0');
    
    
    //Alos this
    
    //https://leetcode.com/problems/replace-the-substring-for-balanced-string/
  }

  public static void main(String[] args) {
    test();
  }
}
