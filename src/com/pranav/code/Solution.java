/**
 * 
 */
package com.pranav.code;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author pranavpatel
 *
 */
public class Solution {

  static void absSort(int[] array) {

    // Arrays.sort(array, (a, b) -> (Integer.compare(Math.abs(a), Math.abs(b))));
    /*
     * Stream.of(array) .forEach(a -> System.out.println(a));
     */

    Arrays.stream(array)
      .forEach(a -> System.out.print(a + ","));

    // for(int i=0;i<array.length;i++) {
    //
    // System.out.println(array[i]);
    // }
  }

  public static void main(String[] args) {

    absSort(new int[] { 3, 1, 7, 6, 2, 1 });

  }

}
