/**
 * 
 */
package com.pranav.ik.A1Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * @author pranavpatel
 *
 */
public class A4_Top_K_Frequent_Element {

  static ArrayList<Integer> find_top_k_frequent_elements(ArrayList<Integer> arr, Integer k) {

    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < arr.size(); i++) {

      int currentElement = arr.get(i);
      if (map.containsKey(currentElement)) {
        map.put(currentElement, map.get(currentElement) + 1);
      } else {
        map.put(currentElement, 1);
      }

    }

    Set<Integer> set = map.keySet();

    ArrayList<Integer> list = new ArrayList<>(set.size());

    for (int ele : map.keySet()) {
      list.add(ele);
    }

    //System.out.println("map" + map);
    //System.out.println("list" + list);
    helper(list, 0, list.size() - 1, k, map);
    //System.out.println(list);
    ArrayList<Integer> res = new ArrayList<>();

    for (int i = 0; i < k; i++) {
      res.add(list.get(i));
    }

    return res;
  }

  private static void helper(ArrayList<Integer> list, int start, int end, int index, Map<Integer, Integer> map) {

    if (start >= end)
      return;

    Random rand = new Random();
    int pivot_index = rand.nextInt(end - start + 1) + start;

    Collections.swap(list, start, pivot_index);

    int orange = start;

    for (int green = start + 1; green <= end; green++) {

      int a1 = list.get(green);
      int a2 = list.get(start);
      int a3 = map.get(list.get(green));
      int a4 = map.get(list.get(start));

      if (map.get(list.get(green)) > map.get(list.get(start))) {
        orange++;
        Collections.swap(list, green, orange);
      }

    }
    Collections.swap(list, start, orange);

    if (index == orange)
      return;

    if (index < orange) {
      helper(list, start, orange - 1, index, map);
    } else {
      helper(list, orange + 1, start, index, map);
    }

  }

  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
//    list.add(7);
//    list.add(6);
//    list.add(7);
//    list.add(5);
//    list.add(8);
//    list.add(7);
//    list.add(5);
//    list.add(7);
//    list.add(6);
//    list.add(6);
    
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(2);
    list.add(4);
    list.add(3);
    list.add(1);

    System.out.println(find_top_k_frequent_elements(list, 2));
  }
}