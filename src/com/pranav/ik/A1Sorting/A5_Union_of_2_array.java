/**
 * 
 */
package com.pranav.ik.A1Sorting;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pranavpatel
 * 
 *         code in live class note
 *
 */
public class A5_Union_of_2_array {

  private static List<Integer> union_two_array(List<Integer> arr1, List<Integer> arr2) {

    int i = 0, j = 0;

    List<Integer> res = new ArrayList<>();

    while (i < arr1.size() && j < arr2.size()) {

      if (arr1.get(i) == arr2.get(j)) {

        res.add(arr1.get(i));
        i++;
        j++;
      }

      else if (arr1.get(i) < arr2.get(j)) {
        res.add(arr1.get(i));
        i++;
      }

      else {
        res.add(arr1.get(j));
        j++;
      }

    }

    return res;

  }

}
