/**
 * 
 */
package com.pranav.ik.A1Sorting;

import java.util.ArrayList;

/**
 * @author pranavpatel
 * 
 *         https://leetcode.com/problems/merge-sorted-array/
 *         
 *         time : O(N+M)
 *         space : O(1)
 *
 */
public class A7_P3_Merge_Sorted_Array_Into_Another {

  static ArrayList<Integer> merge_one_into_another(ArrayList<Integer> first, ArrayList<Integer> second) {

    /*
     * start from tail of each list
     * 
     */

    // first array has n numbers
    int i = first.size() - 1;
    // second array has 2n numbers first n are positive and rest are 0s
    int j = first.size() - 1;

    // to get the last index with zeros. from where we want to start inserting an
    // elements.
    int pos = second.size() - 1;

    while (i >= 0 && j >= 0) {

      
      // we can combine first two steps to be
      //if (first.get(i) <= second.get(j)
      
      if (first.get(i) == second.get(j)) {
        second.set(pos, second.get(j));
        j--;
        pos--;
      } else if (first.get(i) < second.get(j)) {

        second.set(pos, second.get(j));
        j--;
        pos--;

      } else { // first.get(i) > second.get(j)
        second.set(pos, first.get(i));
        i--;
        pos--;
      }
    }

    // there is no need to check j >=0 condition as those elements are already in
    // the second array in sorted fashioned.
    while (i >= 0) {
      second.set(pos, first.get(i));
      i--;
      pos--;
    }

    return second;
  }

  public static void main(String[] args) {
    ArrayList<Integer> first = new ArrayList<>();
    first.add(1);
    first.add(3);
    first.add(5);

    ArrayList<Integer> second = new ArrayList<>();
    second.add(2);
    second.add(4);
    second.add(6);
    second.add(0);
    second.add(0);
    second.add(0);
    System.out.println(merge_one_into_another(first, second));

  }

}
