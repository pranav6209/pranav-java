/**
 * 
 */
package com.pranav.ik.A1Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author pranavpatel
 *
 */
public class B8_K_Closest_Point_Origin {

  public static List<List<Integer>> kClosest(List<List<Integer>> points, int k) {

    // for leetcode version, covert two dimension input array to List<List<Integer>

    List<List<Integer>> res = new ArrayList<>();
    helper(points, 0, points.size() - 1, k);

    // for leetcode version, covert res list to 2 dimensional array
    
    for (int i = 0; i < k; i++) {
      res.add(points.get(i));
    }

    return res;

  }

  // here we are sorting array based on the distance. closest to origin first so we are sorting array in asc order or natural order
  private static void helper(List<List<Integer>> points, int start, int end, int index) {

    if (start >= end)
      return;

    Random rand = new Random();
    int pivot_index = rand.nextInt(end - start + 1) + start;

    Collections.swap(points, start, pivot_index);

    int orange = start;
    for (int green = start + 1; green < end; green++) {

      if (compare(points.get(green), points.get(start))) {
        orange++;
        Collections.swap(points, green, orange);
      }

      Collections.swap(points, orange, start);

    }

    if (index == orange) {
      return;
    }

    if (index < orange) {
      helper(points, start, orange - 1, index);
    } else {
      helper(points, orange + 1, end, index);
    }
  }

  private static boolean compare(List<Integer> pt1, List<Integer> pt2) {

    int distance1 = (int) Math.sqrt(pt1.get(0) * pt1.get(0) + pt1.get(1) * pt1.get(1));
    int distance2 = (int) Math.sqrt(pt2.get(0) * pt2.get(0) + pt2.get(1) * pt2.get(1));

    return (distance1 < distance2);
  }

  public static int[][] kClosest1(int[][] points, int k) {

    // create a priority queue of a point and sort points based on the distance in the pq 
    PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0]
    - p1[1] * p1[1]);
    for (int[] p : points) {
      pq.offer(p);
      if (pq.size() > k) {
        pq.poll();
      }
    }
    
    // iterate priority queue and put that in to res array
    int[][] res = new int[k][2];
    while (k > 0) {
      res[--k] = pq.poll();
    }
    return res;

  }

  public static void main(String[] args) {

    List<List<Integer>> input = new ArrayList<>();
    // List<Integer> ip1 = new ArrayList<>();
    // ip1.add(3);
    // ip1.add(3);
    // List<Integer> ip2 = new ArrayList<>();
    // ip2.add(5);
    // ip2.add(-1);
    // List<Integer> ip3 = new ArrayList<>();
    // ip3.add(-2);
    // ip3.add(4);
    // input.add(ip1);
    // input.add(ip2);
    // input.add(ip3);

    List<Integer> ip1 = new ArrayList<>();
    ip1.add(1);
    ip1.add(3);
    List<Integer> ip2 = new ArrayList<>();
    ip2.add(-2);
    ip2.add(2);

    input.add(ip1);
    input.add(ip2);

    System.out.println(kClosest(input, 1));
  }

}
