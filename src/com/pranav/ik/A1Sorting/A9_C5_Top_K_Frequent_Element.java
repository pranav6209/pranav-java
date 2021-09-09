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
 *  https://leetcode.com/problems/top-k-frequent-elements/
 * 
 *  After each iteration 
    1. pivot index will take the correct and place 
    2. element left side of the pivots are smaller than pivot and elements bigger than pivot are on right hand side 
      but it will be in unsorted manner 
      
      Here in this problem,our goal is to sort an array based on the frequency of an input array and index of interest is k
      so once array is sorted for the pivot-k, all the element to its right will be higher frequency element.  
     
 *
 */
public class A9_C5_Top_K_Frequent_Element {

  static ArrayList<Integer> find_top_k_frequent_elements(ArrayList<Integer> arr, Integer k) {

    // create frequency map of an input
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < arr.size(); i++) {

      int currentElement = arr.get(i);
      if (map.containsKey(currentElement)) {
        map.put(currentElement, map.get(currentElement) + 1);
      } else {
        map.put(currentElement, 1);
      }

    }

    // get all the keyset and create a list out of it/ 
    Set<Integer> set = map.keySet();

    ArrayList<Integer> list = new ArrayList<>(set.size());

    for (int ele : map.keySet()) {
      list.add(ele);
    }

    System.out.println("map" + map);
    System.out.println("original list" + list);
    
    helper(list, 0, list.size() - 1, k, map);
    //System.out.println("sorted list" + list);
    ArrayList<Integer> res = new ArrayList<>();
    
    
    // once index of interest is found all the elements before it has a higher frequency higher than it
    for (int i = 0; i < k; i++) {
      res.add(list.get(i));
    }

    return res;
  }

  
  // sort an input list based on frequency, here higher frequency numbers are at the front. Technically we are reverse sorting.
  private static void helper(ArrayList<Integer> list, int start, int end, int index, Map<Integer, Integer> map) {

    if (start >= end)
      return;

    Random rand = new Random();
    int pivot_index = rand.nextInt(end - start + 1) + start;

    Collections.swap(list, start, pivot_index);

    int orange = start;

    for (int green = start + 1; green <= end; green++) {

//      System.out.println("oranage" + list.get(orange));
//      System.out.println("start" + list.get(start));
//      System.out.println("green" + list.get(green));
//      System.out.println(map.get(list.get(start)));
//      System.out.println(map.get(list.get(green)));

      
      //sort an input list based on frequency, here higher frequency numbers are at the front
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
    list.add(7);
    list.add(6);
    list.add(7);
    list.add(5);
    list.add(8);
    list.add(7);
    list.add(5);
    list.add(7);
    list.add(6);
    list.add(6);

    // list.add(1);
    // list.add(2);
    // list.add(3);
    // list.add(2);
    // list.add(4);
    // list.add(3);
    // list.add(1);

    System.out.println(find_top_k_frequent_elements(list, 2));
  }
}