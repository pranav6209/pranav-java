/**
 * 
 */
package com.pranav.lc;

import java.util.Arrays;
import java.util.List;

/**
 * @author pranavpatel
 *
 */
public class ZZZZZ_codeground2 {
  /**
   * Count the digits in the number and return back a verbal description of the
   * results. The order of the digits must be preserved. For example: - 1 will be
   * written as "one 1" - 33 will be written as "two 3s" - 12331 will be written
   * as "one 1, one 2, two 3s, one 1"
   *
   * NOTE: For this example, assume we will have a maximum of four repeating
   * digits, but this can be any number in reality
   * 
   * @param number
   *          Number to read and translate
   * @return String containing the translated text of the number counting
   */
  private static String countAndSay(int n) {

    // initialize sequence for for iteration 1

    StringBuilder prevSeq = new StringBuilder("1");

    // generating sequence for iteration 2 to n
    for (int i = 2; i <= n; i++) {

      // count the frequency of characters and append count and
      // character to the stringbuilder

      StringBuilder seq = new StringBuilder();
      int count = 0;
      for (int j = 0; j < prevSeq.length();) {

        char curr = prevSeq.charAt(j);

        while (j < prevSeq.length() && curr == prevSeq.charAt(j)) {

          count++;
          j++;

        }

        seq.append(count)
          .append(curr);

      }

      // use generated sequence for next iteration
      prevSeq = seq;

    }
    // return nth iteration sequence
    return prevSeq.toString();

  }

  public static void main(String[] args) {
    System.out.println(countAndSay(5));
  }
}
