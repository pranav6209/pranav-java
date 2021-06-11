/**
 * 
 */
package com.pranav.ik.A1Sorting;

import java.util.ArrayList;

/**
 * @author pranavpatel
 * 
 * https://leetcode.com/problems/merge-sorted-array/
 *
 */
public class PP4_Merge_Sorted_Array_Into_Another {

  static ArrayList<Integer> merge_one_into_another(ArrayList<Integer> first, ArrayList<Integer> second) {

    /*
     * start from tail of each list
     * 
     */

    // first array has n numbers
    int i = first.size() - 1;
    // second array has 2n numbers first n are positive and rest are 0s
    int j = i;

    // to get the last index with zeros. from where we want to start inseting an
    // elements.
    int pos = second.size() - 1;

    while (i >= 0 && j >= 0) {

      if (first.get(i) > second.get(j)) {

        second.set(pos, first.get(i));
        i--;

      } else {

        second.set(pos, second.get(j));
        j--;
      }

      pos--;

    }

    // there is no need to check j >=0 conidtion as those elements are already in
    // the second array in sored fashioned.
    while (i >= 0) {
      second.set(pos, first.get(i));
      i--;
      pos--;
    }

    return second;
  }

}
