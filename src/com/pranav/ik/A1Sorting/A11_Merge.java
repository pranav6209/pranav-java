/**
 * 
 */
package com.pranav.ik.A1Sorting;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pranavpatel
 *
 */
public class A11_Merge {
  static ArrayList<Integer> merge_one_into_another(ArrayList<Integer> first, ArrayList<Integer> second) {

    // Write your code here.

    int i = first.size() - 1;
    int j = first.size() - 1;
    int pos = second.size() - 1;

    System.out.println(i);
    System.out.println(j);
    System.out.println(pos);

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
