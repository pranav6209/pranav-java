/**
 * 
 */
package com.pranav.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author pranavpatel
 *
 */
public class A_Veeva {
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

    Map<Integer, String> map = new HashMap<>();

    map.put(1, "one");
    map.put(2, "two");
    map.put(3, "three");
    map.put(4, "four");
    map.put(5, "five");
    map.put(6, "six");
    map.put(7, "seven");
    map.put(8, "eight");
    map.put(9, "nine");
    map.put(0, "zero");

    String s = Integer.toString(n);
    StringBuffer sb = new StringBuffer();

    int count = 1;

    for (int j = 0; j < s.length() - 1; j++) {
      if (s.charAt(j) == s.charAt(j + 1)) {

        count++;

      } else {
        sb.append(map.get(count))
          .append(s.charAt(j));

        count = 1;

      }
    }

    return sb.append(map.get(count))
      .append(s.charAt(s.length() - 1))
      .toString();
  }

  public static void main(String[] args) {
    List<Integer> numbersToTranslate = Arrays.asList(1121, 7888211, 1234444);

    // two 1s, one 2, one 1
    // one 7, three 8s, one 2, two 1s
    // one 1, one 2, one 3, four 4s
    numbersToTranslate.stream()
      .map(A_Veeva::countAndSay)
      .forEach(System.out::println);
  }
}
