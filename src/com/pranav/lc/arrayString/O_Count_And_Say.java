/**
 * 
 */
package com.pranav.lc.arrayString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author pranavpatel
 * 
 *         https://leetcode.com/submissions/detail/252422253/
 *
 */
public class O_Count_And_Say {

  static String countAndSay(int n) {

    // initialize sequence for for iteration 1

    StringBuilder prevSeq = new StringBuilder("1");

    // generating sequence for iteration 2 to n
    for (int i = 2; i <= n; i++) {

      // count the frequency of characters and append count and
      // character to the stringbuilder

      StringBuilder seq = new StringBuilder();

      for (int j = 0; j < prevSeq.length();) {

        char curr = prevSeq.charAt(j);

        int count = 0;

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

    List<Integer> sequancesToPrint = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    sequancesToPrint.stream()
      .map(O_Count_And_Say::countAndSay)
      .forEach(System.out::println);
    
    // int n = 5;
    // System.out.println(countAndSay(n));
  }

}
