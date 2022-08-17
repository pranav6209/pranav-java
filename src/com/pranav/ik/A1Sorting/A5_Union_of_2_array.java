/**
 * 
 */
package com.pranav.ik.A1Sorting;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pranavpatel
 * 
 * code in live class note
 *
 * Merge vs Union
 *
 * for merge, every single number in both the array should go to the output array.
 * where union is a set. If number is in both array we put only once in res.
 *
 * [1,4,7,8]  [2,4,6,7,9]
 *
 * [1,2,4,6,7,8,9]
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

    // add remaining element from either arr1 or arr2
    while(i < arr1.get(i) ){
      res.add(arr1.get(i));
      i++;
    }

    while(j < arr2.get(j) ){
      res.add(arr2.get(j));
      j++;
    }

    return res;

  }

}
