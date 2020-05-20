/**
 * 
 */
package com.pranav.lc.BitManipulation;

/**
 * @author pranavpatel
 * 
 *         Understanding bit https://www.youtube.com/watch?v=NLKQEOgBAnw&t=388s
 * 
 *         code explaination
 * 
 *         https://www.youtube.com/watch?v=-qrpJykY2gE
 *
 */
public class A_Bitwise_AND_Of_Numbers_Range {

  public int rangeBitwiseAnd(int m, int n) {

    int count = 0;

    while (m != n) {

      m >>= 1;
      n >>= 1;
      count = count + 1;

    }

    return m <<= count;
  }

}
